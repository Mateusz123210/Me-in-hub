package com.example.meinhub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.Button
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookPreviewScreenContent(navHostController: NavHostController, innerPadding: PaddingValues) {

    val books = listOf(
        R.drawable.english4it_book,
        R.drawable.physics_book,
        R.drawable.investing_book,
        R.drawable.learning_tutorial_book
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
                    .padding(top = 32.dp)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = booksTitles[x],
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { navHostController.navigate("Books/$x") },
                        painter = painterResource(books[x]),
                        contentDescription = "Book photo",
                    )
                }
            }
        }
    }
}