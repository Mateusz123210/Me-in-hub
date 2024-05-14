package com.example.meinhub.ui.screens

import android.media.MediaPlayer
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
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
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.meinhub.R
import com.example.meinhub.ui.theme.ButtonColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FootballerScreenContent(navHostController: NavHostController, innerPadding: PaddingValues, id: Int) {
    val pagerState = rememberPagerState(
        initialPage = id,
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
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(tween(4000), RepeatMode.Reverse),
        label = "scale"
    )
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF000000),
        targetValue = MaterialTheme.colorScheme.secondary,
//        targetValue = MaterialTheme.colorScheme.primaryContainer,
        animationSpec = infiniteRepeatable(tween(4000), RepeatMode.Reverse),
        label = "color"
    )

    val footballersDescriptions = listOf(
        "Leo Messi is one of the best footballers on the World. " +
                "He is known from his goals and assists. The most goals he has scored for FC Barcelona",
        "Cristiano Ronaldo is one of the best footballers on the world. " +
                "He can strike very well from distance and using his head",
        "Robert Lewandowski is typical attacker, one of the best on the world. " +
                "Currently he plays for the FC Barcelona club",
        "Jakub Błaszczykowski is one of the best polish footballers. " +
                "He scored many goals for Polish National Team. He is known from, that " +
                "he had difficult childhood, but he never gave up"
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
                                modifier = Modifier.fillMaxWidth()
                                .graphicsLayer {
                                    scaleX = scale
                                    scaleY = scale
                                    transformOrigin = TransformOrigin.Center
                                },
                                textAlign = TextAlign.Center,
                                color = animatedColor, fontSize = 24.sp,
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
    val mediaPlayers = listOf(
        MediaPlayer.create(context, R.raw.lewandowski_interview),
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