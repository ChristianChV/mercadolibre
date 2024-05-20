package christian.chamorro.product.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import christian.chamorro.product.domain.models.Attribute
import christian.chamorro.uicomponents.colors.AppColors
import christian.chamorro.uicomponents.composables.CustomCard

@Composable
fun ProductAttributes(attributes: List<Attribute>) {
    val typo = MaterialTheme.typography

    val rowPadding = PaddingValues(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 12.dp)

    CustomCard(
        modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
    ) {
        Column(
            Modifier
                .clip(RoundedCornerShape(15.dp)),
        ) {
            attributes.forEachIndexed { index, attribute ->
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(if (index % 2 == 0) AppColors.PrimaryContainer() else AppColors.OnPrimary()),
                ) {
                    Text(
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(rowPadding),
                        text = attribute.name,
                        style = typo.labelMedium,
                    )
                    Text(
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(rowPadding),
                        text = attribute.valueName.orEmpty(),
                        style = typo.labelMedium,
                    )
                }
            }
        }
    }
}
