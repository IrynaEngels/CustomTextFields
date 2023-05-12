package com.irynaengels.dymanictextfieldproperties

import android.util.Log
import androidx.lifecycle.ViewModel
import com.irynaengels.dymanictextfieldproperties.model.TextFieldModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TextFieldViewModel : ViewModel() {

    private val _textFieldModel = MutableStateFlow(TextFieldModel(content = ""))
    val textFieldModel: StateFlow<TextFieldModel> = _textFieldModel

    fun updateTextFieldModel(newTextFieldModel: TextFieldModel) {
        Log.d("TextFieldViewModel", "updateTextFieldModel: $newTextFieldModel")
        _textFieldModel.value = newTextFieldModel
    }

    private val _textFieldModels = MutableStateFlow(listOf<TextFieldModel>())
    val textFieldModels: StateFlow<List<TextFieldModel>> = _textFieldModels

    fun addTextFieldModel(textFieldModel: TextFieldModel) {
        _textFieldModels.value = _textFieldModels.value + textFieldModel
    }

    fun updateTextFieldModelAtIndex(newTextFieldModel: TextFieldModel, index: Int) {
        Log.d("TextFieldViewModel", "updateTextFieldModelAtIndex: $index, $newTextFieldModel")
        _textFieldModels.value = _textFieldModels.value.toMutableList().apply {
            this[index] = newTextFieldModel
        }
    }

    fun clearTextFieldModel(){
        _textFieldModel.value = TextFieldModel(content = "")
    }

    fun clearTextFieldModels(){
        _textFieldModels.value = listOf()
    }
}
