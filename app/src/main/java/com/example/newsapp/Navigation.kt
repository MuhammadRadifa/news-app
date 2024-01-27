package com.example.newsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title:String,
    val unSelectedIcon:ImageVector,
    val selectedIcon:ImageVector
)

val itemsNavigation = listOf<NavigationItem>(
    NavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    ),
    NavigationItem(
        title = "Explore",
        selectedIcon = Icons.Filled.Search,
        unSelectedIcon = Icons.Outlined.Search
    ),
    NavigationItem(
        title = "Profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unSelectedIcon = Icons.Outlined.AccountCircle
    )
)