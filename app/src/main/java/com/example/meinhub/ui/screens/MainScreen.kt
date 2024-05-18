package com.example.meinhub.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.meinhub.ui.theme.ButtonColor


@Composable
fun MainScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Row (modifier = Modifier.padding(12.dp)) {
            Text(
                text = "About application",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }
        Row (modifier = Modifier.padding(8.dp)) {
            val aboutText =
                "This app was created to show my books, my favourite footballers and cars, that I like." +
                        " See more about me by clicking buttons below"
            Text(
                text = aboutText, color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Light,
                textAlign = TextAlign.Justify
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(top = 50.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { navHostController.navigate("BooksPreview") },
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
                    ) {
                        Column {
                            Row(horizontalArrangement = Arrangement.Center) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(80.dp),
                                    painter = painterResource(id = R.drawable.book),
                                    contentDescription = "Book photo"
                                )
                            }
                            Row {
                                Text(
                                    text = "My books",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Black, fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                                )
                            }
                        }

                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { navHostController.navigate("FootballersPreview") },
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
                    ) {
                        Column {
                            Row(horizontalArrangement = Arrangement.Center) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(80.dp),
                                    painter = painterResource(id = R.drawable.footballer),
                                    contentDescription = "Footballer photo"
                                )
                            }
                            Row {
                                Text(
                                    text = "My favourite footballers",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Black, fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                                )
                            }
                        }

                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { navHostController.navigate("CarsPreview")},
                        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
                    ) {
                        Column {
                            Row(horizontalArrangement = Arrangement.Center) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(80.dp),
                                    painter = painterResource(id = R.drawable.car),
                                    contentDescription = "Car photo"
                                )
                            }
                            Row {
                                Text(
                                    text = "Cars, that I like",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    color = Color.Black, fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}