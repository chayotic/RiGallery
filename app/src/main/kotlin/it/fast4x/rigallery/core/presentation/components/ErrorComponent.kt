/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 * SPDX-FileCopyrightText: 2025 Fast4x
 * SPDX-License-Identifier: GPL-3.0
 */

package it.fast4x.rigallery.core.presentation.components

import android.content.ClipData
import android.content.Context.CLIPBOARD_SERVICE
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import it.fast4x.rigallery.R


@Composable
fun Error(
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.error_title),
    errorMessage: String? = null
) {
    val context = LocalContext.current
    val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
    val toastBuilder = Toast.makeText(LocalContext.current, errorMessage, Toast.LENGTH_SHORT)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(128.dp),
            imageVector = Icons.Outlined.Error,
            contentDescription = stringResource(R.string.error_cd),
            tint = MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        if (!errorMessage.isNullOrEmpty()) {
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier.wrapContentSize(),
                onClick = {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("", AnnotatedString(errorMessage)))
                    toastBuilder.show()
                }
            ) {
                Text(text = stringResource(R.string.copy_error))
            }
        }
    }
}