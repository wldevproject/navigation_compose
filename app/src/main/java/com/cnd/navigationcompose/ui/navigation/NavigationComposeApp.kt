package com.cnd.navigationcompose.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.cnd.navigationcompose.ui.screen.favorites.FavoritesScreen
import com.cnd.navigationcompose.ui.screen.home.HomeScreen
import com.cnd.navigationcompose.ui.screen.profile.ProfileScreen

@Composable
fun NavigationComposeApp() {
    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.HOME)
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = {
                        Icon(
                            destination.icon,
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when (currentDestination) {
                AppDestinations.HOME ->
                    HomeScreen(Modifier.padding(innerPadding))

                AppDestinations.FAVORITES ->
                    FavoritesScreen(Modifier.padding(innerPadding))

                AppDestinations.PROFILE ->
                    ProfileScreen(Modifier.padding(innerPadding))
            }
        }
    }
}
