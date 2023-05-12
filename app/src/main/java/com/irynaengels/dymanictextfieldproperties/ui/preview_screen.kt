package com.irynaengels.dymanictextfieldproperties.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import com.irynaengels.dymanictextfieldproperties.LocalTextFieldViewModel
import com.irynaengels.dymanictextfieldproperties.model.Relation
import com.irynaengels.dymanictextfieldproperties.model.TextFieldModel

@Composable
fun PreviewScreen(navController: NavController) {
    val textFieldViewModel = LocalTextFieldViewModel.current
    val textFieldModels = textFieldViewModel.textFieldModels.collectAsState()

    val screenSize = LocalConfiguration.current.screenWidthDp

    val focusRequesters = remember { mutableMapOf<String, FocusRequester>() }

    Column {

        Box(modifier = Modifier.weight(1f)){

            for (i in 0 until textFieldModels.value.size){
                val offsetX = calculateOffset(textFieldModels.value[i].positionX, screenSize.toFloat(), textFieldModels.value[i].positionXRel)
                val offsetY = calculateOffset(textFieldModels.value[i].positionY, screenSize.toFloat(), textFieldModels.value[i].positionYRel)

                CustomTextField(textFieldModel = textFieldModels.value[i], Modifier.offset(x = offsetX, y = offsetY), focusRequesters){
                    if (it.length <= textFieldModels.value[i].maxStrokes) {
                        val newTextFieldModel = textFieldModels.value[i].updateIndexedValue(1, it)
                        textFieldViewModel.updateTextFieldModelAtIndex(newTextFieldModel, i)
                    }
                }
            }
        }
        Button(modifier = Modifier.padding(start = 16.dp), onClick = {
            navController.navigate(AttributeFormRoute)
            textFieldViewModel.clearTextFieldModels()
            textFieldViewModel.updateTextFieldModel(TextFieldModel(content = ""))
        }) {
            Text("Back")
        }
    }
}

private fun calculateOffset(value: Float, screenSize: Float, relation: Relation): Dp {
    return when (relation) {
        Relation.START -> value.dp
        Relation.CENTER -> (screenSize / 2 + value).dp
        Relation.END -> (screenSize - value).dp
    }
}