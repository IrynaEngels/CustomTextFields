package com.irynaengels.dymanictextfieldproperties.ui.input_fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlin.reflect.KClass

@Composable
fun MyDropdownTextField(
    value: String,
    items: Map<String, Any?>,
    onValueChange: (Any?) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = { /* Do nothing to disable user input */ },
            label = { Text(label) },
            readOnly = true, // Set to true to prevent user input
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Dropdown Icon")
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .width(IntrinsicSize.Min)
        ) {
            items.forEach { (key, itemValue) ->
                DropdownMenuItem(onClick = {
                    onValueChange(itemValue)
                    expanded = false
                }) {
                    Text(key)
                }
            }
        }
    }
}