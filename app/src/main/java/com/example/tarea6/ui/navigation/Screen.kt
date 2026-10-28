package com.example.tarea6.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Wc
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Inicio", Icons.Default.Home)
    object ToolsMenu : Screen("tools_menu", "Herramientas Disponibles", Icons.Default.Build)
    object About : Screen("about", "Acerca de", Icons.Default.Info)
    object Gender : Screen("gender", "Predecir Género", Icons.Default.Wc)
    object RandomUser : Screen("random_user", "Persona Aleatoria", Icons.Default.Person)
    object Universities : Screen("universities", "Universidades por País", Icons.Default.School)
    object Weather : Screen("weather", "Clima en RD", Icons.Default.Cloud)
    object Pokemon : Screen("pokemon", "Información Pokémon", Icons.Default.CatchingPokemon)
    object WordPress : Screen("wordpress", "Noticias WordPress", Icons.Default.Newspaper)
}
