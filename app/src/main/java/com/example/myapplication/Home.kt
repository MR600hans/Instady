package com.example.myapplication

import android.content.res.Configuration
import android.content.res.Resources
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Green200
import com.example.myapplication.ui.theme.Green100
import com.example.myapplication.ui.theme.Yellow


@Composable

fun Home(
    onNavigation: () -> Unit,
) {
    Column {
        val configuration = LocalConfiguration.current

        val screenHeight = configuration.screenHeightDp.dp
        val screenWidth = configuration.screenWidthDp.dp
        topBar()
        Box(
            modifier = Modifier.fillMaxWidth().height(screenHeight - 100.dp),
            contentAlignment = Alignment.Center
        ) {
            HomePageImage()
            Button(
                onClick = { onNavigation() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(40.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Yellow,
                    contentColor = Color.White
                ),
                //contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = "Find Buddy !",
                    modifier = Modifier
                        .padding(5.dp)
                )
            }

        }
    }
}


@Composable
fun HomePageFunction(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth().height(screenHeight - 40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text)
            )
        }
    }
}

@Composable
fun AlignFunctionColumn(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(HomePageFunctionData) { item ->
            HomePageFunction(item.drawable, item.text)
        }
    }
}

private val HomePageFunctionData = listOf(
    R.drawable.fc1_study_record to R.string.fc1_study_record,
    R.drawable.fc2_find_partner to R.string.fc2_find_partner,
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MyApplicationTheme {
        HomePageFunction(
            text = R.string.fc1_study_record,
            drawable = R.drawable.fc1_study_record,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignFunctionColumnPreview() {
    MyApplicationTheme { AlignFunctionColumn() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomePageImage() {
    Image(
        painterResource(id = R.drawable.fc3_reading),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}