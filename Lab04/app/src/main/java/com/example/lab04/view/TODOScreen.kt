package com.example.lab04.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab04.data.model.Task
import com.example.lab04.viewModel.GeneralViewModel

@Composable
fun TODOScreen(viewModel: GeneralViewModel) {
    val tasks = viewModel.tasks.collectAsState()
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Digita una nota")

        TextField(value = title, onValueChange = { title = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
        TextField(value = desc, onValueChange = { desc = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())

        Button(
            onClick = {
                if (title.isNotBlank()) {
                    viewModel.addTask(Task(id = tasks.value.size + 1, title = title, description = desc))
                    title = ""
                    desc = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("añadir nota")
        }

        Text("lista de notas")

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(tasks.value) { task ->
                Card(task.id, task.title, task.description, task.endDate, task.isCompleted)
            }
        }
    }
}