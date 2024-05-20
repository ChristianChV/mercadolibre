package christian.chamorro.product.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.product.R
import christian.chamorro.product.domain.models.Product
import christian.chamorro.uicomponents.adapters.toCurrency
import christian.chamorro.uicomponents.colors.AppColors
import christian.chamorro.uicomponents.composables.CustomCard
import coil.compose.AsyncImage

@Composable
fun Header(
    product: Product
) {
    val typo = MaterialTheme.typography
    
    val pagerState = rememberPagerState(
        pageCount = { product.pictures.size },
    )

    CustomCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalPager(
                modifier = Modifier
                    .size(160.dp)
                    .padding(4.dp),
                state = pagerState,
                snapPosition = SnapPosition.Center
            ) {
                AsyncImage(
                    modifier = Modifier.size(160.dp),
                    model = product.pictures[it],
                    contentDescription = stringResource(id = R.string.product_image),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = product.originalPrice.toCurrency(), style = typo.titleLarge)
                Text(text = stringResource(id = R.string.quantity) + product.initialQuantity, style = typo.titleSmall)
                Text(text = stringResource(id = R.string.product_warranty) + product.warranty, style = typo.titleSmall)
            }

        }
    }
}