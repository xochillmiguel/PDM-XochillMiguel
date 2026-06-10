package com.example.lab4.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lab4.viewModel.GeneralViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TODOScreen(viewModel: GeneralViewModel) {
    val tasks by viewModel.tasks.collectAsState(initial = emptyList())
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Agenda", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF669EFF)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFF96C0FF)
            ) {
                Icon(Icons.Default.Add,
                    contentDescription = "Añadir",
                    tint = Color.White)
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tasks) { task ->
                TaskCard(
                    task = task,
                    onCheckedChange = { viewModel.toggleTask(task) },
                    onDelete = { viewModel.deleteTask(task) }
                )
            }
        }

        if (showDialog) {
            CreateTaskDialog(
                onDismiss = { showDialog = false },
                onTaskCreated = { title, desc ->
                    viewModel.addTask(title, desc)
                    showDialog = false
                }
            )
        }
    }
}