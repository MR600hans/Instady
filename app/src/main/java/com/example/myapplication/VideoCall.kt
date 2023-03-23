package com.example.myapplication

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.myapplication.ui.theme.Green100
import com.example.myapplication.ui.theme.Yellow
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

@Composable
fun VideoCall(navHostController : NavHostController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Surface(modifier = Modifier.fillMaxSize()) {
            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webChromeClient = WebChromeClient()
                    settings.javaScriptEnabled = true
                    settings.mediaPlaybackRequiresUserGesture = false
                    loadUrl("file:android_asset/call.html")
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView, url: String?) {
                            var uid = UUID.randomUUID().toString()
                            uuid2db(uid)
                            evaluateJavascript("init(\"" + uid + "\")", null)
                        }
                    }
                }
            }, update = { it.loadUrl("file:android_asset/call.html") })
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Row{
                    Button(
                        onClick = { navHostController.navigate(NavRoute.HOME) },
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Color.Red,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Report")
                    }
                    Button(
                        onClick = { navHostController.navigate(NavRoute.JUDGE)},
                        modifier = Modifier,
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Yellow,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "End Call")
                    }
                }
            }
    }
}

fun uuid2db(uid: String) {
    var dbref = Firebase.database.getReference("instady")
    // test_adduser()

    var oauth_uid = get_oauth_uid()
    dbref.child(oauth_uid).setValue("")

    dbref.child(oauth_uid).child("peerjs_uid").setValue(uid);
    dbref.child(oauth_uid).child("peerjs_uid").setValue(uid);
}

fun get_oauth_uid(): String {
    return UUID.randomUUID().toString()
}


// fun test_adduser() {
//     var dbref = Firebase.database.getReference("instady")
//     dbref.child("sample2").setValue("")
// }