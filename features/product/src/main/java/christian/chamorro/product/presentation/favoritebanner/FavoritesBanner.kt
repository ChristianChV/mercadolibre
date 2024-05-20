package christian.chamorro.product.presentation.favoritebanner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import christian.chamorro.product.R
import christian.chamorro.product.domain.models.Product
import christian.chamorro.uicomponents.adapters.toCurrency
import christian.chamorro.uicomponents.colors.AppColors
import christian.chamorro.uicomponents.composables.CustomCard
import coil.compose.AsyncImage

@Composable
fun ColumnScope.FavoritesBanner(
    viewModel: FavoritesBannerViewModel = hiltViewModel(),
    goToProductDetail: (String) -> Unit
) {
    LaunchedEffect(true) {
        viewModel.getFavorites()
    }

    val result = viewModel.state.collectAsState().value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (result.isNotEmpty()) Modifier.weight(1f) else Modifier
            )
    ) {

        when {
            result.isEmpty() -> {}
            else -> SetContent(result, goToProductDetail)
        }
    }
}

@Composable
fun SetContent(
    products: List<Product>,
    goToProduct: (String) -> Unit
) {
    val typo = MaterialTheme.typography

    Column(
        Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.favorites),
                color = AppColors.OnPrimary()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            items(products) { product ->
                CustomCard(
                    modifier = Modifier
                        .clickable {
                            goToProduct(product.id)
                        }
                        .wrapContentHeight()
                        .width(100.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .height(intrinsicSize = IntrinsicSize.Min)
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            modifier = Modifier.size(60.dp),
                            model = product.thumbnail,
                            contentDescription = stringResource(id = R.string.product_image)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = product.title,
                            style = typo.labelSmall,
                            color = AppColors.Primary(),
                            textAlign = TextAlign.Center,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = product.price.toCurrency(),
                            style = typo.labelSmall,
                            color = AppColors.Primary()
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }


}
