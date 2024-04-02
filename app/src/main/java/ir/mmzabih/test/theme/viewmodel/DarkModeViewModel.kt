package ir.mmzabih.test.jetpacktest.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ir.mmzabih.test.jetpacktest.ui.theme.DarkModeState
import ir.mmzabih.test.theme.Application

class DarkModeViewModel : ViewModel() {
	
	private var darkModeState: MutableState<DarkModeState> =
		mutableStateOf(Application.getDarkModeState())
	
	fun setDarkModeState(inputDarkModeState: DarkModeState) {
		darkModeState.value = inputDarkModeState
		Application.setDarkModeState(inputDarkModeState)
	}
	
	
	fun getDarkModeState(): DarkModeState = darkModeState.value
	
}