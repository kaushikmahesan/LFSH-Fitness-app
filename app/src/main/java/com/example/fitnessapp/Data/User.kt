package com.example.fitnessapp.Data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "NUTRITIONAL_DBTABLE")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val foodName: String,
    val Calories: Int,
    val Protein: Int,
    val Carbohydrates: Int,
    val fats: Int
): Parcelable