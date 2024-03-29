package com.example.newsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(innerPadding:PaddingValues,data:News,backNavigate:()->Unit){
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding)
    ) {
        Box(modifier = Modifier.height(300.dp)){
            Image(
                painter = rememberAsyncImagePainter(data.image),
                contentDescription = data.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box (
                modifier = Modifier.offset(x = 20.dp,y = 20.dp)
            ){
                IconButton(
                    onClick = { backNavigate() },
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
               text = data.title,
               fontSize = 28.sp,
               fontWeight = FontWeight.Medium
           )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = data.isoDate,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = data.description,
                fontSize = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}
