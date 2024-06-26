package com.example.weatherapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.navigation.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun WeatherSplashScreen(navController: NavController){

    val scale = remember {
        // Animatable is used to create a dynamic animation, its a value holder
        androidx.compose.animation.core.Animatable(0f)
    }


    // It's a mechanism to execute a block of code asynchronously
    // after the composable function has been composed and subsequent recompositions
    LaunchedEffect(
        // When set to true, the effect will be launched only once when the composable is initially composed.
        //
        key1 = true,
    // will be executed asynchronously within a coroutine launched by LaunchedEffect
        block = {
        // it will scale the element down to 90% of its original size
        scale.animateTo(targetValue = 0.9f,
            // animation specification for the scaling animation
            animationSpec = tween(
                durationMillis = 800,
                // control the speed and smoothness of the animation
                easing = {
                    // creates an animation that bounces slightly past the target value before settling on it.
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }))
            // after 2 sec delay this will navigate to the main screen
            delay(2000L)
            navController.navigate(route = WeatherScreens.MainScreen.name)
    })

    
    
    Surface(modifier = Modifier
        .padding(15.dp)
        .size(330.dp)
        .scale(scale.value),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 2.dp, Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.partlycloudy),
                    contentDescription = "Partly cloudy icon ",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(95.dp))


                Text(text = "Find The Sun?",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 6.dp))


                
        }
    }
}