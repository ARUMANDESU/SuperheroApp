package com.example.superheroesapp

import android.content.res.Configuration
import android.hardware.camera2.params.MeteringRectangle
import android.widget.Space
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme



/**
 *  Composable that displays hero list item
 * @param hero The Hero object containing information about the superhero to be displayed.
 * @param modifier Modifiers to apply to this composable.
 */
@Composable
fun SuperheroItem(
    hero: Hero,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .sizeIn(minHeight = 72.dp)
        ) {
            SuperheroItemInfo(
                nameRes = hero.nameRes,
                descriptionRes = hero.descriptionRes,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size)) // Set a fixed size for the image here
                    .clip(MaterialTheme.shapes.small)
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(id = hero.descriptionRes),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize(),

                )
            }
        }
    }
}

/**
 * Composable that displays information about a superhero, including their name and description.
 *
 * @param nameRes The resource ID for the superhero's name string.
 * @param descriptionRes The resource ID for the superhero's description string.
 * @param modifier Modifiers to apply to this composable.
 */
@Composable
fun SuperheroItemInfo(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier,
){
  Column(modifier = modifier) {
      Text(
          text = stringResource(id = nameRes),
          style = MaterialTheme.typography.displaySmall,
      )
      Text(
          text = stringResource(id = descriptionRes),
          style = MaterialTheme.typography.bodyLarge,
      )
  }
}

/**
 *  Composable to preview SuperheroItem
 * */
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SuperheroItemPreview(){
    SuperHeroesAppTheme {
        SuperheroItem(hero = HeroesRepository.heroes[0])
    }
}
