/*
*Assignment 5: Data Persistence
*
* FavoriteRepository.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.flightsearch.models.Favorite
import com.example.flightsearch.roomdb.DatabaseClient

class FavoriteRepository(private val context: Context) {

    fun insert(favorite: Favorite) {
        DatabaseClient(context).build().favoriteDao().insert(favorite)
    }

    fun getAll(): LiveData<List<Favorite>> {
        return DatabaseClient(context).build().favoriteDao().getAll()

    }

    fun remove(favorite: Favorite){

        DatabaseClient(context).build().favoriteDao().remove(favorite.departureCode, favorite.destinationCode)
    }
}