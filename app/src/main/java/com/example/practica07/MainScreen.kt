package com.example.practica07

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    // Obtenemos el contexto actual.
    // Lo necesitamos para poder mostrar los mensajes Toast.
    val context = LocalContext.current

    // Estado que controla si el menú desplegable
    // está abierto o cerrado.
    var menuExpandido by remember {
        mutableStateOf(false)
    }


    // Scaffold proporciona la estructura principal de la pantalla.
    Scaffold(

        // Barra superior de nuestra aplicación.
        topBar = {

            TopAppBar(

                // Título que aparece en la barra.
                title = {
                    Text("Mi Aplicación")
                },

                // Colores de nuestra TopAppBar.
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =
                        MaterialTheme.colorScheme.onPrimaryContainer
                ),

                // Icono ubicado en la parte izquierda.
                navigationIcon = {

                    IconButton(
                        onClick = {

                            Toast.makeText(
                                context,
                                "Clic en Navegación",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                },

                // Iconos ubicados en la parte derecha del TopAppBar.
                actions = {

                    // Acción directa: Favoritos.
                    IconButton(
                        onClick = {

                            Toast.makeText(
                                context,
                                "Añadido a Favoritos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorito"
                        )
                    }


                    // Botón de los tres puntos.
                    // Al presionarlo cambia el estado del menú a true.
                    IconButton(
                        onClick = {
                            menuExpandido = true
                        }
                    ) {

                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Más opciones"
                        )
                    }


                    // Menú desplegable.
                    DropdownMenu(

                        // Determina si el menú está visible.
                        expanded = menuExpandido,

                        // Si presionamos fuera del menú,
                        // se vuelve a cerrar.
                        onDismissRequest = {
                            menuExpandido = false
                        }
                    ) {

                        // Primera opción del menú.
                        DropdownMenuItem(

                            text = {
                                Text("Configuración")
                            },

                            onClick = {

                                // Cerramos el menú.
                                menuExpandido = false

                                // Mostramos mensaje.
                                Toast.makeText(
                                    context,
                                    "Configuración seleccionada",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )


                        // Segunda opción del menú.
                        DropdownMenuItem(

                            text = {
                                Text("Acerca de")
                            },

                            onClick = {

                                // Cerramos el menú.
                                menuExpandido = false

                                // Mostramos mensaje.
                                Toast.makeText(
                                    context,
                                    "Acerca de seleccionada",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                }
            )
        },



        // Reto de la practica: Scaffold permite agregar un FloatingActionButton (FAB).
        // Agregamos un botón flotante con el icono "+".
        floatingActionButton = {

            FloatingActionButton(

                // RETO:
                // Cuando el usuario presiona el FAB,
                // mostramos el Toast solicitado por la práctica.
                onClick = {

                    Toast.makeText(
                        context,
                        "Elemento agregado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {

                // RETO: Icons.Default.Add muestra el símbolo "+"
                // dentro del botón flotante.
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar elemento"
                )
            }
        }


    ) { innerPadding ->


        // Contenido principal de nuestra pantalla.
        Column(

            modifier = Modifier
                .fillMaxSize()

                // Evita que nuestro contenido quede debajo
                // del TopAppBar.
                .padding(innerPadding)

                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Bienvenido a Material Design",
                fontSize = 22.sp,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Explora las opciones de la barra superior.",
                fontSize = 16.sp
            )
        }
    }
}