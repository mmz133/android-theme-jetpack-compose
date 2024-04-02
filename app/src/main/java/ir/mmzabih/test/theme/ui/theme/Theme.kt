package ir.mmzabih.test.theme.ui.theme

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import ir.mmzabih.test.jetpacktest.ui.theme.DarkModeState
import ir.mmzabih.test.jetpacktest.ui.theme.SystemBarsState
import ir.mmzabih.test.jetpacktest.viewmodel.DarkModeViewModel

private val lightColorScheme = lightColorScheme(
	surfaceTint = md_theme_light_surfaceTint,
	onErrorContainer = md_theme_light_onErrorContainer,
	onError = md_theme_light_onError,
	errorContainer = md_theme_light_errorContainer,
	onTertiaryContainer = md_theme_light_onTertiaryContainer,
	onTertiary = md_theme_light_onTertiary,
	tertiaryContainer = md_theme_light_tertiaryContainer,
	tertiary = md_theme_light_tertiary,
	error = md_theme_light_error,
	outline = md_theme_light_outline,
	onBackground = md_theme_light_onBackground,
	background = md_theme_light_background,
	inverseOnSurface = md_theme_light_inverseOnSurface,
	inverseSurface = md_theme_light_inverseSurface,
	onSurfaceVariant = md_theme_light_onSurfaceVariant,
	onSurface = md_theme_light_onSurface,
	surfaceVariant = md_theme_light_surfaceVariant,
	surface = md_theme_light_surface,
	onSecondaryContainer = md_theme_light_onSecondaryContainer,
	onSecondary = md_theme_light_onSecondary,
	secondaryContainer = md_theme_light_secondaryContainer,
	secondary = md_theme_light_secondary,
	inversePrimary = md_theme_light_inversePrimary,
	onPrimaryContainer = md_theme_light_onPrimaryContainer,
	onPrimary = md_theme_light_onPrimary,
	primaryContainer = md_theme_light_primaryContainer,
	primary = md_theme_light_primary,
)


private val darkColorScheme = darkColorScheme(
	surfaceTint = md_theme_dark_surfaceTint,
	onErrorContainer = md_theme_dark_onErrorContainer,
	onError = md_theme_dark_onError,
	errorContainer = md_theme_dark_errorContainer,
	onTertiaryContainer = md_theme_dark_onTertiaryContainer,
	onTertiary = md_theme_dark_onTertiary,
	tertiaryContainer = md_theme_dark_tertiaryContainer,
	tertiary = md_theme_dark_tertiary,
	error = md_theme_dark_error,
	outline = md_theme_dark_outline,
	onBackground = md_theme_dark_onBackground,
	background = md_theme_dark_background,
	inverseOnSurface = md_theme_dark_inverseOnSurface,
	inverseSurface = md_theme_dark_inverseSurface,
	onSurfaceVariant = md_theme_dark_onSurfaceVariant,
	onSurface = md_theme_dark_onSurface,
	surfaceVariant = md_theme_dark_surfaceVariant,
	surface = md_theme_dark_surface,
	onSecondaryContainer = md_theme_dark_onSecondaryContainer,
	onSecondary = md_theme_dark_onSecondary,
	secondaryContainer = md_theme_dark_secondaryContainer,
	secondary = md_theme_dark_secondary,
	inversePrimary = md_theme_dark_inversePrimary,
	onPrimaryContainer = md_theme_dark_onPrimaryContainer,
	onPrimary = md_theme_dark_onPrimary,
	primaryContainer = md_theme_dark_primaryContainer,
	primary = md_theme_dark_primary,
)

private val animationSpec: AnimationSpec<Color> = tween(durationMillis = 500)

@Composable
private fun animateColor(
	targetValue: Color
) = animateColorAsState(
	targetValue = targetValue,
	animationSpec = animationSpec,
	label = "dark"
).value

