package com.example.composedemo.mainScreen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import com.example.composedemo.R
import com.example.composedemo.mainScreen.ui.model.MainScreenModel
import com.example.composedemo.mainScreen.ui.model.MainScreenUIState
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreenView (mainScreenViewModel: MainScreenViewModel, navigationController: NavHostController) {

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val uiState by produceState<MainScreenUIState>(
        initialValue = MainScreenUIState.Loading,
        key1 = lifecycle,
        key2 = mainScreenViewModel
    ){
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED){
            mainScreenViewModel.uiState.collect{ value = it}
        }
    }

    when(uiState){
        is MainScreenUIState.Error -> { }
        MainScreenUIState.Loading -> { CircularProgressIndicator() }
        is MainScreenUIState.Success -> { MyScaffold((uiState as MainScreenUIState.Success).config) }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold(
    mainScreenViewModel1: List<MainScreenModel>
){
    Scaffold(
        topBar = { MyTopBar(mainScreenViewModel1) },
        content = { MyBody(mainScreenViewModel1) },
        bottomBar = { MyBottomRow(mainScreenViewModel1) }
    )
}

@Composable
fun MyBody(mainScreenViewModel1: List<MainScreenModel>) {
    if (mainScreenViewModel1.first().id == "glay"){
        Box(modifier = Modifier
            .background(getColor(mainScreenViewModel1.first().background_color))
            .fillMaxSize() ) {
        }
    }else{
        Box(modifier = Modifier
            .fillMaxSize() ) {
            Image(painter = painterResource(R.drawable.top_background), contentDescription = "", modifier = Modifier.fillMaxSize())
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition")
@Composable
fun MyTopBar(mainScreenViewModel1: List<MainScreenModel>){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(250.dp),
                drawerContainerColor = getColor(mainScreenViewModel1.first().drawer_background_color)
                    .copy(alpha = 0.9f)) {
                val colors: NavigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
                    unselectedTextColor = getColor(mainScreenViewModel1.first().drawer_text_color),
                    unselectedContainerColor = Color.Transparent
                )
                NavigationDrawerItem(
                    colors = colors,
                    label = { Text(text = "バージョン") },
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "アプリ設定") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "ご利用規約") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "個人情報の取扱に関して") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "特定商取引法に基づく表記") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "よくある質問") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "ライセンス") },
                    colors = colors,
                    selected = false,
                    onClick = { /*TODO*/ })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
                NavigationDrawerItem(label = { Text(text = "ログイン") },
                    colors = colors,
                    selected = false,
                    onClick = {  })
                HorizontalDivider(thickness = 0.2.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp, 10.dp, 0.dp))
            }
        },gesturesEnabled = true
    ) {
        CenterAlignedTopAppBar(
            title = {
                if (mainScreenViewModel1.first().id == "glay"){
                    Image(painter = painterResource(R.drawable.ic_logo_white), contentDescription = "Side menu")
                }else{
                    Image(painter = painterResource(R.drawable.logo_splash), contentDescription = "Side menu")
                } },
            navigationIcon = { IconButton(onClick = { scope.launch {
                drawerState.apply {
                    if (isClosed) open() else close()
                }
            }  }) {
                Icon(painter = painterResource(R.drawable.ic_action_menu), contentDescription = "Menu", modifier = Modifier.size(40.dp))
            }},
            colors = TopAppBarColors(containerColor = getColor(mainScreenViewModel1.first().top_bar_background_color),
                scrolledContainerColor = getColor(mainScreenViewModel1.first().top_bar_scroll_color),
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )
    }
}

@Composable
fun MyBottomRow(
    mainScreenViewModel1: List<MainScreenModel>
){
    val buttonDef = ButtonDefaults.buttonColors(getColor(mainScreenViewModel1.first().button_icon_color))
    val buttonMod = Modifier.background(getColor(mainScreenViewModel1.first().button_color))
        .size(110.dp, 95.dp)
    Row(
        modifier = Modifier.background(getColor(mainScreenViewModel1.first().drawer_background_color))
            .wrapContentSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center) {
        if(mainScreenViewModel1.first().id == "glay"){
            MyButtonLive(buttonDef, buttonMod)
            MyButtonMusic(buttonDef, buttonMod)
            MyButtonVideo(buttonDef, buttonMod)
            MyButtonARCamera(buttonDef, buttonMod)
            MyButtonNews(buttonDef, buttonMod)
            MyButtonIcon(buttonDef, buttonMod)
            MyButtonTicket(buttonDef, buttonMod)
        }else{
            MyButtonPhoto(buttonDef, buttonMod)
            MyButtonBook(buttonDef, buttonMod)
            MyButtonHappySwing(buttonDef, buttonMod)
            MyButtonSchedule(buttonDef, buttonMod)
            MyButtonProfile(buttonDef, buttonMod)
            MyButtonDisco(buttonDef, buttonMod)
            MyButtonSNS(buttonDef, buttonMod)
        }
    }
}

