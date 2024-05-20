package christian.chamorro.search.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import christian.chamorro.search.R
import christian.chamorro.search.domain.models.SearchProduct
import christian.chamorro.uicomponents.adapters.toCurrency
import coil.compose.AsyncImage

@Composable
fun SearchResultItem(
    searchProduct: SearchProduct,
    goToProductDetail: (String) -> Unit,
) {
    val typo = MaterialTheme.typography

    Card(
        modifier =
            Modifier
                .fillMaxSize()
                .clickable { goToProductDetail(searchProduct.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(Modifier.fillMaxSize()) {
            AsyncImage(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                model = searchProduct.thumbnail,
                contentDescription = stringResource(id = R.string.product_image),
                contentScale = ContentScale.Crop,
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = searchProduct.title,
                    textAlign = TextAlign.Center,
                    style = typo.labelMedium,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = searchProduct.price.toCurrency(),
                    textAlign = TextAlign.Center,
                    style = typo.bodyMedium,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text =
                        stringResource(
                            id = R.string.available_ammount,
                        ) + "${searchProduct.availableQuantity}",
                    textAlign = TextAlign.Center,
                    style = typo.labelSmall,
                )
            }
        }
    }
}
