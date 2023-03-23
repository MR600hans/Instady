package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import com.example.myapplication.model.AuthViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberJetsnackAppState()
//            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    if (appState.shouldShowBottomBar) {
                        BottomNavigationBar(
                            items = appState.bottomBarTabs,
                            currentRoute = appState.currentRoute!!,
                            navigateToRoute = appState::navigateToBottomBarRoute,
//                            navController = navController,
//                            onItemClick = { navController.navigate(it.route)}
                        )
                    }
                },
                scaffoldState = appState.scaffoldState
            ){
                Navigation(navHostController = appState.navController, AuthViewModel())
            }
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colors.background
//            ) {
//                Navigation(navHostController = appState.navController)
//            }
//            Scaffold(
//                bottomBar = {
//                    BottomNavigationBar(items = listOf(
//                        BottomNavItem(
//                            name = "Home",
//                            route = NavRoute.HOME,
//                            icon = Icons.Default.Home
//                        ),
//                        BottomNavItem(
//                            name = "Setting",
//                            route = NavRoute.SETTING,
//                            icon = Icons.Default.Settings
//                        ),
//                        BottomNavItem(
//                            name = "Friends",
//                            route = NavRoute.FRIENDS,
//                            icon = Icons.Default.Person
//                        ),
//                    ),
//                        navController = navController,
//                        onItemClick = { navController.navigate(it.route)}
//                    )
//                }
//            ){
//                Navigation(navHostController = navController)
//            }
        }
    }
}
//@Composable
//fun topBar(){
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Text(
//            text = "Instady",
//            modifier = Modifier.padding(vertical = 12.dp),
//            style = MaterialTheme.typography.h6,
//            textAlign = TextAlign.Center
//        )
//    }
//}


