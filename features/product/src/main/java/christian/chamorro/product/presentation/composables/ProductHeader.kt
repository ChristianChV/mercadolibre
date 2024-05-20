package christian.chamorro.product.presentation.composables

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.product.R
import christian.chamorro.product.domain.models.Product
import christian.chamorro.product.presentation.ProductEvent
import christian.chamorro.uicomponents.adapters.toCurrency
import christian.chamorro.uicomponents.composables.CustomCard
import coil.compose.AsyncImage

@Composable
fun ProductHeader(
    product: Product,
    isFavorite: Boolean,
    onEvent: (ProductEvent)->Unit
) {
    val favoriteIcon = if(isFavorite){
        christian.chamorro.uicomponents.R.drawable.favorite_full_icon
    } else {
        christian.chamorro.uicomponents.R.drawable.favorite_border_icon
    }

    val typo = MaterialTheme.typography
    
    val pagerState = rememberPagerState(
        pageCount = { product.pictures.size },
    )

    CustomCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Column(Modifier.padding(18.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
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
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))
                Text(text = product.originalPrice.toCurrency(), style = typo.titleLarge)
                Text(text = stringResource(id = R.string.quantity) + product.initialQuantity, style = typo.titleSmall)
                Text(text = product.warranty.orEmpty(), style = typo.titleSmall)
            }

            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    if (isFavorite){
                        onEvent(ProductEvent.RemoveFavorite)
                    }else{
                        onEvent(ProductEvent.AddFavorite)
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = favoriteIcon),
                    contentDescription = stringResource(
                        id = R.string.favorite
                    )
                )
            }
        }

    }
}