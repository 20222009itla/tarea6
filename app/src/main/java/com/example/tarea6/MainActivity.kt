package com.example.tarea6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.tarea6.ui.navigation.Screen
import com.example.tarea6.ui.screens.AboutScreen
import com.example.tarea6.ui.screens.GenderScreen
import com.example.tarea6.ui.screens.HomeScreen
import com.example.tarea6.ui.screens.PokemonScreen
import com.example.tarea6.ui.screens.RandomUserScreen
import com.example.tarea6.ui.screens.ToolsMenuScreen
import com.example.tarea6.ui.screens.UniversitiesScreen
import com.example.tarea6.ui.screens.WeatherScreen
import com.example.tarea6.ui.screens.WordPressScreen
import com.example.tarea6.ui.theme.Tarea6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tarea6Theme {
                MainApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    // Bottom Bar contains only "Inicio" and "Acerca de"
    val bottomBarScreens = listOf(
        Screen.Home,
        Screen.About
    )

    val showBackButton = currentScreen != Screen.Home && currentScreen != Screen.About

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = currentScreen.title,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(
                            onClick = {
                                currentScreen = when (currentScreen) {
                                    is Screen.ToolsMenu -> Screen.Home
                                    else -> Screen.ToolsMenu
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Volver"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            ) {
                bottomBarScreens.forEach { screen ->
                    val selected = currentScreen == screen || (screen == Screen.Home && currentScreen != Screen.About)
                    NavigationBarItem(
                        selected = selected,
                        onClick = { currentScreen = screen },
                        label = {
                            Text(
                                text = screen.title,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                is Screen.Home -> HomeScreen(onNavigateTo = { currentScreen = it })
                is Screen.ToolsMenu -> ToolsMenuScreen(onNavigateTo = { currentScreen = it })
                is Screen.About -> AboutScreen()
                is Screen.Gender -> GenderScreen()
                is Screen.RandomUser -> RandomUserScreen()
                is Screen.Universities -> UniversitiesScreen()
                is Screen.Weather -> WeatherScreen()
                is Screen.Pokemon -> PokemonScreen()
                is Screen.WordPress -> WordPressScreen()
            }
        }
    }
}
