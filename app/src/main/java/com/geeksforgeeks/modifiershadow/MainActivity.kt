package com.geeksforgeeks.modifiershadow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Outlined Text", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        val textPaintStroke = Paint().asFrameworkPaint().apply {
                            isAntiAlias = true
                            style = android.graphics.Paint.Style.STROKE
                            textSize = 100f
                            color = android.graphics.Color.BLACK
                            strokeWidth = 12f
                            strokeMiter= 10f
                            strokeJoin = android.graphics.Paint.Join.ROUND
                        }

                        val textPaint = Paint().asFrameworkPaint().apply {
                            isAntiAlias = true
                            style = android.graphics.Paint.Style.FILL
                            textSize = 100f
                            color = android.graphics.Color.WHITE
                        }

                        Canvas(
                            modifier = Modifier.fillMaxSize(),
                            onDraw = {
                                drawIntoCanvas {
                                    it.nativeCanvas.drawText(
                                        "GeeksforGeeks",
                                        200f,
                                        200.dp.toPx(),
                                        textPaintStroke
                                    )

                                    it.nativeCanvas.drawText(
                                        "GeeksforGeeks",
                                        200f,
                                        200.dp.toPx(),
                                        textPaint
                                    )
                                }
                            }
                        )
                    }
                }
            )
        }
    }
}
/*
Package name wrong
 */
