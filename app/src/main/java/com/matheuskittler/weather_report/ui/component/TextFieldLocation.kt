package com.matheuskittler.weather_report.ui.component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import com.matheuskittler.weather_report.R

@Composable
fun TextFieldLocation(
    context: Context,
    onSearch: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val maxChar = 100
    val isLine = true

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.onSecondary,
        shadowElevation = 4.dp
    ) {
        TextField(
            value = query,
            onValueChange = {
                if (it.length <= maxChar) {
                    query = it
                }
            },
            singleLine = isLine,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.hint_location_search)) },
            leadingIcon = {
                Icon(
                    Icons.Outlined.LocationOn,
                    contentDescription = stringResource(R.string.ic_info_location)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                onSearch(query)
            }),
        )
    }
}


@Preview
@Composable
fun SearchBarPreview() {
    val context = LocalContext.current
    MaterialTheme {
        TextFieldLocation(context = context) { query ->
            // Lógica de pesquisa aqui
        }
    }
}