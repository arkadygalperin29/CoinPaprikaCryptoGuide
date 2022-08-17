package space.arkady.coinpaprikacryptoguide.data.repository

import space.arkady.coinpaprikacryptoguide.data.remote.CoinPaprikaApi
import space.arkady.coinpaprikacryptoguide.data.remote.dto.CoinDetailDto
import space.arkady.coinpaprikacryptoguide.data.remote.dto.CoinDto
import space.arkady.coinpaprikacryptoguide.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}