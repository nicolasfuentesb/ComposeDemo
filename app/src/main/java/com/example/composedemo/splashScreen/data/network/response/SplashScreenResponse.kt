package com.example.composedemo.splashScreen.data.network.response

import com.google.gson.annotations.SerializedName

class SplashScreenResponse(@SerializedName("id")val id:String,
                           @SerializedName("background_color")val background_color:String,
                           @SerializedName("drawer_background_color")val drawer_background_color:String,
                           @SerializedName("drawer_text_color")val drawer_text_color:String,
                           @SerializedName("top_bar_background_color")val top_bar_background_color:String,
                           @SerializedName("top_bar_scroll_color")val top_bar_scroll_color:String,
                           @SerializedName("button_color")val button_color:String,
                           @SerializedName("button_icon_color")val button_icon_color:String,
                           @SerializedName("menu_options")val menu_options:List<String>)
