package com.example.januarystudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.example.januarystudy.ui.theme.JanuaryStudyTheme
import com.example.januarystudy.utils.DummyDataProvider
import com.example.januarystudy.utils.RamdomUser
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JanuaryStudyTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
////                    GreetingLazyColumn()
//                    RandomUserListView(randomUser = DummyDataProvider.userList)
//                }
                DefaultPreview()
            }
        }
    }
}

@Composable
fun GreetingCardView(order : Int){
    Card(
        Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        elevation = 5.dp
    )

    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {

            GlideImage(
                imageModel = null,
                modifier = Modifier
                    .aspectRatio(0.8f)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.DarkGray),
                previewPlaceholder = R.drawable.ic_launcher_foreground,
                circularReveal = CircularReveal(duration = 250),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(text = "Hello Compose World",
                    fontSize = 18.sp
                )
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

@Composable
fun RandomUserListView(randomUser: List<RamdomUser>){
    LazyColumn(){
        items(randomUser){ aRandomUser ->

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                elevation = 10.dp,
                shape = RoundedCornerShape(12.dp)
            ) {

                Row(){
                    Box (modifier = Modifier
                        .size(width = 100.dp, height = 100.dp)
                        .clip(CircleShape))
                }

                Column(
                    modifier = Modifier.padding(10.dp)

                ) {

                }
                Text(text = aRandomUser.name)
            }
        }
    }
}

@Composable
fun GreetingMutable(name : String){
    val expanded = remember {mutableStateOf(false)}
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row() {
            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .clip(CircleShape)
            )
        }

        Column(
            modifier = Modifier.padding(10.dp)

        ) {

        }
        Button(
            onClick = { expanded.value = !expanded.value }
        ) {
            Text(if (expanded.value) name else "show more")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JanuaryStudyTheme {
//        Greeting("Android")
//        GreetingLazyColumn()
        GreetingMutable("hello")
    }
}