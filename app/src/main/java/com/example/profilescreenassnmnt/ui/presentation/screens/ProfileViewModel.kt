package com.example.profilescreenassnmnt.ui.presentation.screens

import androidx.lifecycle.ViewModel
import com.example.profilescreenassnmnt.ui.domain.data.UserActions
import com.example.profilescreenassnmnt.ui.domain.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel(): ViewModel() {

    private val _state = MutableStateFlow( UserData(
        userName = "Andaz Kumar",
        profileUrl = "",
        joinData = "member since Dec, 2020",
        creditScore = 757,
        cashback = 3,
        bankBalance = 50000,
        cashBankBalance = 0,
        coins = 2646583
    ))
    val state = _state.asStateFlow()

    fun onAction(action: UserActions) {
        when (action) {
            UserActions.onBackClick -> {}
            UserActions.onBankBalanceClick -> {}
            UserActions.onCREDGarageClick -> {}
            UserActions.onCashbackBalanceClick -> {}
            UserActions.onCoinsClick -> {}
            UserActions.onCreditScoreClick -> {}
            UserActions.onEditProfileClick -> {}
            UserActions.onLifeTimeCashbackClick -> {}
            UserActions.onReferralClick -> {}
            UserActions.onSupportClick -> {}
            UserActions.onTransactionClick -> {}
        }
    }

}