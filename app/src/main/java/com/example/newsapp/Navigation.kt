package com.example.newsapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
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
        title = "Category",
        selectedIcon = Icons.Filled.List,
        unSelectedIcon = Icons.Outlined.List
    ),
    NavigationItem(
        title = "Profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unSelectedIcon = Icons.Outlined.AccountCircle
    )
)