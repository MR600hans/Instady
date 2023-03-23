@file:OptIn(ExperimentalMaterialApi::class)

package com.example.myapplication

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.model.AuthViewModel
import com.example.myapplication.signin.AuthScreen
import com.example.myapplication.ui.theme.Green200
import com.example.myapplication.ui.theme.Green100
import com.example.myapplication.ui.theme.Yellow
import kotlin.text.Typography.section

object NavRoute{
    val SPLASHSCREEN = "SplashScreen"
    val SIGNIN = "Signin"
    val HOME = "Home"
    val PRE_SETTING = "PreSetting"
    val VIDEOCALL = "VideoCall"
    val COUNTDOWN = "CountDown"
    val SETTING = "Setting"
    val FRIENDS = "Friends"
    val JUDGE = "Judge"
    val FAKEHOME = "FakeHome"
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalAnimationApi
@Composable
fun Navigation(navHostController: NavHostController,authViewModel: AuthViewModel){
    NavHost(
        navController = navHostController,
        startDestination = NavRoute.SPLASHSCREEN
    ){
        composable(NavRoute.FAKEHOME) {
            FakeHome {
                navHostController.navigate(NavRoute.HOME)
            }
        }

        composable(NavRoute.SPLASHSCREEN){
            SplashScreen{navHostController.navigate(NavRoute.SIGNIN)}
        }

        composable(NavRoute.SIGNIN){
            AuthScreen(navHostController,NavRoute.HOME,authViewModel)
        }

        composable(NavRoute.HOME){
            Home {
                navHostController.navigate(NavRoute.PRE_SETTING)
            }
        }

        composable(NavRoute.PRE_SETTING){
            PreSetting {
                navHostController.navigate(NavRoute.COUNTDOWN)
            }
        }

        composable(NavRoute.COUNTDOWN){
            CountDown {
                navHostController.navigate(NavRoute.VIDEOCALL)
            }
        }

        composable(NavRoute.VIDEOCALL){
            VideoCall (navHostController)
        }

        composable(NavRoute.JUDGE){
            Judge {
                navHostController.navigate(NavRoute.HOME){
                    popUpTo(NavRoute.HOME){inclusive = true}
                }
            }
        }

        composable(NavRoute.SETTING){
            Setting()
        }
        composable(NavRoute.FRIENDS){
            Friends()
        }
    }
}



@Composable
fun BottomNavigationBar(
    items:Array<BottomNavItem>,
//    navController: NavController,
    currentRoute: String,
    navigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier,
//    onItemClick:(BottomNavItem)->Unit
){
//    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentSection = items.first { it.route == currentRoute }
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Green200,
        elevation = 5.dp
    ) {
        items.forEach{ item->
//            val selected = item.route == backStackEntry.value?.destination?.route
            val selected = item == currentSection
            BottomNavigationItem(
                selected = selected,
                onClick = {navigateToRoute(item.route)},
                selectedContentColor = Yellow,
                unselectedContentColor = Color.Black,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if(item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Badge{
                                        Text(text = item.badgeCount.toString())
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        }
                        else{
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}