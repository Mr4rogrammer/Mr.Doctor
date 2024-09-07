/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.ui.composable.card

import androidx.compose.runtime.Immutable

@Immutable
data class DoctorInfoCardModel(
    val image: Int,
    val name: String,
    val type: String,
    val date: String,
    val timing: String,
    val colorModel: DoctorColorModel
)