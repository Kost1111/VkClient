package com.feature.profile.impl.ui.music.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun MusicItem(
    value: Float,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(16.dp), color = Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "15")
        Slider(
            modifier = Modifier.weight(1f),
            value = value,
            onValueChange = {  }
        )
        Text(text = "15")
    }
}

@Preview
@Composable
private fun MusicItemPreview() {
    MaterialTheme {
        MusicItem(
            value = 0f,
        )
    }
}