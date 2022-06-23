package com.d3if0059.ngurah.todolistapp.repos

import androidx.lifecycle.LiveData
import com.d3if0059.ngurah.todolistapp.daos.TodoDao
import com.d3if0059.ngurah.todolistapp.entities.TodoModel

class TodoRepository(val todoDao: TodoDao) {

    suspend fun insertTodo(todoModel: TodoModel) : Long{
        return todoDao.insertTodo(todoModel)
    }

    fun getTodoByUserId(userId: Long) = todoDao.getTodosByUserId(userId)

    fun getTodoByStatusUserId(userId: Long, status: Int) =
        todoDao.getTodosByStatusAndUserId(userId, status)
    fun getTODoById(id: Long): LiveData<TodoModel> = todoDao.getTodosById(id)

    fun getTodosByPriorityAndUserId(userId: Long, priority: String) =
        todoDao.getTodosByPriorityAndUserId(userId, priority)

    suspend fun updateTodo(todoModel: TodoModel) = todoDao.updateTodo(todoModel)

    suspend fun deleteTodo(todoModel: TodoModel) = todoDao.deleteTodo(todoModel)
}