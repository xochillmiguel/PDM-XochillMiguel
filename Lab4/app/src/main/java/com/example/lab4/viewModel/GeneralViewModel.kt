package com.example.lab4.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab4.InitDatabase
import com.example.lab4.data.model.Task
import kotlinx.coroutines.launch

class GeneralViewModel : ViewModel() {
    private val taskDao = InitDatabase.database.taskDao()

    val tasks = taskDao.getAllTasks()

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            taskDao.insertTask(
                Task(
                title = title,
                description = description)
            )
        }
    }

    fun toggleTask(task: Task) {
        viewModelScope.launch {
            taskDao.updateTask(
                task.copy(isCompleted = !task.isCompleted))
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }
}