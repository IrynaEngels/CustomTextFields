package com.irynaengels.dymanictextfieldproperties.ui

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.max
import androidx.compose.ui.unit.sp
import com.irynaengels.dymanictextfieldproperties.LocalTextFieldViewModel
import com.irynaengels.dymanictextfieldproperties.model.Relation
import com.irynaengels.dymanictextfieldproperties.model.TextFieldModel
import com.irynaengels.dymanictextfieldproperties.model.propertiesList
import com.irynaengels.dymanictextfieldproperties.ui.theme.steagalFontFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
import androidx.compose.ui.text.TextPainter

@OptIn(ExperimentalTextApi::class, ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    textFieldModel: TextFieldModel,
    modifier: Modifier,
    focusRequesters: MutableMap<String, FocusRequester>,
    onTextChanged: (String) -> Unit
) {
    val cornerShape = RoundedCornerShape(textFieldModel.cornerRadius.dp)
    val isFocused = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    focusRequesters[textFieldModel.identifier] = focusRequester
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    val paddingWidth = 4.dp
    val paddingHeight = 4.dp

    val effectiveLeftPadding =
        if (textFieldModel.leftPadding == -1) textFieldModel.rimPadding else textFieldModel.leftPadding
    val effectiveRightPadding =
        if (textFieldModel.rightPadding == -1) textFieldModel.rimPadding else textFieldModel.rightPadding
    val effectiveTopPadding = if (textFieldModel.topPadding == -1) textFieldModel.rimPadding else textFieldModel.topPadding
    val effectiveBottomPadding =
        if (textFieldModel.bottomPadding == -1) textFieldModel.rimPadding else textFieldModel.bottomPadding
    val context = LocalContext.current
    val labelLayoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    val clickedUrl = remember { mutableStateOf<String?>(null) }

    val calculatedWidth = remember { mutableStateOf(0) }
    val calculatedHeight = remember { mutableStateOf(0) }


    val paddingWidthPx = with(LocalDensity.current) { paddingWidth.toPx().roundToInt() }
    val calculatedWidthPx = calculatedWidth.value

    val newMaxWidth = calculatedWidthPx - 2 * paddingWidthPx

    val content = textFieldModel.content
    val annotatedString = buildAnnotatedString {
        val startIndex = content.indexOf(textFieldModel.urlText)
        val endIndex = startIndex + textFieldModel.urlText.length
        if (startIndex != -1) {
            append(content.substring(0, startIndex))
            withStyle(
                style = SpanStyle(
                    color = Color(
                        textFieldModel.urlTextColorRed,
                        textFieldModel.urlTextColorGreen,
                        textFieldModel.urlTextColorBlue
                    ),
                    fontFamily = steagalFontFamily,
                    fontSize = textFieldModel.urlFontSize.sp,
                    fontWeight = textFieldModel.urlFont,
                )
            ) {
                withAnnotation(tag = "URL", textFieldModel.urlLink) {
                    append(content.substring(startIndex, endIndex))
                }
            }
            append(content.substring(endIndex))
        } else {
            append(content)
        }
    }

    if (textFieldModel.maxStrokes == 0) {
        textFieldModel.nextResponder?.let { nextIdentifier ->
            focusRequesters[nextIdentifier]?.requestFocus()
        }
    }

    LaunchedEffect(clickedUrl.value) {
        clickedUrl.value?.let { url ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    }

    LaunchedEffect(textFieldModel.firstResponder) {
        if (textFieldModel.firstResponder) {
            focusRequester.requestFocus()
        }
    }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(calculatedWidth.value.dp)
                .height(calculatedHeight.value.dp)
                .advancedShadow(
                    color = if (textFieldModel.shadowColorClear) Color.Transparent else Color(
                        textFieldModel.shadowColorRed,
                        textFieldModel.shadowColorGreen,
                        textFieldModel.shadowColorBlue
                    ),
                    offsetX = textFieldModel.shadowOffsetX.dp,
                    offsetY = textFieldModel.shadowOffsetY.dp,
                    blurRadius = textFieldModel.shadowBlurRadius.dp,
                    opacity = textFieldModel.shadowOpacity,
                    borderRadius = textFieldModel.cornerRadius.dp,
                    height = textFieldModel.shadowHeight.dp,
                    width = textFieldModel.shadowWidth.dp
                )
                .background(
                    color = if (textFieldModel.backgroundColorClear) Color.Transparent else Color(
                        textFieldModel.backgroundColorRed,
                        textFieldModel.backgroundColorGreen,
                        textFieldModel.backgroundColorBlue
                    ),
                    shape = cornerShape
                )

        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .border(
                    width = textFieldModel.borderWidth.dp,
                    color = if (textFieldModel.borderColorClear) Color.Transparent else Color(
                        textFieldModel.borderColorRed,
                        textFieldModel.borderColorGreen,
                        textFieldModel.borderColorBlue
                    ),
                    shape = cornerShape
                )
        )

        Layout(
            modifier = Modifier.padding(
                start = effectiveLeftPadding.dp,
                end = effectiveRightPadding.dp,
                top = effectiveTopPadding.dp,
                bottom = effectiveBottomPadding.dp
            ),
            content = {
                if (textFieldModel.input) {
                    TextFieldScroller(
                        enabled = textFieldModel.scroll,
                        modifier = modifier
                    ) {

                        BasicTextField(
                            value = textFieldModel.content,
                            onValueChange = { newValue ->
                                onTextChanged(newValue)
                                if (textFieldModel.secureTextEntry) Log.d(
                                    "TAG",
                                    "Printed text: $newValue"
                                )
                                if (newValue.length == textFieldModel.maxStrokes) {
                                    textFieldModel.nextResponder?.let { nextIdentifier ->
                                        focusRequesters[nextIdentifier]?.requestFocus()
                                    }
                                    if (textFieldModel.executionDelay > 0) {
                                        scope.launch {
                                            delay((textFieldModel.executionDelay * 1000).toLong())
                                            Log.d("TAG", "Printed text: $newValue")
                                        }
                                    }
                                }
                            },
                            onTextLayout = { labelLayoutResult.value = it },
                            singleLine = textFieldModel.lines == 1,
                            textStyle = TextStyle(
                                color = if (textFieldModel.textColorClear) Color.Transparent else Color(
                                    textFieldModel.textColorRed,
                                    textFieldModel.textColorGreen,
                                    textFieldModel.textColorBlue,
                                ),
                                fontFamily = steagalFontFamily,
                                fontSize = textFieldModel.fontSize.sp,
                                fontWeight = textFieldModel.font,
                                lineHeight = textFieldModel.lineSpace.sp,
                                textAlign = textFieldModel.textAlign,
                            ),
                            maxLines = textFieldModel.lines,
                          //  overflow = TextOverflow.Ellipsis,
                            visualTransformation = if (textFieldModel.secureTextEntry) PasswordVisualTransformation() else VisualTransformation.None,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = textFieldModel.keyboardType),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    textFieldModel.nextResponder?.let { nextIdentifier ->
                                        focusRequesters[nextIdentifier]?.requestFocus()
                                    }
                                }
                            ),
                            modifier = Modifier
                                .matchParentSize()
                                .focusRequester(focusRequester)
                                .onFocusChanged { isFocused.value = it.isFocused }
                                .width(newMaxWidth.dp)
                        )
                    }
                    if (textFieldModel.label.isNotEmpty() && !isFocused.value && textFieldModel.content.isEmpty()) {
                        Text(
                            text = textFieldModel.label,
                            onTextLayout = { labelLayoutResult.value = it },
                            style = TextStyle(
                                color = if (textFieldModel.labelColorClear) Color.Transparent else Color(
                                    textFieldModel.labelColorRed,
                                    textFieldModel.labelColorGreen,
                                    textFieldModel.labelColorBlue
                                ),
                                fontFamily = steagalFontFamily,
                                fontSize = textFieldModel.fontSize.sp,
                                fontWeight = textFieldModel.font,
                                textAlign = textFieldModel.textAlign
                            ),
                        )
                    }
                } else {
                    Text(
                        text = annotatedString,
                        style = TextStyle(
                            color = if (textFieldModel.textColorClear) Color.Transparent else Color(
                                textFieldModel.textColorRed,
                                textFieldModel.textColorGreen,
                                textFieldModel.textColorBlue,
                            ),
                            fontFamily = steagalFontFamily,
                            fontSize = textFieldModel.fontSize.sp,
                            fontWeight = textFieldModel.font,
                            textAlign = textFieldModel.textAlign
                        ),
                        maxLines = textFieldModel.lines,
                        overflow = TextOverflow.Ellipsis,
                        onTextLayout = { labelLayoutResult.value = it },
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = { position ->
                                        labelLayoutResult.value.let { textLayoutResult ->
                                            val characterOffset =
                                                textLayoutResult?.getOffsetForPosition(position)
                                            annotatedString
                                                .getStringAnnotations(
                                                    "URL",
                                                    characterOffset!!,
                                                    characterOffset
                                                )
                                                .firstOrNull()
                                                ?.let { annotation ->
                                                    clickedUrl.value = annotation.item
                                                }
                                        }
                                    }
                                )
                            }
                            .drawBehind {
                                labelLayoutResult.value?.let {
                                    val startIndex =
                                        annotatedString.text.indexOf(textFieldModel.urlText)
                                    val endIndex = startIndex + textFieldModel.urlText.length - 1

                                    if (startIndex != -1) {
                                        val startBoundingBox =
                                            labelLayoutResult.value?.getBoundingBox(startIndex)
                                        val endBoundingBox =
                                            labelLayoutResult.value?.getBoundingBox(endIndex)

                                        val offsetY = 6f
                                        val thickness = textFieldModel.underlineThickness.toFloat()

                                        drawLine(
                                            color = Color(
                                                textFieldModel.underlineColorRed,
                                                textFieldModel.underlineColorGreen,
                                                textFieldModel.underlineColorBlue
                                            ),
                                            start = Offset(
                                                startBoundingBox!!.left,
                                                startBoundingBox.bottom + offsetY
                                            ),
                                            end = Offset(
                                                endBoundingBox!!.right,
                                                endBoundingBox.bottom + offsetY
                                            ),
                                            strokeWidth = thickness
                                        )
                                    }
                                }
                            }
                    )
                }
            },
            measurePolicy = { measurables, constraints ->
                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints)
                }
                val textField = placeables[0]
                val label = placeables.getOrNull(1)

                val calculatedDefaultHeight = calculateHeight(
                    labelLayoutResult.value!!,
                    textFieldModel,
                    paddingHeight.roundToPx()
                )
                val height =
                    max(calculatedDefaultHeight, label?.height ?: 0) + 2 * paddingHeight.roundToPx()
                /* val width = max(
                     textField.width,
                     label?.width ?: 0
                 ) + 2 * paddingWidth.roundToPx()*/
                val width = textFieldModel.width + 2 * paddingWidth.roundToPx()
                layout(width, height) {
                    calculatedWidth.value = width
                    calculatedHeight.value = height

                    textField.place(paddingWidth.roundToPx(), paddingHeight.roundToPx())
                    label?.place(paddingWidth.roundToPx(), paddingHeight.roundToPx())
                }
            }
        )
    }
}

fun calculateHeight(
    layout: TextLayoutResult,
    textFieldModel: TextFieldModel,
    paddingHeight: Int
): Int {

    val lineHeight = layout.layoutInput.style.lineHeight.value.toInt()
    val maxContentHeight = (textFieldModel.lines * lineHeight).toInt()
    val calculatedHeight = (layout.size.height + 2 * paddingHeight).coerceAtMost(maxContentHeight)

    return when {
        textFieldModel.height != 0 -> textFieldModel.height
        textFieldModel.minHeight > calculatedHeight && textFieldModel.inputFieldHeightDynamic -> textFieldModel.minHeight
        else -> calculatedHeight
    }
}








