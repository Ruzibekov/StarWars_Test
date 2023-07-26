package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors

object MainLabel {

    @Composable
    fun Default(textRes: Int) {
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 8.dp),
            color = StarWarsColors.White
        )
    }
}