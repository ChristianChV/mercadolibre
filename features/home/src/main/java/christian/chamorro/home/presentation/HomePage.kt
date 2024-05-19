package christian.chamorro.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
            )
        },
        content = { contentPadding ->

            Column(
                Modifier
                    .padding(contentPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.weight(1f)){

                }

                Box(modifier = Modifier.weight(1f)){

                }
            }
        }
    )
}