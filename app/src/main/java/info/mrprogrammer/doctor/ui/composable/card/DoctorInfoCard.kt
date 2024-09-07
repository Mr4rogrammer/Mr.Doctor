/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.ui.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.mrprogrammer.doctor.R

@Composable
fun DoctorInfoCard(
    doctorInfoCardModel: DoctorInfoCardModel,
    doctorColorModel: DoctorColorModel = DoctorColorModel(),
    hideRightArrow: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(doctorColorModel.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = painterResource(id = doctorInfoCardModel.image),
                        contentDescription = "Doctor Image",
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(start = 7.dp)
                    ) {
                        Text(
                            text = doctorInfoCardModel.name,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 18.sp,
                                color = doctorColorModel.name
                            )
                        )
                        Text(
                            text = doctorInfoCardModel.type,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 14.sp,
                                color = doctorColorModel.type
                            )
                        )
                    }
                }

                if (hideRightArrow.not()) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        tint = doctorColorModel.icon,
                        contentDescription = "Right Arrow",
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
            }

            Row(modifier = Modifier.padding(top = 20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DateAndTimeInfo(
                        R.drawable.calendar,
                        doctorInfoCardModel.date,
                        doctorColorModel.date
                    )
                    DateAndTimeInfo(
                        R.drawable.clock,
                        doctorInfoCardModel.timing,
                        doctorColorModel.time
                    )
                }
            }
        }
    }
}

@Composable
fun DateAndTimeInfo(icon: Int, content: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Date",
            tint = color,
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.labelSmall.copy(
                color = color,
                fontSize = 12.sp
            )
        )
    }
}

