package com.example.lab4.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab4.data.dao.TaskDao
import com.example.lab4.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}