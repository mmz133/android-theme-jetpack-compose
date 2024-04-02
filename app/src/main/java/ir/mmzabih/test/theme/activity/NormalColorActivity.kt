package ir.mmzabih.test.theme.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmzabih.test.jetpacktest.ui.theme.SystemBarsState
import ir.mmzabih.test.jetpacktest.viewmodel.DarkModeViewModel
import ir.mmzabih.test.theme.ui.theme.AppTheme

class NormalColorActivity : ParentActivity() {

	private lateinit var darkModeViewModel: DarkModeViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			AppTheme(
				systemBarsState = SystemBarsState.Normal_Color,
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

			Text("This activity has normal color systembars")
			Spacer(modifier = Modifier.height(20.dp))
			Button(
				onClick = {
					//
				}
			) {
				Text(
					text = "test",
					textAlign = TextAlign.Center
				)
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