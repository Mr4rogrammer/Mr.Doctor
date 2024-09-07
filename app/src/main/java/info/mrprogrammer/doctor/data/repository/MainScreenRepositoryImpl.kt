/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.data.repository

import androidx.compose.ui.graphics.Color
import info.mrprogrammer.doctor.R
import info.mrprogrammer.doctor.domain.repository.MainScreenRepository
import info.mrprogrammer.doctor.ui.composable.bottombar.BottomBarModel
import info.mrprogrammer.doctor.ui.composable.card.DoctorColorModel
import info.mrprogrammer.doctor.ui.composable.card.DoctorInfoCardModel
import info.mrprogrammer.doctor.ui.composable.menu.MenuModel

class MainScreenRepositoryImpl : MainScreenRepository {
    // They value can be from API too.
    // We should not use .png or .jpeg in live build. For sample project i am using .png
    override suspend fun getListOfMenus(): List<BottomBarModel> {
        return listOf(
            BottomBarModel(R.drawable.home, "Home"),
            BottomBarModel(R.drawable.calendar, "Schedule"),
            BottomBarModel(R.drawable.message, "Message"),
            BottomBarModel(R.drawable.profile, "Profile")
        )
    }

    override suspend fun getUpComingEvent(): DoctorInfoCardModel {
        return DoctorInfoCardModel(
            image = R.drawable.doctor_one,
            name = "Dr. Imran Syahir",
            type = "General Doctor",
            date = "Sunday, 12 June",
            timing = "11:00 - 12:00 AM",
            colorModel = DoctorColorModel()
        )
    }

    override suspend fun getNearByDoctor(): List<DoctorInfoCardModel> {
        val nearByDoctorTheme = DoctorColorModel().apply {
            time = Color(0xFF4894FE)
            type = Color(0xFF8696BB)
            name = Color.Black
            date = Color(0xFFFEB052)
            backgroundColor = Color.White
            icon = Color.Black
        }
        return listOf(
            DoctorInfoCardModel(
                image = R.drawable.doctor_one,
                name = "Dr. Imran Syahir",
                type = "General Doctor",
                date = "Sunday, 12 June",
                timing = "11:00 - 12:00 AM",
                colorModel = nearByDoctorTheme
            ),
            DoctorInfoCardModel(
                image = R.drawable.doctor_two,
                name = "Dr. Joseph Brostito",
                type = "Dental Specialist",
                date = "Sunday, 17 June",
                timing = "10:00 - 12:00 AM",
                colorModel = nearByDoctorTheme
            ),
            DoctorInfoCardModel(
                image = R.drawable.doctor_three,
                name = "Dr. Kamalesh",
                type = "Dental Specialist",
                date = "Sunday, 25 June",
                timing = "9:00 - 11:00 AM",
                colorModel = nearByDoctorTheme
            )
        )
    }

    override suspend fun getMenuModel(): List<MenuModel> {
        return listOf(
            MenuModel(R.drawable.covid, "Covid"),
            MenuModel(R.drawable.profile_add, "Doctor"),
            MenuModel(R.drawable.medicine, "Medicine"),
            MenuModel(R.drawable.hospital, "Hospital"),
        )
    }
}