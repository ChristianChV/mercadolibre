package christian.chamorro.search.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import christian.chamorro.uicomponents.R
import christian.chamorro.uicomponents.colors.AppColors
import kotlin.math.roundToInt

@Composable
fun QueryItem(
    query: String,
    setQuery: (String) -> Unit,
    getProductsByQuery: (String) -> Unit,
    deleteQuery: (String) -> Unit
) {

    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(AppColors.OnPrimary())
            .clickable {
                setQuery(query)
                getProductsByQuery(query)
            },

        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(start = 6.dp),
            painter = painterResource(id = R.drawable.time_icon),
            contentDescription = stringResource(id = christian.chamorro.search.R.string.previous_query)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Text(text = query)

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { deleteQuery(query) }) {
            Icon(
                painter = painterResource(
                    id = R.drawable.clear_icon
                ),
                contentDescription = stringResource(id = christian.chamorro.search.R.string.search)
            )
        }


    }
}