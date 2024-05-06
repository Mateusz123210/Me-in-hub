package com.example.meinhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){4}
    val Books = listOf(
        R.drawable.english4it_book,
        R.drawable.physics_book,
        R.drawable.investing_book,
        R.drawable.learning_tutorial_book
    )

    val BooksDescriptions = listOf(
        "This book is, in my opinion, suitable for persons, who want to learn " +
                "english vocabulary used in IT",
        "This book is, in my opinion perfect for persons, who want to prepare " +
                "for Physics A-levels exam",
        "This book is good for persons, who wants to learn basics and advanced aspects of investing",
        "By reading this book you will found out, how to learn effectively"
    )

    val BooksTitles = listOf(
        "English 4 IT",
        "Fizyka Zakres rozszerzony",
        "Inwestowanie w złoto i srebro",
        "Włam się do mózgu"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)

    ) {
        Row (modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth()){
                IconButton(modifier = Modifier.align(Alignment.CenterStart),
                    onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }

                IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "Localized description"
                    )
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState,
                key = {Books[it]}
                ) {
                index ->

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = BooksTitles[index],
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(0.dp, 520.dp),
                            painter = painterResource(Books[index]),
                            contentDescription = "Book photo",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = BooksDescriptions[index],
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


    }
}


@Composable
fun FootballerScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
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
        Row (modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth()){
                IconButton(modifier = Modifier.align(Alignment.CenterStart),
                    onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }

                IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "Localized description"
                    )
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
                    text = "VW Golf", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.golf),
                    contentDescription = "Car photo"
                )
            }
            Row (modifier = Modifier.padding(20.dp)) {
                val aboutCarText = "Volkswagen Golf is a nice and reliable car, delightful with its style. " +
                        "It is the most popular car model in Europe"
                Text(
                    text = aboutCarText, color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}

