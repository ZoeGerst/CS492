/*
*Assignment 5: Data Persistence
*
* AirportDao.kt
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
import androidx.room.Query
import com.example.flightsearch.models.Airport

@Dao
interface AirportDao {
    @Query("Select * from airport")
    fun getAll() : LiveData<List<Airport>>

    @Query("Select * from airport where iata_code <> :iataCode")
    fun getDest(iataCode: String): List<Airport>

    @Query("SELECT * FROM airport WHERE iata_code != :airportCode")
    fun getDestinationsByAirportCode(airportCode: String): LiveData<List<Airport>>

}