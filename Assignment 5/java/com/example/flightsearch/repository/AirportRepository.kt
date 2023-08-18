/*
*Assignment 5: Data Persistence
*
* AirportRepository.kt
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
import androidx.room.Database
import com.example.flightsearch.models.Airport
import com.example.flightsearch.roomdb.DatabaseClient

class AirportRepository(private val context: Context) {
    fun getAll() : LiveData<List<Airport>>{
        return DatabaseClient(context).build().airportDao().getAll()
    }

    fun getDest(aita_code: String) : List<Airport>{
        return DatabaseClient(context).build().airportDao().getDest(aita_code)
    }

    fun getDestinationsByAirportCode(airportCode: String): LiveData<List<Airport>> {
        return DatabaseClient(context).build().airportDao().getDestinationsByAirportCode(airportCode)
    }





}