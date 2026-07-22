package com.example.mealplanneraiapp.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePageScreen() {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Welcome Sarah",
            color = Color(0xFF47675A),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp),
        )
        Text(
            text = "What would you like to make today?",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        )

        // Insert a carousel of pics that AI spun up depending on what we have
        // stored in the database
        MealIdealsCarousel()
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePageScreenPreview() {
    HomePageScreen()
}