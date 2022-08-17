package space.arkady.coinpaprikacryptoguide.presentation.coin_detail

import space.arkady.coinpaprikacryptoguide.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)
