package com.irynaengels.dymanictextfieldproperties.model

import android.util.Log
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

data class TextFieldModel(
    val input: Boolean = true,
    val content: String,
    val font: FontWeight = FontWeight.Normal,
    val fontSize: Int = 0,
    val textColorClear: Boolean = false,
    val textColorRed: Int = -1,
    val textColorGreen: Int = -1,
    val textColorBlue: Int = -1,
    val label: String = "",
    val labelColorClear: Boolean = false,
    val labelColorRed: Int = -1,
    val labelColorGreen: Int = -1,
    val labelColorBlue: Int = -1,
    val backgroundColorClear: Boolean = false,
    val backgroundColorRed: Int = 100,
//    val backgroundColorRed: Int = -1,
    val backgroundColorGreen: Int = -1,
    val backgroundColorBlue: Int = -1,
    val borderWidth: Int = 0,
    val borderColorClear: Boolean = false,
    val borderColorRed: Int = -1,
    val borderColorGreen: Int = -1,
    val borderColorBlue: Int = -1,
    val cornerRadius: Int = 0,
    val shadowColorClear: Boolean = false,
    val shadowColorRed: Int = -1,
    val shadowColorGreen: Int = -1,
    val shadowColorBlue: Int = -1,
    val shadowOffsetX: Int = 0,
    val shadowOffsetY: Int = 0,
    val shadowOpacity: Float = -1f,
    val shadowBlurRadius: Int = 0,
    val shadowCornerRadius: Int = 0,
    val shadowHeight: Int = 0,
    val shadowWidth: Int = 0,
    val positionX: Float = 0f,
    val positionY: Float = 0f,
    val positionXRel: Relation = Relation.START,
    val positionYRel: Relation = Relation.START,
    val lineSpace: Int = 0,
    val lines: Int = 1,
    val scroll: Boolean = false,
    val rimPadding: Int = 0,
    val leftPadding: Int = -1,
    val rightPadding: Int = -1,
    val topPadding: Int = -1,
    val bottomPadding: Int = -1,
    val textAlign: TextAlign = TextAlign.Left,
    val underlineThickness: Int = 0,
    val underlineColorRed: Int = -1,
    val underlineColorGreen: Int = -1,
    val underlineColorBlue: Int = -1,
    val urlText: String = "",
    val urlLink: String = "",
    val urlTextColorRed: Int = -1,
    val urlTextColorGreen: Int = -1,
    val urlTextColorBlue: Int = -1,
    val urlFont: FontWeight = FontWeight.Normal,
    val urlFontSize: Int = 0,
    val width: Int = 50,
//    val width: Int = 0,
    val height: Int = 0,
    val minHeight: Int = 0,
    val maxStrokes: Int = 0,
    val secureTextEntry: Boolean = false,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val inputFieldHeightDynamic: Boolean = false,

    val identifier: String = "",
    val firstResponder: Boolean = false,
    val nextResponder: String? = null,
    val executionDelay: Float = -1f
) {
    fun indexToValue(index: Int): String? {
        return when (index) {
            0 -> propertiesList[index].content.filterValues { it == input }.keys.firstOrNull()
            1 -> content
            2 -> propertiesList[index].content.filterValues { it == font }.keys.firstOrNull()
            3 -> if (fontSize == 0) "" else fontSize.toString()
            4 -> propertiesList[index].content.filterValues { it == textColorClear }.keys.firstOrNull()
            5 -> if (textColorRed == -1) "" else textColorRed.toString()
            6 -> if (textColorGreen == -1) "" else textColorGreen.toString()
            7 -> if (textColorBlue == -1) "" else textColorBlue.toString()
            8 -> label
            9 -> propertiesList[index].content.filterValues { it == labelColorClear }.keys.firstOrNull()
            10 -> if (labelColorRed == -1) "" else labelColorRed.toString()
            11 -> if (labelColorGreen == -1) "" else labelColorGreen.toString()
            12 -> if (labelColorBlue == -1) "" else labelColorBlue.toString()
            13 -> propertiesList[index].content.filterValues { it == backgroundColorClear }.keys.firstOrNull()
            14 -> if (backgroundColorRed == -1) "" else backgroundColorRed.toString()
            15 -> if (backgroundColorGreen == -1) "" else backgroundColorGreen.toString()
            16 -> if (backgroundColorBlue == -1) "" else backgroundColorBlue.toString()
            17 -> if (borderWidth == 0) "" else borderWidth.toString()
            18 -> propertiesList[index].content.filterValues { it == borderColorClear }.keys.firstOrNull()
            19 -> if (borderColorRed == -1) "" else borderColorRed.toString()
            20 -> if (borderColorGreen == -1) "" else borderColorGreen.toString()
            21 -> if (borderColorBlue == -1) "" else borderColorBlue.toString()
            22 -> if (cornerRadius == 0) "" else cornerRadius.toString()
            23 -> propertiesList[index].content.filterValues { it == shadowColorClear }.keys.firstOrNull()
            24 -> if (shadowColorRed == -1) "" else shadowColorRed.toString()
            25 -> if (shadowColorGreen == -1) "" else shadowColorGreen.toString()
            26 -> if (shadowColorBlue == -1) "" else shadowColorBlue.toString()
            27 -> if (shadowOffsetX == 0) "" else shadowOffsetX.toString()
            28 -> if (shadowOffsetY == 0) "" else shadowOffsetY.toString()
            29 -> if (shadowOpacity == -1f) "" else shadowOpacity.toString()
            30 -> if (shadowBlurRadius == 0) "" else shadowBlurRadius.toString()
            31 -> if (shadowCornerRadius == 0) "" else shadowCornerRadius.toString()
            32 -> if (shadowHeight == 0) "" else shadowHeight.toString()
            33 -> if (shadowWidth == 0) "" else shadowWidth.toString()
            34 -> if (positionX == 0f) "" else positionX.toString()
            35 -> if (positionY == 0f) "" else positionY.toString()
            36 -> propertiesList[index].content.filterValues { it == positionXRel }.keys.firstOrNull()
            37 -> propertiesList[index].content.filterValues { it == positionYRel }.keys.firstOrNull()
            38 -> lineSpace.toString()
            39 -> lines.toString()
            40 -> propertiesList[index].content.filterValues { it == scroll }.keys.firstOrNull()
            41 -> rimPadding.toString()
            42 -> if (leftPadding == -1) "" else leftPadding.toString()
            43 -> if (rightPadding == -1) "" else rightPadding.toString()
            44 -> if (topPadding == -1) "" else topPadding.toString()
            45 -> if (bottomPadding == -1) "" else bottomPadding.toString()
            46 -> propertiesList[index].content.filterValues { it == textAlign }.keys.firstOrNull()
            47 -> underlineThickness.toString()
            48 -> if (underlineColorRed == -1) "" else underlineColorRed.toString()
            49 -> if (underlineColorGreen == -1) "" else underlineColorGreen.toString()
            50 -> if (underlineColorBlue == -1) "" else underlineColorBlue.toString()
            51 -> urlText
            52 -> urlLink
            53 -> if (urlTextColorRed == -1) "" else urlTextColorRed.toString()
            54 -> if (urlTextColorGreen == -1) "" else urlTextColorGreen.toString()
            55 -> if (urlTextColorBlue == -1) "" else urlTextColorBlue.toString()
            56 -> propertiesList[index].content.filterValues { it == urlFont }.keys.firstOrNull()
            57 -> if (urlFontSize == 0) "" else urlFontSize.toString()
            58 -> width.toString()
            59 -> height.toString()
            60 -> minHeight.toString()
            61 -> maxStrokes.toString()
            62 -> propertiesList[index].content.filterValues { it == secureTextEntry }.keys.firstOrNull()
            63 -> propertiesList[index].content.filterValues { it == keyboardType }.keys.firstOrNull()
            64 -> propertiesList[index].content.filterValues { it == inputFieldHeightDynamic }.keys.firstOrNull()
            65 -> identifier
            66 -> propertiesList[index].content.filterValues { it == firstResponder }.keys.firstOrNull()
            67 -> nextResponder ?: ""
            68 -> if (executionDelay == -1f) "" else executionDelay.toString()
            else -> ""
        }
    }

    fun updateIndexedValue(index: Int, value: Any?): TextFieldModel {
        Log.d("TextFieldModel", "updateIndexedValue: $index, $value")
        return when (index) {
            0 -> updateInput(value as Boolean)
            1 -> updateContent(value as String)
            2 -> updateFont(value as FontWeight)
            3 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateFontSize(intValue)
            }
            4 -> updateTextColorClear(value as Boolean)
            5 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateTextColorRed(intValue)
            }
            6 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateTextColorGreen(intValue)
            }
            7 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateTextColorBlue(intValue)
            }
            8 -> updateLabel(value as String)
            9 -> updateLabelColorClear(value as Boolean)
            10 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateLabelColorRed(intValue)
            }
            11 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateLabelColorGreen(intValue)
            }
            12 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateLabelColorBlue(intValue)
            }
            13 -> updateBackgroundColorClear(value as Boolean)
            14 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBackgroundColorRed(intValue)
            }
            15 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBackgroundColorGreen(intValue)
            }
            16 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBackgroundColorBlue(intValue)
            }
            17 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBorderWidth(intValue)
            }
            18 -> updateBorderColorClear(value as Boolean)
            19 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBorderColorRed(intValue)
            }
            20 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBorderColorGreen(intValue)
            }
            21 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateBorderColorBlue(intValue)
            }
            22 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateCornerRadius(intValue)
            }
            23 -> updateShadowColorClear(value as Boolean)
            24 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowColorRed(intValue)
            }
            25 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowColorGreen(intValue)
            }
            26 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowColorBlue(intValue)
            }
            27 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowOffsetX(intValue)
            }
            28 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowOffsetY(intValue)
            }
            29 -> {
                val floatValue = try {
                    (value as String).toFloat()
                } catch (e: NumberFormatException) {
                    0f
                }
                updateShadowOpacity(floatValue)
            }
            30 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowBlurRadius(intValue)
            }
            31 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowCornerRadius(intValue)
            }
            32 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowHeight(intValue)
            }
            33 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateShadowWidth(intValue)
            }
            34 -> {
                val floatValue = try {
                    (value as String).toFloat()
                } catch (e: NumberFormatException) {
                    0f
                }
                updatePositionX(floatValue)
            }
            35 -> {
                val floatValue = try {
                    (value as String).toFloat()
                } catch (e: NumberFormatException) {
                    0f
                }
                updatePositionY(floatValue)
            }
            36 -> updatePositionXRel(value as Relation)
            37 -> updatePositionYRel(value as Relation)
            38 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }
                updateLineSpace(intValue)
            }
            39 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    1
                }
                updateLines(intValue)
            }
            40 -> updateScroll(value as Boolean)
            41 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateRimPadding(intValue)
            }
            42 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateLeftPadding(intValue)
            }
            43 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateRightPadding(intValue)
            }
            44 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateTopPadding(intValue)
            }
            45 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateBottomPadding(intValue)
            }
            46 -> updateTextAlign(value as TextAlign)
            47 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateUnderlineThickness(intValue)
            }
            48 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUnderlineColorRed(intValue)
            }
            49 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUnderlineColorGreen(intValue)
            }
            50 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUnderlineColorBlue(intValue)
            }
            51 -> updateUrlText(value as String)
            52 -> updateUrlLink(value as String)
            53 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUrlTextColorRed(intValue)
            }
            54 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUrlTextColorGreen(intValue)
            }
            55 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    -1
                }

                updateUrlTextColorBlue(intValue)
            }
            56 -> updateUrlFont(value as FontWeight)
            57 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateUrlFontSize(intValue)
            }

            58 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateWidth(intValue)
            }
            59 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateHeight(intValue)
            }
            60 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateMinHeight(intValue)
            }
            61 -> {
                val intValue = try {
                    (value as String).toInt()
                } catch (e: NumberFormatException) {
                    0
                }

                updateMaxStrokes(intValue)
            }
            62 -> updateSecureTextEntry(value as Boolean)
            63 -> updateKeyboardType(value as KeyboardType)
            64 -> updateInputFieldHeightDynamic(value as Boolean)
            65 -> updateIdentifier(value as String)
            66 -> updateFirstResponder(value as Boolean)
            67 -> updateNextResponder(value as String?)
            68 -> {
                val floatValue = try {
                    (value as String).toFloat()
                } catch (e: NumberFormatException) {
                    -1f
                }
                updateExecutionDelay(floatValue)
            }
            else -> this
        }
    }

    private fun updateInput(newInput: Boolean): TextFieldModel {
        return copy(input = newInput)
    }

    fun updateContent(newContent: String): TextFieldModel {
        return copy(content = newContent)
    }

    private fun updateFont(newFont: FontWeight): TextFieldModel {
        return copy(font = newFont)
    }

    private fun updateFontSize(newFontSize: Int): TextFieldModel {
        return copy(fontSize = newFontSize)
    }

    private fun updateTextColorClear(newTextColorClear: Boolean): TextFieldModel {
        return copy(textColorClear = newTextColorClear)
    }

    private fun updateTextColorRed(newTextColorRed: Int): TextFieldModel {
        return copy(textColorRed = newTextColorRed)
    }

    private fun updateTextColorGreen(newTextColorGreen: Int): TextFieldModel {
        return copy(textColorGreen = newTextColorGreen)
    }

    private fun updateTextColorBlue(newTextColorBlue: Int): TextFieldModel {
        return copy(textColorBlue = newTextColorBlue)
    }

    private fun updateLabel(newLabel: String): TextFieldModel {
        return copy(label = newLabel)
    }

    private fun updateLabelColorClear(newLabelColorClear: Boolean): TextFieldModel {
        return copy(labelColorClear = newLabelColorClear)
    }

    private fun updateLabelColorRed(newLabelColorRed: Int): TextFieldModel {
        return copy(labelColorRed = newLabelColorRed)
    }

    private fun updateLabelColorGreen(newLabelColorGreen: Int): TextFieldModel {
        return copy(labelColorGreen = newLabelColorGreen)
    }

    private fun updateLabelColorBlue(newLabelColorBlue: Int): TextFieldModel {
        return copy(labelColorBlue = newLabelColorBlue)
    }

    private fun updateBackgroundColorClear(newBackgroundColorClear: Boolean): TextFieldModel {
        return copy(backgroundColorClear = newBackgroundColorClear)
    }

    private fun updateBackgroundColorRed(newBackgroundColorRed: Int): TextFieldModel {
        return copy(backgroundColorRed = newBackgroundColorRed)
    }

    private fun updateBackgroundColorGreen(newBackgroundColorGreen: Int): TextFieldModel {
        return copy(backgroundColorGreen = newBackgroundColorGreen)
    }

    private fun updateBackgroundColorBlue(newBackgroundColorBlue: Int): TextFieldModel {
        return copy(backgroundColorBlue = newBackgroundColorBlue)
    }

    private fun updateBorderWidth(newBorderWidth: Int): TextFieldModel {
        return copy(borderWidth = newBorderWidth)
    }

    private fun updateBorderColorClear(newBorderColorClear: Boolean): TextFieldModel {
        return copy(borderColorClear = newBorderColorClear)
    }

    private fun updateBorderColorRed(newBorderColorRed: Int): TextFieldModel {
        return copy(borderColorRed = newBorderColorRed)
    }

    private fun updateBorderColorGreen(newBorderColorGreen: Int): TextFieldModel {
        return copy(borderColorGreen = newBorderColorGreen)
    }

    private fun updateBorderColorBlue(newBorderColorBlue: Int): TextFieldModel {
        return copy(borderColorBlue = newBorderColorBlue)
    }

    private fun updateCornerRadius(newCornerRadius: Int): TextFieldModel {
        return copy(cornerRadius = newCornerRadius)
    }

    private fun updateShadowColorClear(newShadowColorClear: Boolean): TextFieldModel {
        return copy(shadowColorClear = newShadowColorClear)
    }

    private fun updateShadowColorRed(newShadowColorRed: Int): TextFieldModel {
        return copy(shadowColorRed = newShadowColorRed)
    }

    private fun updateShadowColorGreen(newShadowColorGreen: Int): TextFieldModel {
        return copy(shadowColorGreen = newShadowColorGreen)
    }

    private fun updateShadowColorBlue(newShadowColorBlue: Int): TextFieldModel {
        return copy(shadowColorBlue = newShadowColorBlue)
    }

    private fun updateShadowOffsetX(newShadowOffsetX: Int): TextFieldModel {
        return copy(shadowOffsetX = newShadowOffsetX)
    }

    private fun updateShadowOffsetY(newShadowOffsetY: Int): TextFieldModel {
        return copy(shadowOffsetY = newShadowOffsetY)
    }

    fun updateShadowOpacity(newShadowOpacity: Float): TextFieldModel {
        return copy(shadowOpacity = newShadowOpacity)
    }

    private fun updateShadowBlurRadius(newShadowBlurRadius: Int): TextFieldModel {
        return copy(shadowBlurRadius = newShadowBlurRadius)
    }

    private fun updateShadowCornerRadius(newShadowCornerRadius: Int): TextFieldModel {
        return copy(shadowCornerRadius = newShadowCornerRadius)
    }

    private fun updateShadowHeight(newShadowHeight: Int): TextFieldModel {
        return copy(shadowHeight = newShadowHeight)
    }

    private fun updateShadowWidth(newShadowWidth: Int): TextFieldModel {
        return copy(shadowWidth = newShadowWidth)
    }

    private fun updatePositionX(newPositionX: Float): TextFieldModel {
        return copy(positionX = newPositionX)
    }

    private fun updatePositionY(newPositionY: Float): TextFieldModel {
        return copy(positionY = newPositionY)
    }

    private fun updatePositionXRel(newPositionXRel: Relation): TextFieldModel {
        return copy(positionXRel = newPositionXRel)
    }

    private fun updatePositionYRel(newPositionYRel: Relation): TextFieldModel {
        return copy(positionYRel = newPositionYRel)
    }

    private fun updateLineSpace(newLineSpace: Int): TextFieldModel {
        return copy(lineSpace = newLineSpace)
    }

    private fun updateLines(newLines: Int): TextFieldModel {
        return copy(lines = newLines)
    }

    private fun updateScroll(newScroll: Boolean): TextFieldModel {
        return copy(scroll = newScroll)
    }

    private fun updateRimPadding(newRimPadding: Int): TextFieldModel {
        return copy(rimPadding = newRimPadding)
    }

    private fun updateLeftPadding(newLeftPadding: Int): TextFieldModel {
        return copy(leftPadding = newLeftPadding)
    }

    private fun updateRightPadding(newRightPadding: Int): TextFieldModel {
        return copy(rightPadding = newRightPadding)
    }

    private fun updateTopPadding(newTopPadding: Int): TextFieldModel {
        return copy(topPadding = newTopPadding)
    }

    private fun updateBottomPadding(newBottomPadding: Int): TextFieldModel {
        return copy(bottomPadding = newBottomPadding)
    }

    private fun updateTextAlign(newTextAlignment: TextAlign): TextFieldModel {
        return copy(textAlign = newTextAlignment)
    }

    private fun updateUnderlineThickness(newUnderlineThickness: Int): TextFieldModel {
        return copy(underlineThickness = newUnderlineThickness)
    }

    private fun updateUnderlineColorRed(newUnderlineColorRed: Int): TextFieldModel {
        return copy(underlineColorRed = newUnderlineColorRed)
    }

    private fun updateUnderlineColorGreen(newUnderlineColorGreen: Int): TextFieldModel {
        return copy(underlineColorGreen = newUnderlineColorGreen)
    }

    private fun updateUnderlineColorBlue(newUnderlineColorBlue: Int): TextFieldModel {
        return copy(underlineColorBlue = newUnderlineColorBlue)
    }

    private fun updateUrlText(newUrlText: String): TextFieldModel {
        return copy(urlText = newUrlText)
    }

    private fun updateUrlLink(newUrlLink: String): TextFieldModel {
        return copy(urlLink = newUrlLink)
    }

    private fun updateUrlTextColorRed(newUrlTextColorRed: Int): TextFieldModel {
        return copy(urlTextColorRed = newUrlTextColorRed)
    }

    private fun updateUrlTextColorGreen(newUrlTextColorGreen: Int): TextFieldModel {
        return copy(urlTextColorGreen = newUrlTextColorGreen)
    }

    private fun updateUrlTextColorBlue(newUrlTextColorBlue: Int): TextFieldModel {
        return copy(urlTextColorBlue = newUrlTextColorBlue)
    }

    private fun updateUrlFont(newUrlFont: FontWeight): TextFieldModel {
        return copy(urlFont = newUrlFont)
    }

    private fun updateUrlFontSize(newUrlFontSize: Int): TextFieldModel {
        return copy(urlFontSize = newUrlFontSize)
    }

    private fun updateWidth(newWidth: Int): TextFieldModel {
        return copy(width = newWidth)
    }

    private fun updateHeight(newHeight: Int): TextFieldModel {
        return copy(height = newHeight)
    }

    private fun updateMinHeight(newMinHeight: Int): TextFieldModel {
        return copy(minHeight = newMinHeight)
    }

    private fun updateMaxStrokes(newMaxStrokes: Int): TextFieldModel {
        return copy(maxStrokes = newMaxStrokes)
    }

    private fun updateSecureTextEntry(newSecureTextEntry: Boolean): TextFieldModel {
        return copy(secureTextEntry = newSecureTextEntry)
    }

    private fun updateKeyboardType(newKeyboardType: KeyboardType): TextFieldModel {
        return copy(keyboardType = newKeyboardType)
    }

    private fun updateInputFieldHeightDynamic(newInputFieldHeightDynamic: Boolean): TextFieldModel {
        return copy(inputFieldHeightDynamic = newInputFieldHeightDynamic)
    }

    private fun updateIdentifier(newIdentifier: String): TextFieldModel {
        return copy(identifier = newIdentifier)
    }

    private fun updateFirstResponder(newFirstResponder: Boolean): TextFieldModel {
        return copy(firstResponder = newFirstResponder)
    }

    private fun updateNextResponder(newNextResponder: String?): TextFieldModel {
        if (newNextResponder == null) return this
        return copy(nextResponder = newNextResponder)
    }

    private fun updateExecutionDelay(newExecutionDelay: Float): TextFieldModel {
        return copy(executionDelay = newExecutionDelay)
    }
}
