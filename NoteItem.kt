package com.appcoding.cute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.ColorUtils
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.appcoding.cute.ui.theme.CuteTheme

class NoteItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuteTheme {
                note()
            }
        }
    }
}


@Composable
fun note(){
    val corner = 10.dp
    val cut = 30.dp
    Box(modifier  = Modifier.padding(20.dp)){
        Canvas(modifier = Modifier.size(300.dp)) {
            val clipPath = Path().apply {
                lineTo(size.width - cut.toPx(),0f)
                lineTo(size.width, cut.toPx())
                lineTo(size.width , size.height)
                lineTo(0f,size.height)
                close()
            }

            clipPath(clipPath) {
                drawRoundRect(
                    color = Color.Cyan,
                    size = size,
                    cornerRadius = CornerRadius(corner.toPx())
                )


                drawRoundRect(
                    color = Color(ColorUtils.blendARGB(Color.Cyan.toArgb(),
                        0x000000, 0.2f)),
                    topLeft = Offset(size.width - cut.toPx(), -100f),
                    size = Size(cut.toPx() + 100f, cut.toPx() + 100f),
                    cornerRadius = CornerRadius(corner.toPx())
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewNote() {
    CuteTheme {
        note()
    }
}