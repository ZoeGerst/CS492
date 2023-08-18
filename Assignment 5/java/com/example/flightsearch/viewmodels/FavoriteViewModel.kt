/*
*Assignment 5: Data Persistence
*
* FavoriteViewModel.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.viewmodels

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.flightsearch.models.Favorite
import com.example.flightsearch.repository.FavoriteRepository

class FavoriteViewModel: ViewModel() {

    fun insert(context: Context, favorite: Favorite){
        FavoriteRepository(context).insert(favorite)
    }

    fun getAll(context: Context): LiveData<List<Favorite>> {
        return FavoriteRepository(context).getAll()
    }

    fun remove(context: Context, favorite: Favorite){

        FavoriteRepository(context).remove(favorite)
    }
}