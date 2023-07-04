/*
* Assignment 1: Simple Android App in Kotlin
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
* */

package com.example.assignment1simpleandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1simpleandroidapp.ui.theme.Assignment1SimpleAndroidAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1SimpleAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    GreetingText()
                }
            }
        }
    }
}

@Composable
fun GreetingText() {

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color(0xFFFF0000)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val image = painterResource(R.drawable.android_logo)

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(230.dp)
        )
        Text(text = "Zoe Gerst",
            color = Color.Black,
            fontSize = 80.sp,
            //lineHeight = 45.sp,
            textAlign = TextAlign.Center)
        Text(text = "CS 492 Student Extraordinaire",
            color = Color.Black,
            fontSize = 35.sp,
            //lineHeight = 45.sp,
            textAlign = TextAlign.Center,)
    }

    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            val phone = painterResource(id = R.drawable.phone)
            Image(
                painter = phone,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
            )
            Text(
                text = "(626) 999-6980",
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            val insta = painterResource(id = R.drawable.instagram_icon)
            Image(
                painter = insta,
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
            )
            Text(
                text = "@CrazyDoritoQueen",
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            val email = painterResource(id = R.drawable.email)
            Image(
                painter = email,
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
            )
            Text(
                text = "gerstz@oregonstate.edu",
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment1SimpleAndroidAppTheme {

        GreetingText()
    }
}