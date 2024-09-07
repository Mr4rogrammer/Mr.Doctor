/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import info.mrprogrammer.doctor.domain.model.MainScreenUiModel
import info.mrprogrammer.doctor.domain.useCases.GetBottomBarMenu
import info.mrprogrammer.doctor.domain.useCases.GetMenu
import info.mrprogrammer.doctor.domain.useCases.GetNearByDoctor
import info.mrprogrammer.doctor.domain.useCases.GetUpComingEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val GetBottomBarMenu: GetBottomBarMenu,
    private val GetUpComingEvent: GetUpComingEvent,
    private val GetMenu: GetMenu,
    private val GetNearByDoctor: GetNearByDoctor,
) :
    ViewModel() {
    private var _mainScreenUiModel = MutableStateFlow<MainScreenUiModel?>(MainScreenUiModel())
    val mainScreenUiModel: StateFlow<MainScreenUiModel?> = _mainScreenUiModel.asStateFlow()

    init {
        viewModelScope.launch {
            _mainScreenUiModel.value =
                _mainScreenUiModel.value?.copy(bottomBarModel = GetBottomBarMenu.invoke())
            _mainScreenUiModel.value =
                _mainScreenUiModel.value?.copy(doctorInfoCardModel = GetUpComingEvent.invoke())
            _mainScreenUiModel.value = _mainScreenUiModel.value?.copy(menuModel = GetMenu.invoke())
            _mainScreenUiModel.value = _mainScreenUiModel.value?.copy(nearDoctorInfoCardModel = GetNearByDoctor.invoke())
        }
    }
}