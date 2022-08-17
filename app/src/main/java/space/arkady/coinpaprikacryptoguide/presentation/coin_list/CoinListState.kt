package space.arkady.coinpaprikacryptoguide.presentation.coin_list

import space.arkady.coinpaprikacryptoguide.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
