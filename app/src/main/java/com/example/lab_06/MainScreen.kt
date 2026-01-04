package com.example.lab_06

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    // Estado para contar clics en el FAB
    var clickCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) },
        floatingActionButton = { CustomFAB { clickCount++ } },
        content = { padding ->
            CustomContent(padding, clickCount)
        }
    )
}

// Barra superior personalizada
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* TODO: Menú lateral */ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menú")
            }
        },
        title = { Text(text = "Mi Aplicación") },
        actions = {
            IconButton(onClick = { /* TODO: Búsqueda */ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Buscar"
                )
            }
            IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Perfil"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

// Barra inferior personalizada con distribución uniforme
@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate(Screen.Build.route) }) {
                Icon(Icons.Filled.Build, contentDescription = "Construir")
            }
            IconButton(onClick = { navController.navigate(Screen.Menu.route) }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú")
            }
            IconButton(onClick = { navController.navigate(Screen.Favorite.route) }) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favoritos")
            }
            IconButton(onClick = { navController.navigate(Screen.Delete.route) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
            }
        }
    }
}

// Botón flotante personalizado con contador
@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {
        Text(
            fontSize = 24.sp,
            text = "+"
        )
    }
}

// Contenido principal que muestra el contador
@Composable
fun CustomContent(padding: PaddingValues, clickCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contenido Principal",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Has presionado el botón + $clickCount veces",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}