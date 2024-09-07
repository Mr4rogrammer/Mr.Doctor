/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.ui.composable.card

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class DoctorColorModel(
    var name: Color = Color.White,
    var backgroundColor: Color = Color(0xFF4894FE),
    var type: Color = Color(0xFFCBE1FF),
    var icon: Color = Color.White,
    var date: Color = Color.White,
    var time: Color = Color.White,
)