@Composable
fun MyButtonLive(
    buttonColors: ButtonColors,
    modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "LIVE",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyLiveIcon()
        }
    }
}

@Composable
fun MyButtonMusic(buttonColors: ButtonColors,
                  modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "Music",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyMusicIcon()
        }
    }
}

@Composable
fun MyButtonVideo(buttonColors: ButtonColors,
                  modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "Movie",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyMovieIcon()
        }
    }
}

@Composable
fun MyButtonARCamera(buttonColors: ButtonColors,
                     modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "AR CAMERA",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 9.sp)
            CustomSpacerIcon(2)
            MyARCameraIcon()
        }
    }
}

@Composable
fun MyButtonNews(buttonColors: ButtonColors,
                 modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "AR CAMERA",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 9.sp)
            CustomSpacerIcon(2)
            MyNewsIcon()
        }
    }
}

@Composable
fun MyButtonIcon(buttonColors: ButtonColors,
                 modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "ICON",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconIcon()
        }
    }
}

@Composable
fun MyButtonTicket(buttonColors: ButtonColors,
                   modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "TICKET",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconTicket()
        }
    }
}

@Composable
fun MyButtonPhoto(buttonColors: ButtonColors,
                  modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "PHOTO",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconPhoto()
        }
    }
}

@Composable
fun MyButtonBook(buttonColors: ButtonColors,
                 modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "BOOK",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconBook()
        }
    }
}

@Composable
fun MyButtonHappySwing(buttonColors: ButtonColors,
                       modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "HAPPYSWING",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 9.sp)
            CustomSpacerIcon(2)
            MyIconHappySwing()
        }
    }
}

@Composable
fun MyButtonSchedule(buttonColors: ButtonColors,
                     modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "SCHEDULE",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconSchedule()
        }
    }
}

@Composable
fun MyButtonProfile(buttonColors: ButtonColors,
                    modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "PROFILE",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconProfile()
        }
    }
}

@Composable
fun MyButtonDisco(buttonColors: ButtonColors,
                  modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "DISCOGRAPHY",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 9.sp)
            CustomSpacerIcon(2)
            MyIconDisco()
        }
    }
}

@Composable
fun MyButtonSNS(buttonColors: ButtonColors,
                modifier: Modifier
){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = buttonColors){
        Column {
            Text(text = "SNS",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White,
                fontSize = 10.sp)
            CustomSpacerIcon(2)
            MyIconSNS()
        }
    }
}


@Composable
fun MyLiveIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_live), contentDescription = "live icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyMovieIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_video), contentDescription = "movie icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyMusicIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_music), contentDescription = "music icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}


@Composable
fun MyARCameraIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_arcamera), contentDescription = "ar camera icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyNewsIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_news), contentDescription = "news icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconIcon(){
    Image(painter = painterResource(id = R.drawable.top_icon_application), contentDescription = "icon icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconTicket(){
    Image(painter = painterResource(id = R.drawable.top_icon_ticket), contentDescription = "ticket icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconPhoto(){
    Image(painter = painterResource(id = R.drawable.top_icon_photo), contentDescription = "photo icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconBook(){
    Image(painter = painterResource(id = R.drawable.top_icon_book), contentDescription = "book icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconHappySwing(){
    Image(painter = painterResource(id = R.drawable.top_icon_happyswing), contentDescription = "Happyswing icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconSchedule(){
    Image(painter = painterResource(id = R.drawable.top_icon_schedule), contentDescription = "schedule icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconProfile(){
    Image(painter = painterResource(id = R.drawable.top_icon_profile), contentDescription = "profile icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconDisco(){
    Image(painter = painterResource(id = R.drawable.top_icon_disco), contentDescription = "discography icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun MyIconSNS(){
    Image(painter = painterResource(id = R.drawable.top_icon_links), contentDescription = "links icon",
        modifier = Modifier
            .size(54.dp, 54.dp))
}

@Composable
fun CustomSpacerIcon(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

fun getColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor("#$colorString"))
}

