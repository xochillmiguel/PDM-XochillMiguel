package com.example.lab04.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

@Composable
fun Card(
    id: Int,
    title: String,
    description: String,
    endDate: Date,
    isCompleted: Boolean
) {
    var checkedState by remember { mutableStateOf(isCompleted) }

    val fechaOriginal = endDate.toString()
    val fechaLimpia = fechaOriginal.replace("CST 2026", "")

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "#$id", fontSize = 14.sp)
                }
                Text(text = description, fontSize = 14.sp)
                Text(text = "Fecha: $fechaLimpia", fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )
        }
    }
}