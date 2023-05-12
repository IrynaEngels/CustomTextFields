package com.irynaengels.dymanictextfieldproperties.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.underline(
    thickness: Dp,
    color: Color
) = this.drawWithContent {
    drawContent()
    drawRect(
        color = color,
        topLeft = Offset(0f, size.height - thickness.toPx()),
        size = Size(size.width, thickness.toPx())
    )
}