package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

object MainLabel {

    @Composable
    fun Default(textRes: Int) {
        Text(text = stringResource(id = textRes))
    }
}