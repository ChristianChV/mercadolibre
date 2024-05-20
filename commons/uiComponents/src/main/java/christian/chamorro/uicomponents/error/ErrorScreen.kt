package christian.chamorro.uicomponents.error

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import christian.chamorro.uicomponents.R
import christian.chamorro.uicomponents.colors.AppColors

@Composable
fun ErrorScreen(
    title: String,
    subtitle: String,
    reload: ()-> Unit,
    modifier: Modifier
){
    val typo = MaterialTheme.typography

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier.size(60.dp),
            painter = painterResource(
            id = R.drawable.error_icon),
            contentDescription = stringResource(id = R.string.error),
            tint = AppColors.Error()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = title, style = typo.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = subtitle, style = typo.titleSmall)

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { reload() }
        ) {
            Text(text = stringResource(id = R.string.recharge))
        }


    }
}