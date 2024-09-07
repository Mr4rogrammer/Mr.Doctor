/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.ui.composable.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Menu(menuModel: List<MenuModel>) {
    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        items(menuModel.size) {
            val currentMenu = menuModel.get(it)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .width(72.dp)
                        .height(72.dp)
                        .background(backgroundColor, shape = RoundedCornerShape(50)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = currentMenu.icon),
                        contentDescription = "",
                        tint = Color(0xFF4894FE),
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }

                Text(
                    text = currentMenu.message,
                    modifier = Modifier.padding(top = 5.dp),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color(0xFF8696BB),
                        fontSize = 15.sp
                    )
                )
            }
        }

    }
}

val backgroundColor = Color(0xFFFAFAFA)