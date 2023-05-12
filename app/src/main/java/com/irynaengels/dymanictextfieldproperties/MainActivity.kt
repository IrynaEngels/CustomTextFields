package com.irynaengels.dymanictextfieldproperties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.irynaengels.dymanictextfieldproperties.ui.AttributeForm
import com.irynaengels.dymanictextfieldproperties.ui.theme.DymanicTextFieldPropertiesTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.irynaengels.dymanictextfieldproperties.ui.MainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DymanicTextFieldPropertiesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = viewModel<TextFieldViewModel>()

                    CompositionLocalProvider(LocalTextFieldViewModel provides viewModel) {
                        MainNavigation()
                    }
                }
            }
        }
    }
}

// Define a CompositionLocal for the TextFieldViewModel
val LocalTextFieldViewModel = compositionLocalOf<TextFieldViewModel> {
    error("No TextFieldViewModel provided")
}


