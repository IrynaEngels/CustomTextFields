package com.irynaengels.dymanictextfieldproperties.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds

@Composable
fun TextFieldScroller(
    enabled: Boolean,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    if (enabled) {
        val scrollState = rememberScrollState()
        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .clipToBounds()
        ) {
            content()
        }
    } else {
        content()
    }
}