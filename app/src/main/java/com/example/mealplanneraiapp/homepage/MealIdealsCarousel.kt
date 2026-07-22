package com.example.mealplanneraiapp.homepage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil3.compose.AsyncImage
import com.example.mealplanneraiapp.R
import kotlin.math.absoluteValue


@Composable
fun MealIdealsCarousel() {
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(state = pagerState) { page ->
        Card(
            Modifier
                .size(200.dp)
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            AsyncImage(
                model = localMealIdeaImages[page],
                contentDescription = "Meal option $page",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

        }
    }
}

val localMealIdeaImages = listOf(
    R.drawable.stomach_reset_meal,
    R.drawable.dragon_fruit_meal,
    R.drawable.fish_meal,
    R.drawable.fruit_bowl,
    R.drawable.roast_duck_meal,
    R.drawable.salmon_meal,
    R.drawable.squash_soup_meal,
    R.drawable.stomach_reset_meal,
)

@Preview(showSystemUi = true)
@Composable
fun MealIdealsCarouselPreview() {
    MealIdealsCarousel()
}