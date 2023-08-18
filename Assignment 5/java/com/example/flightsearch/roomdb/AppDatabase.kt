/*
*Assignment 5: Data Persistence
*
* AppDatabase.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightsearch.models.Airport
import com.example.flightsearch.models.Favorite

@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
    abstract fun favoriteDao(): FavoriteDao
}