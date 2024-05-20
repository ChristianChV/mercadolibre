package christian.chamorro.product.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import christian.chamorro.product.domain.models.Attribute
import christian.chamorro.uicomponents.composables.CustomCard

@Composable
fun AttributesComposable(
    attributes: List<Attribute>
){
    CustomCard(
        modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
    }
}