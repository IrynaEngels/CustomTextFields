package com.irynaengels.dymanictextfieldproperties.model

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import kotlin.reflect.KClass

data class InputFieldProperties<T>(
    val isDropdown: Boolean,
    val content: Map<String, T>,
    val keyboardType: KeyboardType = KeyboardType.Text,
)

val propertiesList: List<InputFieldProperties<*>> = listOf(
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(
        true,
        mapOf("Steagal-Medium" to FontWeight.Medium, "Steagal-Regular" to FontWeight.Normal)
    ),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),

    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),

    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(
        true,
        mapOf("start" to Relation.START, "center" to Relation.CENTER, "end" to Relation.END)
    ),
    InputFieldProperties(
        true,
        mapOf("start" to Relation.START, "center" to Relation.CENTER, "end" to Relation.END)
    ),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(
        true,
        mapOf("right" to TextAlign.Right, "left" to TextAlign.Left, "center" to TextAlign.Center)
    ),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(
        true,
        mapOf("Steagal-Medium" to FontWeight.Medium, "Steagal-Regular" to FontWeight.Normal)
    ),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(false, mapOf(), KeyboardType.Number),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(
        true,
        mapOf(
            "text" to KeyboardType.Text,
            "number" to KeyboardType.Number,
            "email" to KeyboardType.Email
        )
    ),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(true, mapOf("true" to true, "false" to false)),
    InputFieldProperties(false, mapOf()),
    InputFieldProperties(false, mapOf(), KeyboardType.Number)


    )


