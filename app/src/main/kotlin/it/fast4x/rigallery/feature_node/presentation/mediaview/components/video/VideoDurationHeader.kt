/*
 * SPDX-FileCopyrightText: 2023 IacobIacob01
 * SPDX-License-Identifier: Apache-2.0
 */

package it.fast4x.rigallery.feature_node.presentation.mediaview.components.video

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import it.fast4x.rigallery.core.presentation.components.util.advancedShadow
import it.fast4x.rigallery.feature_node.domain.model.Media
import it.fast4x.rigallery.feature_node.presentation.util.formatMinSec

@Composable
fun VideoDurationHeader(modifier: Modifier = Modifier, media: Media) {
    Row(
        modifier = modifier
            .padding(all = 8.dp)
            .advancedShadow(
                cornersRadius = 8.dp,
                shadowBlurRadius = 6.dp,
                alpha = 0.3f
            ),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = media.duration.formatMinSec(),
            style = MaterialTheme.typography.labelSmall,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(2.dp))
        Image(
            modifier = Modifier
                .size(16.dp)
                .advancedShadow(
                    cornersRadius = 2.dp,
                    shadowBlurRadius = 6.dp,
                    alpha = 0.1f,
                    offsetY = (-2).dp
                ),
            imageVector = Icons.Rounded.PlayCircle,
            colorFilter = ColorFilter.tint(color = Color.White),
            contentDescription = "Video"
        )
    }
}
