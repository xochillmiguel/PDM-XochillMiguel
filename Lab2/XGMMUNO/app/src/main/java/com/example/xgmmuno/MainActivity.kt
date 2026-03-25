package com.example.xgmmuno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.xgmmuno.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XGMMUNOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaRegistros(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun PantallaRegistros(modifier: Modifier = Modifier) {

    var entradaNombre by remember { mutableStateOf("") }
    val registroNombres = remember { mutableStateListOf<String>() }
    var hayError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoPastel)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bienvenido al registro de nombres",
            color = AzulSuave,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "escribe un nombre porfita:",
            color = AzulClaro,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )

        TextField(
            value = entradaNombre,
            onValueChange = { entradaNombre = it },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = VerdeSuave,
                unfocusedContainerColor = VerdeSuave
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )

        Button(
            onClick = {
                val soloLetras = entradaNombre.matches(
                    Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")
                )

                if (entradaNombre.isBlank() || !soloLetras) {
                    hayError = true
                } else {
                    registroNombres.add(entradaNombre)
                    entradaNombre = ""
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulClaro),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("agregar")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "lo que llevamos: ",
                color = AzulSuave,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { registroNombres.clear() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = AzulClaro)
            ) {
                Text("Limpiar")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 12.dp)
                .background(VerdeSuave)
                .border(2.dp, AzulSuave)
                .padding(10.dp)
        ) {
            itemsIndexed(registroNombres) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = (index + 1).toString())
                }
            }
        }

        if (registroNombres.isNotEmpty()) {
            Text(
                text = "ya quedooo ;)",
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }

    if (hayError) {
        AlertDialog(
            onDismissRequest = { hayError = false },
            confirmButton = {
                Button(
                    onClick = { hayError = false }
                ) {Text("Aceptar")}
            },
            title = {Text("Error")},
            text = {
                Text("ummm eso no parece nombre, solo se permiten letras")
            }
        )
    }
}