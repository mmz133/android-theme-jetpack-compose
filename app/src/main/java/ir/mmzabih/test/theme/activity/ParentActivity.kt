package ir.mmzabih.test.theme.activity

import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import ir.mmzabih.test.theme.Application


abstract class ParentActivity : ComponentActivity() {

	override fun onResume() {
		super.onResume()
		Application.setCurrentActivity(this)
	}

	override fun onBackPressed() {
		when (Application.getCurrentActivity()) {
			is MainActivity -> {
				super.onBackPressed()
			}

			else -> {
				val intent =
					Intent(Application.getCurrentActivity(), MainActivity::class.java)
				startActivity(intent)
				finish()
			}
		}
	}

}