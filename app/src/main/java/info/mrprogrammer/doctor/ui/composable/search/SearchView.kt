/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.ui.composable.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.mrprogrammer.doctor.R

@Composable
fun SearchView(hint: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(7.dp))
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var text by remember { mutableStateOf("") }
        Icon(
            painter = painterResource(id = R.drawable.search_normal),
            contentDescription = "",
            modifier = Modifier
                .width(35.dp)
                .height(35.dp).padding(start = 16.dp),
            tint = Color(0xFF8696BB)
        )
        BasicTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp),
            textStyle = MaterialTheme.typography.titleSmall.copy(
                fontSize = 15.sp,
                color = Color(0xFF8696BB), textAlign = TextAlign.Start
            ),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = hint,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontSize = 15.sp,
                            color = Color(0xFF8696BB),
                            letterSpacing = 1.sp
                        )
                    )
                }
                innerTextField()
            })

    }
}

val backgroundColor = Color(0xFFFAFAFA)