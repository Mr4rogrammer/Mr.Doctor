/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.domain.repository

import info.mrprogrammer.doctor.ui.composable.bottombar.BottomBarModel
import info.mrprogrammer.doctor.ui.composable.card.DoctorInfoCardModel
import info.mrprogrammer.doctor.ui.composable.menu.MenuModel

interface MainScreenRepository {
    suspend fun getListOfMenus(): List<BottomBarModel>
    suspend fun getUpComingEvent(): DoctorInfoCardModel
    suspend fun getNearByDoctor(): List<DoctorInfoCardModel>
    suspend fun getMenuModel(): List<MenuModel>
}