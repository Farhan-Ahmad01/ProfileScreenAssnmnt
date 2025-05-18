package com.example.profilescreenassnmnt.ui.domain.data

data class UserData(
    val userName: String,
    val profileUrl: String? = null,
    val joinData: String?,
    val creditScore: Int? = 0,
    val cashback: Int? = 0,
    val bankBalance: Int? = 0,
    val cashBankBalance: Int? = 0,
    val coins: Int? = 0
)
