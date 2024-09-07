package info.mrprogrammer.doctor.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import info.mrprogrammer.doctor.R
import info.mrprogrammer.doctor.ui.composable.bottombar.BottomBar
import info.mrprogrammer.doctor.ui.composable.card.DoctorInfoCard
import info.mrprogrammer.doctor.ui.composable.header.Header
import info.mrprogrammer.doctor.ui.composable.menu.Menu
import info.mrprogrammer.doctor.ui.composable.search.SearchView
import info.mrprogrammer.doctor.ui.theme.MrDoctorTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainScreenViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            MrDoctorTheme {
                val mainScreenUiModel by viewModel.mainScreenUiModel.collectAsState()
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White), bottomBar = {
                    BottomBar(barMenu = mainScreenUiModel?.bottomBarModel, 0) {

                    }
                }) { innerPadding ->
                    Column(
                        Modifier
                            .background(Color.White)
                            .padding(innerPadding)
                            .fillMaxSize()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    ) {
                        Header(name = "Krishna Kumar", profileIcon = R.drawable.krishna)
                        mainScreenUiModel?.doctorInfoCardModel?.let {
                            Spacer(modifier = Modifier.height(20.dp))
                            DoctorInfoCard(doctorInfoCardModel = it, it.colorModel)
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        SearchView(hint = "Search doctor or health issue")
                        mainScreenUiModel?.menuModel?.let {
                            Spacer(modifier = Modifier.height(20.dp))
                            Menu(menuModel = it)
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Near Doctor",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        )
                        mainScreenUiModel?.nearDoctorInfoCardModel?.let { listOfNearDoctor ->
                            Spacer(modifier = Modifier.height(20.dp))
                            LazyColumn {
                                items(listOfNearDoctor.size) {
                                    val currentModel = listOfNearDoctor.get(it)
                                    DoctorInfoCard(doctorInfoCardModel = currentModel, currentModel.colorModel, hideRightArrow = true)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
