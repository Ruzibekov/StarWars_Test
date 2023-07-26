package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.starwars_test.R

object DataNotAvailableView {

    @Composable
    fun Default() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painter = painterResource(id = R.drawable.img_no_data),
                    contentDescription = "no data image",
                    modifier = Modifier
                        .size(128.dp)
                        .padding(16.dp)
                )

                Text(
                    text = stringResource(id = R.string.data_is_empty)
                )
            }
        }
    }
}