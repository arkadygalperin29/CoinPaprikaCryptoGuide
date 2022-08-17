package space.arkady.coinpaprikacryptoguide.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import space.arkady.coinpaprikacryptoguide.common.Resource
import space.arkady.coinpaprikacryptoguide.data.remote.dto.toCoinDetail
import space.arkady.coinpaprikacryptoguide.domain.model.CoinDetail
import space.arkady.coinpaprikacryptoguide.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected Error occured"))
        } catch (e: IOException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }


}