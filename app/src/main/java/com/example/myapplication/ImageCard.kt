package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Green100
import com.example.myapplication.ui.theme.Green200
import com.example.myapplication.ui.theme.Yellow


@Composable
fun myImageCard(onNavigation:() -> Unit) {
    Surface(
        color = Green100
    ) {
        Column {
            ImageProfile(
                name = "Lyk.Brian",
                painter = painterResource(id = R.drawable.flower),
                contentDescription = "flower",
            )
            Spacer(modifier = Modifier.height(10.dp))
            ImageJudge{onNavigation()}
        }
    }
}

@Composable
fun ImageProfile(
    name:String,
    painter: Painter,
    contentDescription: String,
) {
    Surface(
        color = Green200,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
        ) {
            //Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column {
                    Text(
                        text = name,
                        style = TextStyle(color = Color.Black, fontSize = 24.sp),
                        modifier = Modifier.padding(15.dp, 16.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Male",
                        modifier = Modifier.padding(16.dp, 12.dp, 0.dp, 10.dp),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(color = Color.Black,fontSize = 20.sp)
                    )
                }
            }

        }
    }
}


@Composable
fun ImageJudge(onNavigation: () -> Unit){
    Surface(
        color = Green200,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Surface(
                color = Color.White,
                //modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp, 25.dp, 25.dp, 15.dp),
                ) {
                    Text(
                        text = "How is your experience ?",
                        textAlign = TextAlign.Left,
                        style = TextStyle(color = Color.Black, fontSize = 24.sp),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        //Spacer(modifier = Modifier.width(5.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "How do you feel about study partner?",
                        textAlign = TextAlign.Left,
                        style = TextStyle(color = Color.Black, fontSize = 24.sp),
                        fontWeight = FontWeight.Bold
                    )

                    Row {
                        //Spacer(modifier = Modifier.width(5.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                        Spacer(modifier = Modifier.width(15.dp))
                        Heart()
                    }

                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = { onNavigation() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Yellow,
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.size(width = 100.dp, height = 50.dp)
                ) {
                    Text(
                        text = "Next",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}