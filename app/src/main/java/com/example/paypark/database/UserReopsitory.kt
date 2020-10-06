package com.example.paypark.database

import androidx.lifecycle.LiveData
import com.example.paypark.model.User

class UserReopsitory (

    private  val userDao: UserDao
)
    {
        val allUsers: LiveData<List<User>> = userDao.getAllUsers()

        suspend fun insertAll(user: User){
            userDao.insertAll(user)
        }

        suspend fun updateUsers(user: User){
            userDao.updateUsers(user)
        }


    }