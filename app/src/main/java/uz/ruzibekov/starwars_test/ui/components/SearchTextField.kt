package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors
import uz.ruzibekov.starwars_test.ui.theme.StarWarsIcons

object SearchTextField {

    @Composable
    fun Default(viewModel: MainViewModel) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = StarWarsColors.Dark
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Icon(
                    painter = painterResource(id = StarWarsIcons.Search),
                    contentDescription = "search icon",
                    modifier = Modifier.size(24.dp),
                    tint = StarWarsColors.Gray
                )

                Spacer(modifier = Modifier.width(10.dp))

                Box {

                    if (viewModel.search.value.isEmpty())
                        Text(
                            text = stringResource(R.string.search),
                            style = MaterialTheme.typography.displayMedium,
                        )

                    BasicTextField(
                        value = viewModel.search.value,
                        onValueChange = { viewModel.onSearch(it) },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = MaterialTheme.typography.displayMedium,
                        cursorBrush = SolidColor(StarWarsColors.Gray)
                    )
                }
            }
        }
    }
}