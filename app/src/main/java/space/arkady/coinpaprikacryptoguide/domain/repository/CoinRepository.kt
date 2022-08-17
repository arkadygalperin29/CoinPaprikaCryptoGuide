package space.arkady.coinpaprikacryptoguide.domain.repository

import space.arkady.coinpaprikacryptoguide.data.remote.dto.CoinDetailDto
import space.arkady.coinpaprikacryptoguide.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}