package com.example.meinhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meinhub.ui.theme.ButtonColor
import com.example.meinhub.ui.theme.MeInHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeInHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenterAlignedTopAppBarExample()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarExample() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Me in Hub",
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {navController.navigate("MainScreen")}
                    )

                    ) },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        ComposeNavigation(navController, innerPadding)
    }
}

@Composable
fun ComposeNavigation(navController: NavHostController,innerPadding: PaddingValues) {

    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){
            MainScreenContent(navController, innerPadding = innerPadding)
        }
        composable("Books"){
            BookScreenContent(navController, innerPadding = innerPadding)
        }
        composable("Footballers"){
            FootballerScreenContent(navController, innerPadding = innerPadding)
        }
        composable("Cars"){
            CarScreenContent(navController, innerPadding = innerPadding)
        }
    }
}

@Composable
fun MainScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "About application",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
        }
        Row(modifier = Modifier.padding(8.dp)) {
            val aboutText =
                "This app was created to show my books, my favourite footballers and cars, that I like." +
                        " See more about me by clicking buttons below"
            Text(
                text = aboutText, color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Light
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
                        onClick = { navHostController.navigate("Books") },
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
                        onClick = { navHostController.navigate("Footballers") },
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
                        onClick = { navHostController.navigate("Cars")},
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

@Composable
fun BookScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
    ) {
        Row {
            Text(
                text = "English 4 IT", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.english4it_book),
                contentDescription = "Book photo"
            )
        }
    }
}


@Composable
fun FootballerScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
    ) {
        Row {
            Text(
                text = "Leo Messi", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.messi_photo),
                contentDescription = "Leo Messi photo"
            )
        }
    }
}

@Composable
fun CarScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
    ) {
        Row {
            Text(
                text = "VW Golf", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.golf),
                contentDescription = "Car photo"
            )
        }
    }
}

