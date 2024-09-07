/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.ui.composable.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.mrprogrammer.doctor.ui.theme.blue
import info.mrprogrammer.doctor.ui.theme.lightBlue

@Composable
fun Header(name: String, profileIcon: Int) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(text = "Hello,", style = MaterialTheme.typography.labelSmall.copy(color = lightBlue, fontSize = 17.sp))
            Text(text = name, style = MaterialTheme.typography.bodyLarge.copy(color = blue, fontSize = 20.sp))
        }

        Image(
            painter = painterResource(id = profileIcon),
            contentDescription = "",
            modifier = Modifier.width(40.dp).height(40.dp).clip(RoundedCornerShape(50.dp))
        )
    }
}