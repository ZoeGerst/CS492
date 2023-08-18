/*
*Assignment 5: Data Persistence
*
* FavoriteDao.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flightsearch.models.Airport
import com.example.flightsearch.models.Favorite

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorite: Favorite)

    @Query("Select * from favorite")
    fun getAll(): LiveData<List<Favorite>>

    @Query("Delete from favorite where departure_code = :departureCode and destination_code = :destinationCode")
    fun remove(departureCode: String, destinationCode: String)
}