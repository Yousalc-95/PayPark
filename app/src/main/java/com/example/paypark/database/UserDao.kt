package com.example.paypark.database

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.paypark.model.User

@Dao
interface UserDao {

    @Insert
    fun insertAll(vararg users: User)

    @Update
    fun updateUsers (vararg  users:User)

    @Delete
    fun deleteUser (user: User)

    @Query("DELETE FROM Users WHERE email LIKE :email")
    fun deleteUserByEmail (email: String)

    @Query("SELECT * FROM Users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM Users  WHERE email LIKE :email")
    fun getUserByEmail(email: String) : User?

    @Query("SELECT * FROM Users  WHERE email LIKE :email AND password LIKE :password")
    fun getUserByLoginInfo(email: String , password: String): User?
}