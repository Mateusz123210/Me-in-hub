package com.example.meinhub.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


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
                    Column (modifier = Modifier.clickable{
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("BooksPreview")}) {
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
                    }
                    Divider()
                }
                NavigationDrawerItem(
                    label = { Text(
                        text = "English 4 IT",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Books/0")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Fizyka Zakres rozszerzony",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Books/1")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Inwestowanie w złoto i srebro",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Books/2")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Włam się do mózgu",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Books/3")
                    }
                )
                Column (modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                    Divider()
                    Column (modifier = Modifier.clickable{
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("FootballersPreview")}) {
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
                    }
                    Divider()
                }
                NavigationDrawerItem(
                    label = { Text(
                        text = "Leo Messi",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Footballers/0")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Cristiano Ronaldo",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Footballers/1")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Robert Lewandowski",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Footballers/2")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Jakub Błaszczykowski",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Footballers/3")
                    }
                )
                Column (modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
                    Divider()
                    Column (modifier = Modifier.clickable{
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("CarsPreview")}) {
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
                    }
                    Divider()
                }
                NavigationDrawerItem(
                    label = { Text(
                        text = "Audi RS6",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Cars/0")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "VW Golf",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Cars/1")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "BMW M5",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Cars/2")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(
                        text = "Opel Astra",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    },
                    selected = false,
                    onClick = {
                        scope.launch{
                            drawerState.apply {
                                if (!isClosed) close()
                            }
                        }
                        navController.navigate("Cars/3")
                    }
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
