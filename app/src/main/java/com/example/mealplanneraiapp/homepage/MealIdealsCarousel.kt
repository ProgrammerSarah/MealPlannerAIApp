package com.example.mealplanneraiapp.homepage

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil3.compose.AsyncImage
import com.example.mealplanneraiapp.R
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

/**
 * An auto advanced carousel of meal ideas that should page through all the meal images ideas
 */
@Composable
fun MealIdealsCarousel() {
    Box(modifier = Modifier
        .wrapContentSize()
        .padding(16.dp)
    ) {
        // We use a large number for page count to simulate infinite scrolling
        val pageCount = Int.MAX_VALUE
        // Start in the middle so we can scroll both ways
        val initialPage = pageCount / 2 - (pageCount / 2 % localMealIdeaImages.size)
        
        val pagerState = rememberPagerState(
            initialPage = initialPage,
            pageCount = { pageCount },
        )
        val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

        val pageInteractionSource = remember { MutableInteractionSource() }
        val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

        // Stop auto-advancing when pager is dragged or one of the pages is pressed
        val autoAdvance = !pagerIsDragged && !pageIsPressed

        if (autoAdvance) {
            LaunchedEffect(pagerState, pageInteractionSource) {
                while (true) {
                    delay(2000)
                    val nextPage = pagerState.currentPage + 1
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }

            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fixed(250.dp),
                pageSpacing = 30.dp,
                contentPadding = PaddingValues(horizontal = 32.dp),
                snapPosition = SnapPosition.Center,
            ) { virtualPage ->
                val page = virtualPage % localMealIdeaImages.size
                Card(
                    Modifier
                        .size(250.dp)
                        .align(Alignment.Center)
                        .clickable(
                            interactionSource = pageInteractionSource,
                            indication = LocalIndication.current
                        ) {
                            // Handle page click
                        }
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - virtualPage) + pagerState
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