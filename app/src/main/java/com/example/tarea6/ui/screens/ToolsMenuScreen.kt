package com.example.tarea6.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Wc
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tarea6.ui.navigation.Screen

@Composable
fun ToolsMenuScreen(onNavigateTo: (Screen) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Menú de Herramientas",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Selecciona la herramienta que deseas utilizar:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            }
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                ToolMenuOptionCard(
                    title = "Predecir Género",
                    description = "Predice si un nombre es masculino o femenino con interfaz temática.",
                    icon = Icons.Default.Wc,
                    iconBgColor = Color(0xFFE91E63),
                    onClick = { onNavigateTo(Screen.Gender) }
                )
                ToolMenuOptionCard(
                    title = "Persona Aleatoria",
                    description = "Genera datos de personas reales: foto, nombre, fecha de nacimiento y edad.",
                    icon = Icons.Default.Person,
                    iconBgColor = Color(0xFF2196F3),
                    onClick = { onNavigateTo(Screen.RandomUser) }
                )
                ToolMenuOptionCard(
                    title = "Universidades por País",
                    description = "Busca universidades de cualquier país en inglés con sus dominios y webs.",
                    icon = Icons.Default.School,
                    iconBgColor = Color(0xFF4CAF50),
                    onClick = { onNavigateTo(Screen.Universities) }
                )
                ToolMenuOptionCard(
                    title = "Clima en RD 🇩🇴",
                    description = "Consulta el pronóstico del clima actual para Santo Domingo, RD.",
                    icon = Icons.Default.Cloud,
                    iconBgColor = Color(0xFFFF9800),
                    onClick = { onNavigateTo(Screen.Weather) }
                )
                ToolMenuOptionCard(
                    title = "Información Pokémon",
                    description = "Obtén datos, habilidades, experiencia y reproduce el grito de tu Pokémon.",
                    icon = Icons.Default.CatchingPokemon,
                    iconBgColor = Color(0xFF9C27B0),
                    onClick = { onNavigateTo(Screen.Pokemon) }
                )
                ToolMenuOptionCard(
                    title = "Noticias WordPress",
                    description = "Últimas 3 noticias publicadas en la web de WordPress con enlace original.",
                    icon = Icons.Default.Newspaper,
                    iconBgColor = Color(0xFF009688),
                    onClick = { onNavigateTo(Screen.WordPress) }
                )
            }
        }
    }
}

@Composable
fun ToolMenuOptionCard(
    title: String,
    description: String,
    icon: ImageVector,
    iconBgColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(iconBgColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = iconBgColor,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}
