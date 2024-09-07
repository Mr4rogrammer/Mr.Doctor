/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.domain.model

import androidx.compose.runtime.Stable
import info.mrprogrammer.doctor.ui.composable.bottombar.BottomBarModel
import info.mrprogrammer.doctor.ui.composable.card.DoctorInfoCardModel
import info.mrprogrammer.doctor.ui.composable.menu.MenuModel

@Stable
data class MainScreenUiModel(
    val bottomBarModel: List<BottomBarModel>? = null,
    val doctorInfoCardModel: DoctorInfoCardModel? = null,
    val nearDoctorInfoCardModel: List<DoctorInfoCardModel>? = null,
    val menuModel: List<MenuModel>? = null
)