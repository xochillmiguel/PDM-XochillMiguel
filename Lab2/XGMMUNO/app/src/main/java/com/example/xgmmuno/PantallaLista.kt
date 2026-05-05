package com.example.xgmmuno

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.xgmmuno.ui.theme.AzulClaro
import com.example.xgmmuno.ui.theme.AzulSuave
import com.example.xgmmuno.ui.theme.FondoPastel
import com.example.xgmmuno.ui.theme.VerdeSuave

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