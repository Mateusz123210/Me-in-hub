package com.example.meinhub.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
fun BookScreenContent(navHostController: NavHostController, innerPadding: PaddingValues, id: Int) {
    val pagerState = rememberPagerState(
        initialPage = id,
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