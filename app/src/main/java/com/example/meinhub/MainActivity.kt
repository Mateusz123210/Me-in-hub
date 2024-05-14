package com.example.meinhub


import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
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
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.meinhub.ui.theme.ButtonColor
import com.example.meinhub.ui.theme.MeInHubTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeInHubTheme {

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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
        ModalDrawerSheet (modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column (modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                Divider()
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    text = "Books",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Divider()
            }
            NavigationDrawerItem(
                label = { Text(
                    text = "English 4 IT",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = {
                    scope.launch{
                        drawerState.apply {
                            if (!isClosed) close()
                        }
                    }
//                    navController.navigate("Books") //change to parameterized navigation
                }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Fizyka Zakres rozszerzony",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Inwestowanie w złoto i srebro",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Włam się do mózgu",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            Column (modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                Divider()
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    text = "Footballers",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Divider()
            }
            NavigationDrawerItem(
                label = { Text(
                    text = "Leo Messi",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Cristiano Ronaldo",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Robert Lewandowski",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Jakub Błaszczykowski",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            Column (modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                Divider()
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    text = "Cars",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
                Divider()
            }
            NavigationDrawerItem(
                label = { Text(
                    text = "Audi RS6",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "VW Golf",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "BMW M5",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
            NavigationDrawerItem(
                label = { Text(
                    text = "Opel Astra",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )},
                selected = false,
                onClick = { /*TODO*/ }
            )
        }
    }) {

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
                        IconButton(onClick = {
                           scope.launch{
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }

                           }


                        }) {
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
    val scope = rememberCoroutineScope()
    val books = listOf(
        R.drawable.english4it_book,
        R.drawable.physics_book,
        R.drawable.investing_book,
        R.drawable.learning_tutorial_book
    )

    val booksDescriptions = listOf(
        "This book is, in my opinion, suitable for persons, who want to learn " +
                "english vocabulary used in IT",
        "This book is, in my opinion perfect for persons, who want to prepare " +
                "for Physics A-levels exam",
        "This book is good for persons, who wants to learn basics and advanced aspects of investing",
        "By reading this book you will found out, how to learn effectively"
    )

    val booksTitles = listOf(
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
                if(pagerState.currentPage != 0) {
                    IconButton(modifier = Modifier.align(Alignment.CenterStart),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
                if(pagerState.currentPage != pagerState.pageCount - 1) {
                    IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
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
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState,
                key = {books[it]}
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
                            text = booksTitles[index],
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
                            painter = painterResource(books[index]),
                            contentDescription = "Book photo",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Row(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = booksDescriptions[index],
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FootballerScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){4}
    val scope = rememberCoroutineScope()
    val footballers = listOf(
        R.drawable.messi_photo,
        R.drawable.ronaldo_photo,
        R.drawable.lewandowski_photo,
        R.drawable.blaszczykowski_photo
    )
    var showMore by remember { mutableStateOf(false) }

    val footballersDescriptions = listOf(
        "Leo Messi is one of the best footballers on the World. " +
                "He is known from his goals and assists. The most goals he has scored for FC Barcelona",
        "Cristiano Ronaldo is one of the best footballers on the world. " +
                "He can strike very well from distance and using his head",
        "Robert Lewandowski is typical attacker, one of the best on the world. " +
        "Currently he plays for the FC Barcelona club",
        "Jakub Błaszczykowski is one of the best polish footballers. " +
        "He scored many goals for Polish National Team. He is known from, that " +
        "he has difficult childhood, but he never gave up"
    )

    val footballersNames = listOf(
        "Leo Messi",
        "Cristiano Ronaldo",
        "Robert Lewandowski",
        "Jakub Błaszczykowski"
    )
    if(!showMore){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)

        ) {
            Row (modifier = Modifier.padding(12.dp)) {
                Box(modifier = Modifier.fillMaxWidth()){
                    if(pagerState.currentPage != 0) {
                        IconButton(modifier = Modifier.align(Alignment.CenterStart),
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                    if(pagerState.currentPage != pagerState.pageCount - 1) {
                        IconButton(modifier = Modifier.align(Alignment.CenterEnd),
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
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
            Box(modifier = Modifier.fillMaxSize()) {
                HorizontalPager(state = pagerState,
                    key = {footballers[it]}
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
                                text = footballersNames[index],
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
                                    .heightIn(0.dp, 520.dp),  //responsiveness while commented
                                painter = painterResource(footballers[index]),
                                contentDescription = "Footballer photo",
                                contentScale = ContentScale.Crop //responsiveness while commented
                            )
                        }
                        Row(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = footballersDescriptions[index],
                                color = MaterialTheme.colorScheme.secondary,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Justify
                            )
                        }

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { showMore = true },
                            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
                        ) {

                            Text(
                                text = "Show more ...",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = Color.Black, fontSize = 24.sp,
                                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }else{
        FootballerAudioAndVideo(innerPadding, onClick = { showMore = false }, pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FootballerAudioAndVideo(innerPadding: PaddingValues, onClick: () -> Unit, pagerState: PagerState) {

    val filmsTitles = listOf("Messi best goals", "Ronaldo best goals")
    val filmsUris = listOf("android.resource://com.example.meinhub/raw/messi_best_solo_goals",
        "android.resource://com.example.meinhub/raw/ronaldo_best_goals")
    val animationsTitles = listOf("Messi picks up the ball", "Ronaldo picks up the ball")
    val animations = listOf(R.drawable.messi_animation, R.drawable.ronaldo_animation)
    val context = LocalContext.current
    val mediaPlayers = listOf(MediaPlayer.create(context, R.raw.lewandowski_interview),
        MediaPlayer.create(context, R.raw.blaszczykowski_interview))
    val audioTitles = listOf("Interview with Robert Lewandowski",
        "Interview with Jakub Błaszczykowski")

    val audioDescriptions = listOf("Robert Lewandowski talks about yourself and current Barcelona form in spanish",
        "Interview before match with Germany in 2023 year")

    var audioPlayed by remember { mutableStateOf(false) }

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP) {
                if (pagerState.currentPage >= 2){
                    mediaPlayers[pagerState.currentPage - 2].pause()
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column ( modifier = Modifier
        .fillMaxWidth()
        .padding(innerPadding)
        ) {
        if(pagerState.currentPage  < 2){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = filmsTitles[pagerState.currentPage],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp
                    )
            ) {
                val videoUri =
                    Uri.parse(filmsUris[pagerState.currentPage])
                VideoPlayer(videoUri = videoUri)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = animationsTitles[pagerState.currentPage],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))

            ) {
                GifImage(animation = animations[pagerState.currentPage])
            }

        }else{
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = audioTitles[pagerState.currentPage - 2],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(MaterialTheme.colorScheme.primaryContainer),
                horizontalArrangement = Arrangement.Center){
                Column(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)){
                    Button(
                        onClick = {mediaPlayers[pagerState.currentPage - 2].start()},
                        modifier = Modifier
                            .clip(RectangleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        content = {
                            Image(modifier = Modifier.heightIn(max = 80.dp), painter = painterResource(id = R.drawable.play_icon), contentDescription = null)

                        }
                    )
                }
                Column(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
                    Spacer(modifier = Modifier.width(32.dp))
                }
                Column (modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
                    Button(
                        onClick = {mediaPlayers[pagerState.currentPage - 2].pause()},
                        modifier = Modifier
                            .clip(RectangleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        content = {
                            Image(modifier = Modifier.heightIn(max = 80.dp), painter = painterResource(id = R.drawable.pause_icon), contentDescription = null)

                        }
                    )
                }

            }
            Row(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = audioDescriptions[pagerState.currentPage - 2],
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = ({
                    if (pagerState.currentPage >= 2){
                        mediaPlayers[pagerState.currentPage - 2].pause()
                    }
                    onClick()
                }),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
            ) {

                Text(
                    text = "Show less ...",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black, fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun VideoPlayer(
    videoUri: Uri
) {

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(videoUri)

                val mediaController = MediaController(context)
                mediaController.setAnchorView(this)

                setMediaController(mediaController)

                setOnPreparedListener {
                    start()
                }
                setClipToOutline(true)
            }
        }
    )
}

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    animation: Int
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            add(ImageDecoderDecoder.Factory())
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = animation).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {

    var carIndex by remember { mutableIntStateOf(0) }
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

