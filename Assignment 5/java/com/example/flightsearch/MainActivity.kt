/*
*Assignment 5: Data Persistence
*
* MainActivity.kt
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
*/

package com.example.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.flightsearch.models.Airport
import com.example.flightsearch.models.Favorite
import com.example.flightsearch.ui.theme.FlightSearchTheme
import com.example.flightsearch.viewmodels.AirportViewModel
import com.example.flightsearch.viewmodels.FavoriteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
    @Composable
    fun Greeting() {
        val list = remember {
            mutableStateListOf<Airport>()
        }
        val destinationList = remember {
            mutableStateListOf<Airport>()
        }
        val storeDest = remember {
            mutableStateOf("")
        }
        val favoriteList = remember {
            mutableStateListOf<Favorite>()
        }
        val viewModel = ViewModelProvider(this)[AirportViewModel::class.java]
        viewModel.getAll(this).observe(this) {
            list.clear()
            list.addAll(it)
            //list.addAll(airports.map {airport -> airport.name})
        }
        val favViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]



        viewModel.getLiveDataDestinations().observe(this) {
            destinationList.clear()
            destinationList.addAll(it)
        }
        favViewModel.getAll(this).observe(this){
            favoriteList.clear()
            favoriteList.addAll(it)
        }
        //val airportsLiveData = viewModel.getAll(this)
        var searchText by remember { mutableStateOf("") }
        //list.add("Item 1")
        Column(modifier = Modifier.padding(Dp(8f))) {

            Text("Flight Search", modifier = Modifier.padding(Dp(8f)), color = Color.Blue, fontSize = TextUnit(30f, TextUnitType.Sp))
            BasicTextField(
                value = searchText, onValueChange = { newText ->
                    searchText = newText

                    val filteredAirports = list.filter { airport ->
                        airport.name.contains(searchText, ignoreCase = true) ||
                                airport.iataCode.contains(searchText, ignoreCase = true)
                    }
                    list.clear()

                    //if (filteredAirports != null) {
                    list.addAll(filteredAirports)
                    // }

                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dp(8f))
            ) {
                items(
                    if (searchText.isEmpty()) favoriteList
                    else if (destinationList.isNotEmpty()) destinationList
                    else list
                ) { item ->
                    when {

                        item is Favorite -> {
                            Text("Favorite Routes")
                            val departureAirport = list.find { it.iataCode == storeDest.value }
                            val destinationAirport = list.find { it.iataCode == item.destinationCode }
                            Card(modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)) {

                                Column() {

                                    Text(text = "Depart")

                                    Row() {
                                        Text(text = "${departureAirport?.iataCode ?: "Unknown"}", modifier = Modifier.padding(2.dp), fontWeight = FontWeight.Bold)
                                        Text(text = "${departureAirport?.name ?: "Unknown"}")
                                    }

                                    Text(text = "Arrive")

                                    Row {
                                        Text(text = "${destinationAirport?.iataCode ?: "Unknown"}", modifier = Modifier.padding(2.dp), fontWeight = FontWeight.Bold)
                                        Text(text = "${destinationAirport?.name ?: "Unknown"}")
                                    }
                                }
                            }
                        }

                        destinationList.isNotEmpty() && item is Airport -> {
                            val departureAirport = list.find { it.iataCode == storeDest.value }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp)
                            ) {
                                Column() {

                                    Text(text = "Depart")

                                    Row {
                                        Text(text = "${departureAirport?.iataCode ?: "Unknown"}", modifier = Modifier.padding(2.dp), fontWeight = FontWeight.Bold)
                                        Text(text = "${departureAirport?.name ?: "Unknown"}")
                                    }

                                    Text(text = "Arrive")

                                    Row {
                                        Text(item.iataCode, modifier = Modifier.padding(2.dp), fontWeight = FontWeight.Bold)
                                        Text(item.name)
                                    }
                                }
                                Column() {


                                    RadioButton(selected = item.iataCode == storeDest.value,
                                        onClick = {


                                            if (!favoriteList.any { it.destinationCode == item.iataCode }) {
                                                favViewModel.insert(this@MainActivity, Favorite(0,storeDest.value, item.iataCode))

                                            }
                                            else{
                                                favViewModel.remove(this@MainActivity, Favorite(0,storeDest.value, item.iataCode))
                                            }
                                        })
                                }
                            }

                        }

                        item is Airport -> {
                            Text(item.name, modifier = Modifier.selectable(true, onClick = {

                                viewModel.getDest(this@MainActivity, iata_code = item.iataCode)
                                storeDest.value = item.iataCode
                                viewModel.getDestinationsByAirportCode(
                                    this@MainActivity,
                                    item.iataCode
                                )
                                    .observe(this@MainActivity) { destinations ->
                                        destinationList.clear()
                                        destinationList.addAll(destinations)
                                    }
                            }))
                        }

                    }
                }
            }
        }
    }







    @Preview(showBackground = true)
    @Composable
    fun ShowUI(){
        FlightSearchTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Greeting()
            }

        }
    }}


