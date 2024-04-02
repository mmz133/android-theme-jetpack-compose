package ir.mmzabih.test.theme.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmzabih.test.jetpacktest.ui.theme.DarkModeState
import ir.mmzabih.test.jetpacktest.ui.theme.SystemBarsState
import ir.mmzabih.test.jetpacktest.viewmodel.DarkModeViewModel
import ir.mmzabih.test.theme.ui.theme.AppTheme

class SettingsActivity : ParentActivity() {

	private lateinit var darkModeViewModel: DarkModeViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

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

	}


	@Composable
	private fun MainPage() {
		Column(
			modifier = Modifier.padding(8.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			DarkModeRadioGroup()
			Spacer(Modifier.height(30.dp))
			Text("This activity has transparent systembars")
		}
	}

	@Composable
	private fun DarkModeRadioGroup() {

		val darkModeState = darkModeViewModel.getDarkModeState()

		Card(
			modifier = Modifier.padding(22.dp),
			elevation = CardDefaults.cardElevation(10.dp)
		) {
			Column(
				modifier = Modifier.padding(22.dp)
			) {

				Text(
					text = "DarkMode State:"
				)

				Spacer(modifier = Modifier.height(20.dp))

				Column(
					Modifier.selectableGroup()
				) {
					Row(
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
							.clickable {
								darkModeViewModel.setDarkModeState(DarkModeState.Auto)
							}
					) {
						RadioButton(
							selected = (darkModeState == DarkModeState.Auto),
							onClick = {
								darkModeViewModel.setDarkModeState(DarkModeState.Auto)
							},
							modifier = Modifier.semantics { contentDescription = "Auto" },
						)
						Spacer(modifier = Modifier.width(5.dp))
						Text(
							text = "Auto (System Default)"
						)
					}
					Row(
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
							.clickable {
								darkModeViewModel.setDarkModeState(DarkModeState.Light)
							}
					) {
						RadioButton(
							selected = (darkModeState == DarkModeState.Light),
							onClick = {
								darkModeViewModel.setDarkModeState(DarkModeState.Light)
							},
							modifier = Modifier.semantics { contentDescription = "Day" }
						)
						Spacer(modifier = Modifier.width(5.dp))
						Text(
							text = "Day"
						)
					}
					Row(
						verticalAlignment = Alignment.CenterVertically,
						modifier = Modifier
							.fillMaxWidth()
							.clickable {
								darkModeViewModel.setDarkModeState(DarkModeState.Dark)
							}
					) {
						RadioButton(
							selected = (darkModeState == DarkModeState.Dark),
							onClick = {
								darkModeViewModel.setDarkModeState(DarkModeState.Dark)
							},
							modifier = Modifier.semantics { contentDescription = "Night" }
						)
						Spacer(modifier = Modifier.width(5.dp))
						Text(
							text = "Night"
						)
					}
				}
			}
		}
	}

	@Preview(
		showSystemUi = true,
		showBackground = true
	)
	@Composable
	private fun MainPagePreview() {
		MainPage()
	}

}