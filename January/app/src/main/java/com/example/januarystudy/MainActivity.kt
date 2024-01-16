package com.example.januarystudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.example.januarystudy.ui.theme.JanuaryStudyTheme
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JanuaryStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    GreetingCardView()
                }
            }
        }
    }
}

@Composable
fun GreetingCardView(order : Int){
    Card (
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            )
    {
        Row(
            Modifier
                .fillMaxWidth()
                .height(200.dp)

        ) {

            GlideImage(
                imageModel = null,
                modifier = Modifier.aspectRatio(0.8f),
                previewPlaceholder = R.drawable.ic_launcher_foreground
            )

            Column {
                Text(text = "Hello Compose World")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Today hardCording Okay?")
            }
        }
    }
}

@Composable
fun GreetingLazyColumn(){
    LazyColumn(){
        items(30){
            GreetingCardView(order = it)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JanuaryStudyTheme {
//        Greeting("Android")
        GreetingLazyColumn()
    }
}