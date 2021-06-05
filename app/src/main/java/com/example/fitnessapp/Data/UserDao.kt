package com.example.fitnessapp.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Query("SELECT * FROM NUTRITIONAL_DBTABLE ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}