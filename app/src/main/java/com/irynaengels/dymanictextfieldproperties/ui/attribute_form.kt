package com.irynaengels.dymanictextfieldproperties.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.irynaengels.dymanictextfieldproperties.LocalTextFieldViewModel
import com.irynaengels.dymanictextfieldproperties.model.propertiesList
import com.irynaengels.dymanictextfieldproperties.ui.input_fields.MyDropdownTextField
import com.irynaengels.dymanictextfieldproperties.ui.input_fields.MyManualTextField
import com.irynaengels.dymanictextfieldproperties.ui.theme.steagalFontFamily

@Composable
fun AttributeForm(navController: NavController) {
    val textFieldViewModel = LocalTextFieldViewModel.current
    val textFieldModel = textFieldViewModel.textFieldModel.collectAsState()
    val textFieldModels = textFieldViewModel.textFieldModels.collectAsState()
    val attributeList = listOf(
        "Input",
        "Content",
        "Font",
        "Fontsize",
        "TextColor clear",
        "TextColor Red",
        "TextColor Green",
        "TextColor Blue",
        "Label",
        "LabelColor clear",
        "LabelColor Red",
        "LabelColor Green",
        "LabelColor Blue",
        "BackgroundColor clear",
        "BackgroundColor Red",
        "BackgroundColor Green",
        "BackgroundColor Blue",
        "BorderWidth",
        "BorderColor clear",
        "BorderColor Red",
        "BorderColor Green",
        "BorderColor Blue",
        "BorderRadius",
        "ShadowColor clear",
        "ShadowColor Red",
        "ShadowColor Green",
        "ShadowColor Blue",
        "ShadowOffsetX",
        "ShadowOffsetY",
        "ShadowOpacity",
        "ShadowBlurRadius",
        "ShadowCornerRadius",
        "ShadowHeight",
        "ShadowWidth",
        "PositionX",
        "PositionY",
        "PositionXRel",
        "PositionYRel",
        "LineSpace",
        "Lines",
        "Scroll",
        "RimPadding",
        "LeftPadding",
        "RightPadding",
        "TopPadding",
        "BottomPadding",
        "TextAlign",
        "UnderlineThickness",
        "UnderlineColor Red",
        "UnderlineColor Green",
        "UnderlineColor Blue",
        "UrlText",
        "UrlLink",
        "UrlColor Red",
        "UrlColor Green",
        "UrlColor Blue",
        "UrlFont",
        "UrlFontSize",
        "Width",
        "Height",
        "MinHeight",
        "MaxStrokes",
        "SecureTextEntry",
        "KeyboardType",
        "InputFieldHeightDynamic",
        "Identifier",
        "FirstResponder",
        "NextResponder",
        "ExecutionDelay",

        "Add Text Field"
    )
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(attributeList) { index, attribute ->
                if (index == attributeList.size - 1) {
                    Button(modifier = Modifier
                        .padding(start = 16.dp),
                        onClick = {
                            val currentTextFieldModel = textFieldViewModel.textFieldModel.value

                            val textFieldModelToAdd = currentTextFieldModel.let { model ->
                                var updatedModel = model
                                if (model.fontSize == 0) {
                                    updatedModel = updatedModel.updateIndexedValue(3, "14")
                                }
                                if (model.shadowOpacity == -1f) {
                                    updatedModel = updatedModel.updateIndexedValue(29, "1.0")
                                }
                                updatedModel
                            }

                            textFieldViewModel.updateTextFieldModel(textFieldModelToAdd)
                            if (textFieldViewModel.textFieldModels.value.size < 3) {
                                textFieldViewModel.addTextFieldModel(textFieldModelToAdd)
                                textFieldViewModel.clearTextFieldModel()
                                navController.navigate(AttributeFormRoute)
                            }
                            if (textFieldViewModel.textFieldModels.value.size == 3) {
                                navController.navigate(PreviewRoute)
                            }
                        }) {
                        Text("Add Text Field")
                    }
                } else {
                    if ((index != 1 || !textFieldModel.value.input) &&
                        (index != 5 || !textFieldModel.value.textColorClear) &&
                        (index != 6 || !textFieldModel.value.textColorClear) &&
                        (index != 7 || !textFieldModel.value.textColorClear) &&
                        (index != 10 || !textFieldModel.value.labelColorClear) &&
                        (index != 11 || !textFieldModel.value.labelColorClear) &&
                        (index != 12 || !textFieldModel.value.labelColorClear) &&
                        (index != 14 || !textFieldModel.value.backgroundColorClear) &&
                        (index != 15 || !textFieldModel.value.backgroundColorClear) &&
                        (index != 16 || !textFieldModel.value.backgroundColorClear) &&
                        (index != 19 || !textFieldModel.value.borderColorClear) &&
                        (index != 20 || !textFieldModel.value.borderColorClear) &&
                        (index != 21 || !textFieldModel.value.borderColorClear) &&
                        (index != 24 || !textFieldModel.value.shadowColorClear) &&
                        (index != 25 || !textFieldModel.value.shadowColorClear) &&
                        (index != 26 || !textFieldModel.value.shadowColorClear) &&
                        (index != 27 || !textFieldModel.value.shadowColorClear) &&
                        (index != 28 || !textFieldModel.value.shadowColorClear) &&
                        (index != 29 || !textFieldModel.value.shadowColorClear) &&
                        (index != 30 || !textFieldModel.value.shadowColorClear) &&
                        (index != 31 || !textFieldModel.value.shadowColorClear) &&
                        (index != 32 || !textFieldModel.value.shadowColorClear) &&
                        (index != 33 || !textFieldModel.value.shadowColorClear) &&
                        (index != 51 || !textFieldModel.value.input) &&
                        (index != 52 || !textFieldModel.value.input)

                    ) {
                        AttributeInput(attribute = attribute, index = index)
                    }
                }
            }
        }

    }


}


@Composable
fun AttributeInput(attribute: String, index: Int) {
    val textFieldViewModel = LocalTextFieldViewModel.current
    val inputFieldProperties = propertiesList[index]
    val textFieldModel = textFieldViewModel.textFieldModel.collectAsState()

    Box(modifier = Modifier.padding(4.dp)) {
        Row(Modifier.fillMaxSize()) {
            Text(
                text = attribute,
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
            )
            if (inputFieldProperties.isDropdown) {

                MyDropdownTextField(
                    value = textFieldModel.value.indexToValue(index) ?: "",
                    items = inputFieldProperties.content,
                    onValueChange = { selectedKey ->
                        val newTextFieldModel =
                            textFieldModel.value.updateIndexedValue(index, selectedKey)
                        textFieldViewModel.updateTextFieldModel(newTextFieldModel)
                    },
                    label = "Select an item",
                    modifier = Modifier
                        .weight(3f)
                        .padding(end = 16.dp)
                        .align(Alignment.CenterVertically)
                )
            } else {
                MyManualTextField(
                    value = textFieldModel.value.indexToValue(index) ?: "",
                    onValueChange = {
                        val newTextFieldModel = textFieldModel.value.updateIndexedValue(index, it)
                        textFieldViewModel.updateTextFieldModel(newTextFieldModel)
                    },
                    modifier = Modifier
                        .weight(3f)
                        .padding(end = 16.dp)
                        .align(Alignment.CenterVertically),
                    keyboardType = inputFieldProperties.keyboardType
                )
            }
        }
    }
}