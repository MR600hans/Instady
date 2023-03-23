package com.example.myapplication

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItem(
    val title:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int = 0
){
    FRIEND("friend", NavRoute.FRIENDS,Icons.Outlined.Favorite),
    HOME("Home", NavRoute.HOME,Icons.Outlined.Home),
    SETTING("Setting", NavRoute.SETTING,Icons.Outlined.Person)
}
