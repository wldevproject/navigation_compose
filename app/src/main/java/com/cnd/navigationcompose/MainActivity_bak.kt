//package com.cnd.navigationcompose
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountBox
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.tooling.preview.PreviewScreenSizes
//import com.cnd.navigationcompose.ui.theme.NavigationComposeTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            NavigationComposeTheme {
//                NavigationComposeApp()
//            }
//        }
//    }
//}
//
//@PreviewScreenSizes
//@Composable
//fun NavigationComposeApp() {
//    var currentDestination by rememberSaveable {
//        mutableStateOf(AppDestinations.HOME)
//    }
//
//    NavigationSuiteScaffold(
//        navigationSuiteItems = {
//            AppDestinations.entries.forEach { destination ->
//                item(
//                    icon = {
//                        Icon(
//                            destination.icon,
//                            contentDescription = destination.label
//                        )
//                    },
//                    label = { Text(destination.label) },
//                    selected = destination == currentDestination,
//                    onClick = { currentDestination = destination }
//                )
//            }
//        }
//    ) {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            when (currentDestination) {
//                AppDestinations.HOME ->
//                    HomeScreen(Modifier.padding(innerPadding))
//
//                AppDestinations.FAVORITES ->
//                    FavoritesScreen(Modifier.padding(innerPadding))
//
//                AppDestinations.PROFILE ->
//                    ProfileScreen(Modifier.padding(innerPadding))
//            }
//        }
//    }
//}
//
//enum class AppDestinations(
//    val label: String,
//    val icon: ImageVector,
//) {
//    HOME("Home", Icons.Default.Home),
//    FAVORITES("Favorites", Icons.Default.Favorite),
//    PROFILE("Profile", Icons.Default.AccountBox),
//}
//
///* -------------------- SCREENS -------------------- */
//
//@Composable
//fun HomeScreen(modifier: Modifier = Modifier) {
//    CenteredTextScreen(
//        text = "HOME SCREEN",
//        modifier = modifier
//    )
//}
//
//@Composable
//fun FavoritesScreen(modifier: Modifier = Modifier) {
//    CenteredTextScreen(
//        text = "FAVORITES SCREEN",
//        modifier = modifier
//    )
//}
//
//@Composable
//fun ProfileScreen(modifier: Modifier = Modifier) {
//    CenteredTextScreen(
//        text = "PROFILE SCREEN",
//        modifier = modifier
//    )
//}
//
///* -------------------- REUSABLE UI -------------------- */
//
//@Composable
//fun CenteredTextScreen(
//    text: String,
//    modifier: Modifier = Modifier
//) {
//    Box(
//        modifier = modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = text,
//            style = MaterialTheme.typography.headlineMedium
//        )
//    }
//}
