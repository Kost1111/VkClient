package com.core.util.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BaseTopBar(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable (() -> Unit) = {},
    isContentScrollable: Boolean = false,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = { }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .statusBarsPadding()
                .background(color = backgroundColor)
                .ifTrue(isContentScrollable) { verticalScroll(rememberScrollState()) },
        ) {
            content()
        }
    }
}

inline fun Modifier.ifTrue(condition: Boolean, builder: Modifier.() -> Modifier): Modifier =
    if (condition) this.builder() else this