@Composable
fun ColorScheme.switch() = copy(
	surfaceTint = animateColor(surfaceTint),
	onErrorContainer = animateColor(onErrorContainer),
	onError = animateColor(onError),
	errorContainer = animateColor(errorContainer),
	onTertiaryContainer = animateColor(onTertiaryContainer),
	onTertiary = animateColor(onTertiary),
	tertiaryContainer = animateColor(tertiaryContainer),
	tertiary = animateColor(tertiary),
	error = animateColor(error),
	outline = animateColor(outline),
	onBackground = animateColor(onBackground),
	background = animateColor(background),
	inverseOnSurface = animateColor(inverseOnSurface),
	inverseSurface = animateColor(inverseSurface),
	onSurfaceVariant = animateColor(onSurfaceVariant),
	onSurface = animateColor(onSurface),
	surfaceVariant = animateColor(surfaceVariant),
	surface = animateColor(surface),
	onSecondaryContainer = animateColor(onSecondaryContainer),
	onSecondary = animateColor(onSecondary),
	secondaryContainer = animateColor(secondaryContainer),
	secondary = animateColor(secondary),
	inversePrimary = animateColor(inversePrimary),
	onPrimaryContainer = animateColor(onPrimaryContainer),
	onPrimary = animateColor(onPrimary),
	primaryContainer = animateColor(primaryContainer),
	primary = animateColor(primary),
)

@Composable
fun AppTheme(
	darkModeViewModel: DarkModeViewModel = DarkModeViewModel(),
	systemBarsState: SystemBarsState = SystemBarsState.Normal,
	//dynamicColor: Boolean = false,
	content: @Composable () -> Unit
) {

	val darkModeState: DarkModeState = darkModeViewModel.getDarkModeState()

	val isAppInDarkTheme: Boolean =
		when (darkModeState) {
			DarkModeState.Auto -> {
				isSystemInDarkTheme()
			}

			DarkModeState.Light -> {
				false
			}

			DarkModeState.Dark -> {
				true
			}
		}

	val colorScheme = (if (isAppInDarkTheme) darkColorScheme else lightColorScheme).switch()

	val statusBarColor =
		when (systemBarsState) {
			SystemBarsState.Normal, SystemBarsState.Normal_Color -> {
				colorScheme.primary.toArgb()
			}

			else -> {
				Color.Transparent.toArgb()
			}
		}

	val navigationBarColor =
		when (systemBarsState) {
			SystemBarsState.Normal_Color -> {
				colorScheme.primary.toArgb()
			}

			else -> {
				Color.Transparent.toArgb()
			}
		}

	val view = LocalView.current
	val currentWindow = (view.context as? Activity)?.window
		?: throw Exception("Not in an activity - unable to get Window reference")


	if (!view.isInEditMode) {
		SideEffect {

			(view.context as Activity).window.statusBarColor = statusBarColor
			(view.context as Activity).window.navigationBarColor = navigationBarColor

			val windowInsetsController = WindowCompat.getInsetsController(currentWindow, view)
			windowInsetsController.isAppearanceLightStatusBars =
				if (systemBarsState == SystemBarsState.Normal || systemBarsState == SystemBarsState.Normal_Color) {
					isAppInDarkTheme
				} else {
					!isAppInDarkTheme
				}

			WindowCompat.setDecorFitsSystemWindows(currentWindow, false)

			when (systemBarsState) {

				SystemBarsState.Normal -> {
					windowInsetsController.isAppearanceLightNavigationBars = !isAppInDarkTheme
				}

				SystemBarsState.Normal_Color -> {
					windowInsetsController.isAppearanceLightNavigationBars = isAppInDarkTheme
				}

				SystemBarsState.Transparent -> {
					windowInsetsController.systemBarsBehavior =
						WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
					windowInsetsController.isAppearanceLightNavigationBars = !isAppInDarkTheme
				}

				SystemBarsState.Fullscreen -> {
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
						currentWindow.attributes.layoutInDisplayCutoutMode =
							WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
					}
					currentWindow.setFlags(
						WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
						WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
					)
					windowInsetsController.systemBarsBehavior =
						WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
					windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
				}
			}

		}
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}