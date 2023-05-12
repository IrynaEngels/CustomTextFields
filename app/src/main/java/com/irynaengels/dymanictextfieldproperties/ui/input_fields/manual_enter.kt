package com.irynaengels.dymanictextfieldproperties.ui.input_fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyManualTextField(modifier: Modifier, value: String,
                      onValueChange: (String) -> Unit, keyboardType: KeyboardType) {

    BasicTextField(
        modifier = modifier
            .height(56.dp)
            .onFocusChanged {
            },
        maxLines = 1,
        value = value,
        onValueChange = { newText ->
            onValueChange(newText)
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            textDecoration = TextDecoration.None
        ),
        keyboardActions = KeyboardActions(onSearch = {
            // Hide keyboard
        }),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    /*        .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = {
                                    timePickerDialog.show()
                                }
                            )*/
                    .border(
                        border = BorderStroke(width = 1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(4.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                innerTextField()
            }
        }
    )
}