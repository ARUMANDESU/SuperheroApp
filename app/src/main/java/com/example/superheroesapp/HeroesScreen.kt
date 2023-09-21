package com.example.superheroesapp

import android.hardware.camera2.params.MeteringRectangle
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            modifier = Modifier.padding(16.dp)
        ) {
            SuperheroItemInfo(
                nameRes = hero.nameRes,
                descriptionRes = hero.descriptionRes,
                modifier = Modifier.padding(end = 16.dp)
            )
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.descriptionRes),
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small)
            )
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
@Preview
@Composable
fun SuperheroItemPreview(){
    SuperHeroesAppTheme {
        SuperheroItem(hero = HeroesRepository.heroes[1])
    }
}