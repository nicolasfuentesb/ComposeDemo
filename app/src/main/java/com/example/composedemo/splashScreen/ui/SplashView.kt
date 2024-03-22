package com.example.composedemo.splashScreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composedemo.R

@Composable
fun SplashScreenView(splashViewModel: SplashViewModel, navigationController: NavHostController){
    SplashBox()
    splashViewModel.startApp(navigationController)
}

@Preview(showBackground = true )
@Composable
fun SplashBox() {

    Box(Modifier.fillMaxSize()){
        SplashColumn()
    }
}

@Composable
fun SplashColumn(){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        HeaderImage()
        CustomSpacer(size = 30)
        CircularProgressIndicator(color = Color.Green)
    }

}

@Composable
fun HeaderImage(){
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "Header")
}

@Composable
fun CustomSpacer(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}


