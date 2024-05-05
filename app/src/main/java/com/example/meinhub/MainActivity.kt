package com.example.meinhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Me in Hub") },
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
        ScrollContent(innerPadding)
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(innerPadding)) {
        Row (modifier = Modifier.padding(12.dp)) {
            Text(text = "About application", color = MaterialTheme.colorScheme.secondary, fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
        }
        Row (modifier = Modifier.padding(8.dp)) {
            val aboutText = "This app was created to show my books, my favourite footballers and cars, that I like."
            Text(text = aboutText, color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Light)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column (modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { /* doSomething() */}) {
                        Text("My books")
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { /* doSomething() */}) {
                        Text("My favourite footballers")
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = { /* doSomething() */}) {
                        Text("Cars, that I like")
                    }
                }
            }
        }
    }
}

@Composable
fun GolfPage(innerPadding: PaddingValues){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(innerPadding)) {
        Row {
            Text(text = "VW Golf", color = MaterialTheme.colorScheme.secondary, fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.golf),
                contentDescription = "My photo"
            )
        }
    }
}