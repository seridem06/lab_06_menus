package com.example.lab_06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab_06.ui.theme.MenusEnComposeTheme // Ojo: Verifica el nombre de tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Asegúrate de usar el nombre correcto de tu tema.
            // En tu archivo Theme.kt vi que se llama 'MenusEnComposeTheme',
            // pero aquí usas 'lab_06Theme'. CORRIGE ESTO.
            MenusEnComposeTheme {
                AppNavigation()
            }
        }
    }
}