package com.example.profilescreenassnmnt.ui.domain.data

sealed interface UserActions {
    data object onBackClick: UserActions
    data object onSupportClick : UserActions
    data object onEditProfileClick : UserActions
    data object onCREDGarageClick: UserActions
    data object onCreditScoreClick: UserActions
    data object onLifeTimeCashbackClick: UserActions
    data object onBankBalanceClick: UserActions
    data object onCashbackBalanceClick: UserActions
    data object onCoinsClick: UserActions
    data object onReferralClick: UserActions
    data object onTransactionClick: UserActions
}