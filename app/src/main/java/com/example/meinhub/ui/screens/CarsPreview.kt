package com.example.meinhub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meinhub.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CarPreviewScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {

    val cars = listOf(
        R.drawable.audi_rs6_photo,
        R.drawable.golf,
        R.drawable.bmw_m5,
        R.drawable.opel_astra
    )

    val carsNames = listOf(
        "Audi RS6",
        "VW Golf",
        "BMW M5",
        "Opel Astra"
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())

    ) {
        FlowRow(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {

            for(x in 0..3){
                Column (modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 32.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = carsNames[x],
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navHostController.navigate("Cars/$x") },
                        painter = painterResource(cars[x]),
                        contentDescription = "Car photo",
                    )
                }
            }
        }
    }
}