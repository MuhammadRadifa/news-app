package com.example.newsapp


import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

val colorStops = arrayOf(
    0.0f to Color.Yellow,
    0.2f to Color.Red,
    1f to Color.Blue
)

@Composable
fun MainScreen(viewState:MainViewModel.NewsState){
    val mainNavContoller = rememberNavController()
    val navBackStackEntry by mainNavContoller.currentBackStackEntryAsState()
    Scaffold(
        topBar = { TopBar()},
        bottomBar = { BottomBar(mainNavContoller,navBackStackEntry)},
        containerColor = Color(0xFFF7F8FA),
    ){
        innerPadding ->
        NavHost(mainNavContoller, startDestination = "home" ){
            composable(route="home"){
                HomeScreen(innerPadding = innerPadding, viewState = viewState, DetailNavigate = {
                    mainNavContoller.currentBackStackEntry?.savedStateHandle?.set("news",it)
                    mainNavContoller.navigate("detailscreen")
                })
            }
            composable(route="category"){
                CategoryScreen(innerPadding = innerPadding)
            }
            composable(route="profile"){
                ProfileScreen(innerPadding = innerPadding)
            }
            composable(route="detailscreen"){
                val news = mainNavContoller.previousBackStackEntry?.savedStateHandle?.
                    get<News>("news")?:News("Untitled","Not Found","","","")
                DetailScreen(innerPadding = innerPadding,data = news, backNavigate = {mainNavContoller.navigate("home")})
            }
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
fun BottomBar(rootNavController: NavHostController,navBackStackEntry: NavBackStackEntry?){
    NavigationBar(
        containerColor = Color.White
    ) {
        itemsNavigation.forEach{
            items ->
            val isSelected = items.title.lowercase() == navBackStackEntry?.destination?.route
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFF7F8FA)
                ),
                selected = isSelected,
                label = { Text(text = items.title)},
                onClick = {
                          rootNavController.navigate(items.title.lowercase()){
                              popUpTo(rootNavController.graph.findStartDestination().id){
                                  saveState = true
                              }
                              launchSingleTop = true
                              restoreState = true
                          }
                },
                icon = {
                    Icon(
                        imageVector = if(isSelected) items.selectedIcon else items.unSelectedIcon,
                        contentDescription = items.title
                    )
                }
            )
        }
    }
}

