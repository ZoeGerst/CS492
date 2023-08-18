/*
*Assignment 5: Data Persistence
*
* Airport.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Airport(@PrimaryKey val id: Int,
                   @ColumnInfo(name = "iata_code")
                   val iataCode: String,
                   val name: String, val passengers: Int)
