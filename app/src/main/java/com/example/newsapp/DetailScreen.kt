package com.example.newsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.height(300.dp)){
            Image(
                painter = painterResource(id = R.drawable.pic),
                contentDescription = "contoh",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box (
                modifier = Modifier.offset(x = 20.dp,y = 20.dp)
            ){
                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    ),
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back" )
                }
            }
            
        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
           Text(
               text = "Pemain Bali United dampingi Presiden RI tinjau IKN",
               fontSize = 28.sp,
               fontWeight = FontWeight.Medium
           )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "1 Januari 2022",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forests are one of the most important natural resources that our planet possesses. Not only do they provide us with a diverse range of products such as timber, medicine, and food, but they also play a vital role in mitigating climate change and maintaining the overall health of our planet's ecosystems. In this article, we will explore the ways in which forests are helping our world.",
                fontSize = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen()
}