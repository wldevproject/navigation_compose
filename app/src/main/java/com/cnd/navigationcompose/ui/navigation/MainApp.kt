import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.cnd.navigationcompose.ui.navigation.AppDestinations
import com.cnd.navigationcompose.ui.screen.favorites.FavoritesScreen
import com.cnd.navigationcompose.ui.screen.home.HomeScreen
import com.cnd.navigationcompose.ui.screen.profile.ProfileScreen

@Composable
fun MainApp(
    onLogout: () -> Unit
) {
    var currentDestination by rememberSaveable {
        mutableStateOf(AppDestinations.HOME)
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = { Icon(destination.icon, null) },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        when (currentDestination) {
            AppDestinations.HOME -> HomeScreen()
            AppDestinations.FAVORITES -> FavoritesScreen()
            AppDestinations.PROFILE ->
                ProfileScreen(onLogout = onLogout)
        }
    }
}

