package com.d3if0059.ngurah.todolistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.d3if0059.ngurah.todolistapp.daos.TodoDao
import com.d3if0059.ngurah.todolistapp.daos.UserDao
import com.d3if0059.ngurah.todolistapp.entities.TodoModel
import com.d3if0059.ngurah.todolistapp.entities.UserModel

@Database(entities = [TodoModel::class, UserModel::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao() : TodoDao
    abstract fun userDao() : UserDao

    companion object {
        private var db: TodoDatabase? = null
        fun getDB(context: Context) : TodoDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    TodoDatabase::class.java,
                    "todo_db"
                ).build()
                return db!!
            }
            return db!!
        }
    }
}