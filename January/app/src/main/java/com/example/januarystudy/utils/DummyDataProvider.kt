package com.example.januarystudy.utils

data class RamdomUser(
    val name : String = "hello ComposeUser ",
    val description : String = "오늘도 빡코딩하시나요?",
    val profileURL : String = "https://randomuser.me/api/portraits/men/96.jpg"
)

object DummyDataProvider {

    val userList = List<RamdomUser>(100) {
        RamdomUser()
    }

}