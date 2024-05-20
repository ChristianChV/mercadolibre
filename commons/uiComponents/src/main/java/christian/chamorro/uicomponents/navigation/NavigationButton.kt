package christian.chamorro.uicomponents.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import christian.chamorro.uicomponents.R

@Composable
fun NavigationButton(navController: NavController) {
    IconButton(
        onClick = {
            if (navController.previousBackStackEntry != null) {
                navController.popBackStack()
            }
        },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back_icon),
            contentDescription = stringResource(id = R.string.nat_button_back),
        )
    }
}
