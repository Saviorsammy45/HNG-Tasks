package com.example.infoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.infoapp.model.User

//Contains the methods used for accessing the database

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)



    @Delete
    suspend fun deleteUser(user: User)



    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>

}