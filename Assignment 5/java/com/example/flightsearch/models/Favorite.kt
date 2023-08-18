/*
*Assignment 5: Data Persistence
*
* Favorite.kt
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
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(indices = [Index(value = ["departure_code", "destination_code"], unique = true)])
data class Favorite(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo(name = "departure_code") val departureCode: String, @ColumnInfo("destination_code") val destinationCode: String)
