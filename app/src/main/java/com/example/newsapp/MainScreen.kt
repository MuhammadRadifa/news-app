package com.example.newsapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(){
    Scaffold(
        topBar = { TopBar()},
        bottomBar = { BottomBar()},
        containerColor = Color.White
    ){
        innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(text = "hello")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(64.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        title = {
            Text(
                text = "News App",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Medium
            ) },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }, modifier = Modifier.padding(16.dp)) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ },modifier = Modifier.padding(16.dp)) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    )
}

@Composable
fun BottomBar(){

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}