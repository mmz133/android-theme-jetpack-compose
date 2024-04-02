package ir.mmzabih.test.theme

import android.app.Application
import ir.mmzabih.test.jetpacktest.ui.theme.DarkModeState
import ir.mmzabih.test.theme.activity.ParentActivity

class Application : Application() {
	
	companion object {
		
		private var mustInitCurrentActivity: Boolean = true
		private lateinit var currentActivity: ParentActivity
		private var darkModeState: DarkModeState = DarkModeState.Auto
		
		fun getDarkModeState(): DarkModeState = darkModeState
		
		fun setDarkModeState(inputDarkModeState: DarkModeState) {
			darkModeState = inputDarkModeState
		}
		
		fun setCurrentActivity(resumedActivity: ParentActivity) {
			if (mustInitCurrentActivity) {
				currentActivity = resumedActivity
				mustInitCurrentActivity = false
				return
			}
			currentActivity = resumedActivity
		}
		
		fun getCurrentActivity(): ParentActivity {
			return currentActivity
		}
		
	}
	
	
}