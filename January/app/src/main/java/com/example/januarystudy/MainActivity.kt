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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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

    // remember 복습
    // 상태(value) 저장하기 위해 필요한것.
    // mutableStateOf (값) : 값 저장하기 위한 형태?
    // remember : 값 저장할 수 있게 만드는 명령어
    // 둘이 잘 혼합해서 사용하면 된다.
    // tip 사용하려면 expanded.value로 써야하는데 이거 귀찮으면
    // 생성할때 by 형태로 선언하면 쉽게 value 안붙여도 됨.
    val expanded = remember { mutableStateOf(false) }
    val elevationSize = if (expanded.value) 10.dp else 50.dp
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = elevationSize,
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

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JanuaryStudyTheme {
//        Greeting("Android")
//        GreetingLazyColumn()
//        GreetingMutable("hello")
//        OnboardingScreen()

        var shouldShowOnboarding by remember { mutableStateOf(true) }

        if (shouldShowOnboarding) {
            // 말 들어보니 클릭 이벤트 콜백을 하위 -> 상위로 받을 수 있게 매개 변수로 넣어주는것 같다.
            // 이걸 상태 호이스팅이라고 함.
            // 자식 Composable을 호출부(자식얘를 호출하는 곳)으로 끌어 올리는 것.

            // 그러면 값을 어떻게 끌어올리냐?
            // value : T 값
            // onValueChanged: (T) -> Unit : 값이 바뀌거나 들어왔을 때, 값을 변경하도록 요청하는 함수.

            // EX)
            // onContinueClicked: () -> Unit, 클릭되었을때. shouldShowOnboarding 값이 바뀌도록.
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greeting("Android")
        }
    }
}