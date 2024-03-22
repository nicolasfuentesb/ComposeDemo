package com.example.composedemo.mainScreen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class OptionsEntity (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("option1") var option1: String,
    @SerializedName("option2")var option2: String,
    @SerializedName("option3")var option3: String,
    @SerializedName("option4")var option4: String
)