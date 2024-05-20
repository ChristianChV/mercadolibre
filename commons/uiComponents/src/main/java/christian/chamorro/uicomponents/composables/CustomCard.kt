package christian.chamorro.uicomponents.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import christian.chamorro.uicomponents.colors.AppColors

@Composable
fun CustomCard(
    modifier: Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors =
            CardColors(
                containerColor = AppColors.OnPrimary(),
                contentColor = AppColors.Primary(),
                disabledContainerColor = AppColors.PrimaryContainer(),
                disabledContentColor = AppColors.PrimaryContainer(),
            ),
        content = content,
    )
}
