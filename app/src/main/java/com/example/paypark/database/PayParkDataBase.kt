package com.example.paypark.database

import android.content.Context
import android.content.res.Resources
import androidx.room.*
import com.example.paypark.R
import com.example.paypark.model.User
import com.example.paypark.utils.DateConverter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.security.AccessControlContext

@Database(entities = arrayOf(User::class) , version = 1)
@TypeConverters(*arrayOf(DateConverter::class))

abstract class PayParkDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{

        @Volatile
        private var INSTANCE: PayParkDataBase? = null

        @InternalCoroutinesApi
        fun  getDataBase(context: Context) : PayParkDataBase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext ,
                    PayParkDataBase::class.java,
                    R.string.database_name.toString()
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}

