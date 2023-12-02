package com.pieterv.snap.presentation.nav.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pieterv.snap.R

class Snap : SwappableContent {
    @Composable
    override fun Content(modifier: Modifier) {
        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.snap_content_text),
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.padding(bottom = 16.dp),
            ) {
                Text(stringResource(id = R.string.button_action_text))
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text(stringResource(id = R.string.dialog_title)) },
                    text = { Text(stringResource(R.string.dialog_text)) },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false },
                        ) {
                            Text(stringResource(R.string.dismiss))
                        }
                    },
                )
            }
        }
    }
}
