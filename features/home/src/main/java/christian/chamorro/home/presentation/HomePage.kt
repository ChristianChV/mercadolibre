package christian.chamorro.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import christian.chamorro.home.R
import christian.chamorro.product.presentation.favoritebanner.FavoritesBanner
import christian.chamorro.uicomponents.colors.AppColors

@Composable
fun HomePage(
    goToSearch: () -> Unit,
    goToProductDetail: (String) -> Unit,
) {
    val interactionSourceSearchBar =
        remember {
            MutableInteractionSource()
        }
    val typo = MaterialTheme.typography

    Scaffold(
        content = { contentPadding ->

            Column(
                Modifier
                    .padding(contentPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier =
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(AppColors.Secondary()),
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            modifier = Modifier.height(140.dp),
                            painter = painterResource(id = R.drawable.applogo),
                            contentDescription = stringResource(id = R.string.app_logo),
                        )

                        Spacer(modifier = Modifier.height(56.dp))

                        TextField(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                            shape = RoundedCornerShape(25.dp),
                            value = "",
                            placeholder = { Text(text = stringResource(id = R.string.search_products_brands_more)) },
                            onValueChange = {},
                            readOnly = true,
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = christian.chamorro.uicomponents.R.drawable.search_icon),
                                    contentDescription = stringResource(id = R.string.search),
                                )
                            },
                            interactionSource =
                                interactionSourceSearchBar.also { interactionSource ->
                                    LaunchedEffect(interactionSource) {
                                        interactionSource.interactions.collect {
                                            if (it is PressInteraction.Release) {
                                                goToSearch()
                                            }
                                        }
                                    }
                                },
                            colors =
                                TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                ),
                        )
                    }
                }

                Column(
                    modifier =
                        Modifier
                            .weight(1f)
                            .background(AppColors.Primary())
                            .fillMaxWidth(),
                ) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .weight(1f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier =
                                Modifier
                                    .padding(start = 24.dp, end = 24.dp),
                            textAlign = TextAlign.Center,
                            text =
                                stringResource(
                                    id = R.string.find_product_one_step,
                                ),
                            style = typo.titleLarge,
                            color = AppColors.OnPrimary(),
                        )
                    }

                    FavoritesBanner(
                        goToProductDetail = { goToProductDetail(it) },
                    )
                }
            }
        },
    )
}
