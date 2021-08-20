package com.example.infoapp.repository

import androidx.lifecycle.LiveData
import com.example.infoapp.data.UserDao
import com.example.infoapp.model.User

class UserRepository(private val userDao: UserDao) {

    fun readAllData() : LiveData<List<User>> = userDao.readAllData()


    suspend fun addUser(user: User){
        userDao.addUser(user)
    }



    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }


}