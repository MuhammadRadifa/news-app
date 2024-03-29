package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{false}
        setContent {
            val rootNavController = rememberNavController()
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsApp(rootNavController = rootNavController)
                }
            }
        }
    }
}

@Composable
fun NewsApp(rootNavController:NavHostController){
    val newsViewModel:MainViewModel = viewModel()
    val viewState by newsViewModel.newsState
    NavHost(navController = rootNavController, startDestination = "welcome" ){
        composable(route="mainScreen"){
            MainScreen(viewState = viewState)
        }
        composable(route="welcome"){
            WelcomeScreen(rootNavController)
        }
    }
}