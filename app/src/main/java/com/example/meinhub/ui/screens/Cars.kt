package com.example.meinhub.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meinhub.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarScreenContent(navHostController: NavHostController, innerPadding: PaddingValues, id: Int) {

    var carIndex by remember { mutableIntStateOf(id) }
    val scope = rememberCoroutineScope()

    val audi = listOf(
        R.drawable.audi_rs6_photo,
        R.drawable.audi_rs6_photo1,
        R.drawable.audi_rs6_photo2
    )

    val golf = listOf(
        R.drawable.golf,
        R.drawable.golf_2
    )

    val bmw = listOf(
        R.drawable.bmw_m5,
        R.drawable.bmw_m5_1
    )

    val opel = listOf(
        R.drawable.opel_astra
    )

    val cars = listOf(
        audi,
        golf,
        bmw,
        opel
    )
    val states = listOf(
        rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ){3},
        rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ){2},
        rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ){2},
        rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f
        ){1},
    )

    val carsDescriptions = listOf(
        "Audi RS6 is a sport car ideal for persons, who want to feel sport driving and to persons " + "" +
                "who has a family and need more space for yourself and load in trunk",
        "Volkswagen Golf is a nice and reliable car, delightful with its style. " +
                "It is the most popular car model in Europe",
        "BMW M5 is beautiful and comfortable car, ideal for persons, who like rear drive",
        "Opel Astra is a cheap car, but comfortable. This car is one of the most popular cars on the world"
    )

    val carsNames = listOf(
        "Audi RS6",
        "WV Golf",
        "BMW M5",
        "Opel Astra"
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)

    ) {
        Row (modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth()){
                if(carIndex != 0) {
                    IconButton(modifier = Modifier.align(Alignment.CenterStart),
                        onClick = {
                            scope.launch {
                                carIndex -= 1
                            }
                        }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
                if(carIndex != cars.size - 1) {
                    IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                        onClick = {
                            scope.launch {
                                carIndex += 1
                            }
                        }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Localized description"
                        )
                    }
                }
            }
        }
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)){
            Row (modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = carsNames[carIndex],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
            Row {
                Box(modifier = Modifier.fillMaxSize()) {
                    HorizontalPager(state = states[carIndex],

                        ) { index ->
                        Image(
                            painter = painterResource(cars[carIndex][index]),
                            contentDescription = "Car photo"
                        )

                    }
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Photo " + (states[carIndex].currentPage + 1) + "/" + states[carIndex].pageCount,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Row (modifier = Modifier.padding(20.dp)) {
                Text(
                    text = carsDescriptions[carIndex],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}