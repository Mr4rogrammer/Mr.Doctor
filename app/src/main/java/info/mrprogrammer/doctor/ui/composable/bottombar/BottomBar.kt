/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.ui.composable.bottombar

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.mrprogrammer.doctor.ui.theme.lightBlue

@Composable
fun BottomBar(barMenu: List<BottomBarModel>?, defaultSelectedIndex: Int = 0, selectedMenu: (BottomBarModel) -> Unit) {
    if (barMenu == null || defaultSelectedIndex > barMenu.size) return
    var selectedIndex = remember { mutableIntStateOf(defaultSelectedIndex) }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(barMenu.size) { index ->
            val currentBar = barMenu.get(index)
            val isSelectedIndex = selectedIndex.intValue == index
            val backgroundColor by animateColorAsState(
                targetValue = if (isSelectedIndex) bottomBarSelected else Color.Transparent
            )
            val modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    selectedIndex.value = index
                    selectedMenu.invoke(currentBar)
                }
                .background(backgroundColor)
                .padding(10.dp)

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
                Icon(
                    painter = painterResource(id = currentBar.icon),
                    contentDescription = "",
                    tint = iconAndTextSelectedColor.takeIf { isSelectedIndex } ?: lightBlue)
                if (isSelectedIndex) {
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = currentBar.name,
                        textAlign = TextAlign.Center,
                        color = iconAndTextSelectedColor,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 16.sp)
                    )
                }
            }

        }
    }
}


val bottomBarSelected = Color(0x77C1DEF8)
val iconAndTextSelectedColor = Color(0xFF63B4FF)
