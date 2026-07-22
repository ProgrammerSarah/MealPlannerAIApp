# Implementation Plan - Modernizing the App Look with Material 3

Your app is already using Material 3, but it's currently using the default "Purple" template. To make it "pretty" and professional, we can leverage more advanced Material 3 features and design principles tailored for a food/baking app.

## User Review Required

> [!IMPORTANT]
> **Design Theme**: I propose moving away from the default purple to a warmer, "food-friendly" color palette (e.g., oranges, greens, or creamy tones). Does this sound good to you?
>
> **Layout Style**: I suggest using `ElevatedCard` for images and a `TopAppBar` for better structure.

## Proposed Changes

### 1. Theme and Branding

#### [MODIFY] [Color.kt](file:///Users/sarahpham/Development/MealPlannerAIApp/app/src/main/java/com/example/mealplanneraiapp/ui/theme/Color.kt)
- Define a new color palette that fits a baking/food app theme.
- For example: Warm Orange for primary, Sage Green for secondary.

#### [MODIFY] [Theme.kt](file:///Users/sarahpham/Development/MealPlannerAIApp/app/src/main/java/com/example/mealplanneraiapp/ui/theme/Theme.kt)
- Update `LightColorScheme` and `DarkColorScheme` with the new colors.
- Ensure Dynamic Color remains enabled for a personalized feel on Android 12+.

### 2. UI Structure and Components

#### [MODIFY] [BakingScreen.kt](file:///Users/sarahpham/Development/MealPlannerAIApp/app/src/main/java/com/example/mealplanneraiapp/BakingScreen.kt)
- **TopAppBar**: Add a `CenterAlignedTopAppBar` with the "Baking with Gemini" title.
- **Image Cards**: Wrap the baked goods images in `OutlinedCard` or `ElevatedCard` with rounded corners.
- **Input Area**: Improve the spacing and styling of the `TextField` and `Button`.
- **Content Area**: Use `MaterialTheme.typography` more effectively for results.

### 3. Polish and Modernity

#### [MODIFY] [MainActivity.kt](file:///Users/sarahpham/Development/MealPlannerAIApp/app/src/main/java/com/example/mealplanneraiapp/MainActivity.kt)
- **Edge-to-Edge**: Enable edge-to-edge display using `enableEdgeToEdge()` for a more immersive feel.
- **System Bars**: Configure system bar colors to match the theme.

## Verification Plan

### Manual Verification
- Deploy to an emulator/device to verify:
    - The new color scheme looks appealing.
    - The `TopAppBar` and `Cards` provide better visual hierarchy.
    - The app respects system insets (Edge-to-Edge).
    - Light and Dark modes both look great.
