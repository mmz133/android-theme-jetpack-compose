package ir.mmzabih.test.theme.activity

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmzabih.test.theme.Application
import ir.mmzabih.test.theme.ui.theme.AppTheme

class MainActivity : ParentActivity() {


	override fun onStart() {
		super.onStart()

		setContent {
			AppTheme {
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
			horizontalAlignment = Alignment.CenterHorizontally,
		) {

			val buttonWidth = 210.dp
			val buttonIconWeight = 0.3f
			val buttonTextWeight = 0.7f

			Button(
				onClick = {
					val intent =
						Intent(Application.getCurrentActivity(), SettingsActivity::class.java)
					startActivity(intent)
					finish()
				},
				modifier = Modifier.width(buttonWidth),
			) {
				Icon(
					Icons.Filled.Settings,
					contentDescription = "Favorite",
					modifier = Modifier
						.size(ButtonDefaults.IconSize)
						.weight(buttonIconWeight)
				)
				Spacer(Modifier.size(ButtonDefaults.IconSpacing))
				Text(
					text = "Settings",
					modifier = Modifier.weight(buttonTextWeight),
					textAlign = TextAlign.Center
				)
			}

			Spacer(Modifier.height(20.dp))

			Button(
				onClick = {
					val intent =
						Intent(Application.getCurrentActivity(), FullScreenActivity::class.java)
					startActivity(intent)
					finish()
				},
				modifier = Modifier.width(buttonWidth),
			) {
				Icon(
					Icons.Filled.Info,
					contentDescription = "Favorite",
					modifier = Modifier
						.size(ButtonDefaults.IconSize)
						.weight(buttonIconWeight)
				)
				Spacer(Modifier.size(ButtonDefaults.IconSpacing))
				Text(
					text = "FullScreen",
					modifier = Modifier.weight(buttonTextWeight),
					textAlign = TextAlign.Center
				)
			}

			Spacer(Modifier.height(20.dp))

			Button(
				onClick = {
					val intent =
						Intent(Application.getCurrentActivity(), NormalColorActivity::class.java)
					startActivity(intent)
					finish()
				},
				modifier = Modifier.width(buttonWidth),
			) {
				Icon(
					Icons.Filled.Create,
					contentDescription = "Favorite",
					modifier = Modifier
						.size(ButtonDefaults.IconSize)
						.weight(buttonIconWeight)
				)
				Spacer(Modifier.size(ButtonDefaults.IconSpacing))
				Text(
					text = "Colored all",
					modifier = Modifier.weight(buttonTextWeight),
					textAlign = TextAlign.Center
				)
			}

			Spacer(Modifier.height(20.dp))

			Text("This activity has normal SystemBars")

			Spacer(modifier = Modifier.height(20.dp))
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