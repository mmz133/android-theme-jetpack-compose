DarkMode setting:
If you want to get or set DarkModeState you must add DarkmodeViewModel in that activity.

```kotlin
setContent {
			darkModeViewModel = DarkModeViewModel()
			AppTheme(
				darkModeViewModel = darkModeViewModel,
				systemBarsState = SystemBarsState.Transparent,
			) {

				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					MainPage()
				}
			}

		}
  ```

then you can do it like this:
```kotlin
val darkModeState = darkModeViewModel.getDarkModeState()
darkModeViewModel.setDarkModeState(DarkModeState.Dark)
```
it change the theme with animation!!!


SystemBars Settings:
Systembars settings has 4 states: normal, normal_color, transparrent and fullscreen. (default is normal).
Normal will set primary color for statusbar and will set navigationbar transparent.
Normal_color will set primary color for both.
Transparent will set both transparent.
Fullscreen will set activity in fullscreen.

if you want to set a state for a activity you must do it like this:
```kotlin
setContent {
			AppTheme(
				systemBarsState = SystemBarsState.Fullscreen,
			) {

				Surface(
					modifier = Modifier.fillMaxSize()
				) {
					MainPage()
				}
			}

		}
```
If you don't set systemBarsState, default is normal.
