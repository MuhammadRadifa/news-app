package com.example.newsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(innerPadding:PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pic),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "John Doe", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Text(text = "@JohnDoe", fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Statistic()
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        Settings()
    }
}

@Composable
fun Statistic(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Article", fontSize = 20.sp)
            Text(text = "320", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Column {
            Text(text = "Streak", fontSize = 20.sp)
            Text(text = "345 Days", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Column {
            Text(text = "Level", fontSize = 20.sp)
            Text(text = "100", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun Settings(){
    Column {
        Text(text = "Settings", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        SettingNav("My Account")
        SettingNav("Privacy Settings")
        SettingNav("Offline Reading")
        SettingNav("Activity Settings")
        SettingNav("About Us")
    }
}

@Composable
fun SettingNav(content:String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = content, fontSize = 20.sp)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Forward",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
