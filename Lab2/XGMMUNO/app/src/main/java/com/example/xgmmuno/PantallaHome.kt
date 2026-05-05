package com.example.xgmmuno

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xgmmuno.ui.theme.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.xgmmuno.ui.theme.XGMMUNOTheme
@Composable
fun PantallaHome(onIrALista: () -> Unit, onIrASensor: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPastel)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Labo 03", color = AzulSuave, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = onIrALista,
            colors = ButtonDefaults.buttonColors(containerColor = AzulClaro)
        ) {
            Text("Ver Lista de Nombres :)")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = onIrASensor,
            colors = ButtonDefaults.buttonColors(containerColor = VerdeSuave)
        ) {
            Text("Probar Sensores :0 ", color = AzulSuave)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaHomePreview() {
    XGMMUNOTheme {
        PantallaHome(
            onIrALista = {},
            onIrASensor = {}
        )
    }
}