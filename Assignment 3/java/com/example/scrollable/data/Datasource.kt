/*
*Assignment 3: Building a scrollable list
*
* Datasource
*
* Zoe Gerst
* gerstz@oregonstate.edu
* CS 492
* Oregon State University
*
* works cited: https://developer.android.com/codelabs/basic-android-kotlin-compose-training-add-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-training-add-scrollable-list#1
*/
package com.example.scrollable.data

import com.example.affirmations.R
import com.example.scrollable.model.Affirmation


class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.assignment_num, 3, R.string.name, 1),
            Affirmation(R.string.depart, 161, R.string.name1, 400),
            Affirmation(R.string.depart, 162, R.string.name2, 200),
            Affirmation(R.string.depart, 225, R.string.name3, 400),
            Affirmation(R.string.depart, 261, R.string.name4, 500),
            Affirmation(R.string.depart, 271, R.string.name5, 100),
            Affirmation(R.string.depart, 290, R.string.name6, 600),
            Affirmation(R.string.depart, 325, R.string.name7, 100),
            Affirmation(R.string.depart, 340, R.string.name8, 100),
            Affirmation(R.string.depart, 344, R.string.name9, 200),
            Affirmation(R.string.depart, 361, R.string.name10, 100),
            Affirmation(R.string.depart, 362, R.string.name11, 200),
            Affirmation(R.string.depart, 467, R.string.name12, 300)
        )
    }
}
