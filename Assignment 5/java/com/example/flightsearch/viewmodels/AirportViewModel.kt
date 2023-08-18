/*
*Assignment 5: Data Persistence
*
* AirportViewModel.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flightsearch.models.Airport
import com.example.flightsearch.repository.AirportRepository

class AirportViewModel: ViewModel() {

    val liveDataDestinations: MutableLiveData<List<Airport>> = MutableLiveData()
    fun getAll(context: Context) : LiveData<List<Airport>>{
        return AirportRepository(context).getAll()
    }

    fun getDest(context: Context, iata_code: String){
        liveDataDestinations.postValue(AirportRepository(context).getDest(iata_code))
    }


    fun getLiveDataDestinations() : LiveData<List<Airport>>{
        return liveDataDestinations
    }

    fun getDestinationsByAirportCode(context: Context, airportCode: String): LiveData<List<Airport>> {
        return AirportRepository(context).getDestinationsByAirportCode(airportCode)
    }






}