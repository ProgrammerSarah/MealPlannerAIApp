# Walkthrough - Centering the Carousel Cards

I have updated the `MealIdealsCarousel` to ensure the active card is always centered horizontally.

## Changes Made

### UI Components

#### [MealIdealsCarousel.kt](file:///Users/sarahpham/Development/MealPlannerAIApp/app/src/main/java/com/example/mealplanneraiapp/homepage/MealIdealsCarousel.kt)
- Added `import androidx.compose.foundation.gestures.snapping.SnapPosition`.
- Updated `HorizontalPager` with `snapPosition = SnapPosition.Center`.

## Verification Results

### Manual Verification
- Verified that the `HorizontalPager` now snaps the active card to the center of the viewport, providing a balanced and "pretty" layout.
- The `contentPadding` and `pageSpacing` now work together with the center alignment to show a consistent "peek" of the adjacent cards on both sides.
