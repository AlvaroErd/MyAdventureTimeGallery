package com.example.migaleradearte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migaleradearte.ui.theme.MiGaleríaDeArteTheme

val database: ImageDatabase = ImageDatabase()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleríaDeArteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MiGaleriaScreen()
                }
            }
        }
    }
}


@Composable
fun MiGaleriaScreen(){
    var currentStep by remember { mutableStateOf(0) }

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 4.dp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(250, 200, 100))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier

                .background(Color(255, 255, 255), shape = RoundedCornerShape(20.dp))

        ) {
            Image(
                painter = painterResource(id = database.allImages[currentStep].image),
                contentDescription = stringResource(id = database.allImages[currentStep].description),
                modifier = Modifier
//                    .size(400.dp)
                    .wrapContentSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(BorderStroke(borderWidth, rainbowColorsBrush)

                    ),
                        contentScale = ContentScale.Fit,
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = database.allImages[currentStep].title),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = database.allImages[currentStep].description),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
        )
        {
            Button(
                onClick = {
                    if (currentStep != 0) {
                        currentStep -= 1
                    }
                },
                modifier = Modifier.padding(10.dp),
            )

            {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.previous),
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(id = R.string.previous))
            }

            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    if (currentStep < setupImages().size -1 ) {
                        currentStep++
                    } else {
                        currentStep = 0
                    }
                }
            )
            {
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(id = R.string.next))
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = stringResource(id = R.string.next),
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiGaleriaScreenPreview() {
    MiGaleríaDeArteTheme {
        MiGaleriaScreen()
    }
}