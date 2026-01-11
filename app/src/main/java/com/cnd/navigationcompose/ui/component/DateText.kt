package com.cnd.navigationcompose.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DateText(
    timestamp: Long,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    val formatter = remember {
        SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    }

    Text(
        text = formatter.format(Date(timestamp)),
        style = MaterialTheme.typography.labelSmall,
        color = color
    )
}
