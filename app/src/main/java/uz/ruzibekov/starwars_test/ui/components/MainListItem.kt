package uz.ruzibekov.starwars_test.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ruzibekov.domain.model.response.personage.Personage
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.starwars_test.R
import uz.ruzibekov.starwars_test.ui.MainViewModel
import uz.ruzibekov.starwars_test.ui.theme.StarWarsColors
import uz.ruzibekov.starwars_test.ui.theme.StarWarsIcons

object MainListItem {

    @Composable
    fun Default(data: Personage, viewModel: MainViewModel) {
        var isFavorite by remember { mutableStateOf(viewModel.personageIsFavorite(data)) }

        Surface(
            modifier = Modifier.padding(bottom = 5.dp),
            border = BorderStroke(1.dp, StarWarsColors.Gray),
            shape = RoundedCornerShape(8.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.width(180.dp)) {
                    Text(
                        text = stringResource(id = R.string.name_s_text, data.name),
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = stringResource(R.string.gender_s_text, data.gender),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = stringResource(R.string.starships_count_s_number, data.starships.size),
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 12.sp,
                    modifier = Modifier.width(150.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        if (isFavorite) {
                            viewModel.removeFavoritePersonage(data)
                        } else {
                            viewModel.addFavoritePersonage(data)
                        }
                        isFavorite = !isFavorite
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isFavorite) StarWarsIcons.Favorite
                            else StarWarsIcons.Unfavorite
                        ),
                        contentDescription = "favorite icon",
                    )
                }
            }
        }
    }

    @Composable
    fun Default(data: Starship, viewModel: MainViewModel) {

        var isFavorite by remember { mutableStateOf(viewModel.starshipIsFavorite(data)) }

        Surface(
            modifier = Modifier.padding(bottom = 5.dp),
            border = BorderStroke(1.dp, StarWarsColors.Gray),
            shape = RoundedCornerShape(8.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(modifier = Modifier.width(180.dp)) {

                    Text(
                        text = stringResource(R.string.name_s_text, data.name),
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 1
                    )

                    Text(
                        text = stringResource(R.string.manufacturer_s_text, data.manufacturer),
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 2,
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))

                Column(modifier = Modifier.width(150.dp),) {


                    Text(
                        text = stringResource(R.string.model_s_text, data.model),
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 1,
                        fontSize = 12.sp
                    )

                    Text(
                        text = stringResource(R.string.passengers_s_text, data.passengers),
                        style = MaterialTheme.typography.labelMedium,
                        maxLines = 1,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        if (isFavorite) {
                            viewModel.removeFavoriteStarship(data)
                        } else {
                            viewModel.addFavoriteStarship(data)
                        }
                        isFavorite = !isFavorite
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (isFavorite) StarWarsIcons.Favorite
                            else StarWarsIcons.Unfavorite
                        ),
                        contentDescription = "favorite icon",
                    )
                }
            }
        }
    }
}