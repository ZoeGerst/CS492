/*
*Assignment 3: Building a scrollable list
*
* Affirmation/Course
*
* I used the exercise I did for the "Add a scrollable list" code lab,
* and some of the names stayed the same
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
* works cited: https://developer.android.com/codelabs/basic-android-kotlin-compose-training-add-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-training-add-scrollable-list#1
*/

package com.example.scrollable.model

import androidx.annotation.StringRes


data class Affirmation(@StringRes val stringResourceId: Int,
                       val courseNum: Int,
                       val courseName: Int,
                       val capacity: Int)
