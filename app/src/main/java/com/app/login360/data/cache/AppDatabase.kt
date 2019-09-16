package com.app.login360.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.login360.data.model.User
import com.app.login360.data.model.daos.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}