package christian.chamorro.uicomponents.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import christian.chamorro.uicomponents.colors.AppColors

@Composable
fun LoadingScreen(modifier: Modifier? = null) {
    Box(
        modifier = modifier ?: Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = AppColors.Primary(),
        )
    }
}
