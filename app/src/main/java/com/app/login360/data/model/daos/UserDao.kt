package com.app.login360.data.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.login360.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * from user LIMIT 1")
    fun getSavedUser(): User

    @Insert
    fun insertAll(vararg users: User)
}