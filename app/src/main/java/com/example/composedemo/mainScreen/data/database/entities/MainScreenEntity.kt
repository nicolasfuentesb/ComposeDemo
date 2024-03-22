package com.example.composedemo.mainScreen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MainScreenEntity(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: String,
    @SerializedName("background_color")var background_color: String,
    @SerializedName("drawer_background_color")var drawer_background_color: String,
    @SerializedName("drawer_text_color")var drawer_text_color: String,
    @SerializedName("top_bar_background_color")var top_bar_background_color: String,
    @SerializedName("top_bar_scroll_color")var top_bar_scroll_color: String,
    @SerializedName("button_color")var button_color: String,
    @SerializedName("button_icon_color")var button_icon_color: String
)
