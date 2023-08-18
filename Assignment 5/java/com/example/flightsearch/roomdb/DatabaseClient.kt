/*
*Assignment 5: Data Persistence
*
* DatabaseClient.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.roomdb

import android.content.Context
import androidx.room.Room

class DatabaseClient(private val context: Context) {
    fun build(): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "my_db"
        ).allowMainThreadQueries().createFromAsset("flight_search.db").build()
    }
}