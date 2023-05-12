package com.irynaengels.dymanictextfieldproperties.ui

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.advancedShadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    opacity: Float = 1f,
    borderRadius: Dp = 0.dp,
    height: Dp = 0.dp,
    width: Dp = 0.dp
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }
            val shadowColor = color.copy(alpha = opacity)
            frameworkPaint.color = shadowColor.toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + leftPixel + width.toPx()
            val bottomPixel = size.height + topPixel + height.toPx()

            if ((height != 0.dp || width != 0.dp) && borderRadius != 0.dp) {
                canvas.drawRoundRect(
                    left = leftPixel,
                    top = topPixel,
                    right = rightPixel,
                    bottom = bottomPixel,
                    radiusX = borderRadius.toPx(),
                    radiusY = borderRadius.toPx(),
                    paint = paint
                )
            } else {
                canvas.drawRect(
                    left = leftPixel,
                    top = topPixel,
                    right = rightPixel,
                    bottom = bottomPixel,
                    paint = paint,
                )
            }
        }
    }
)



/*fun Modifier.advancedShadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    opacity: Float = 1f,
    borderRadius: Dp = 0.dp,
    height: Dp = 0.dp
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }
            val shadowColor = color.copy(alpha = opacity)
            frameworkPaint.color = shadowColor.toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + leftPixel
            val bottomPixel = size.height + topPixel

            if (height != 0.dp && borderRadius != 0.dp) {
                canvas.drawRoundRect(
                    left = leftPixel,
                    top = topPixel,
                    right = rightPixel,
                    bottom = bottomPixel,
                    radiusX = borderRadius.toPx(),
                    radiusY = borderRadius.toPx(),
                    paint = paint
                )
            } else {
                canvas.drawRect(
                    left = leftPixel,
                    top = topPixel,
                    right = rightPixel,
                    bottom = bottomPixel,
                    paint = paint,
                )
            }
        }
    }
)*/

