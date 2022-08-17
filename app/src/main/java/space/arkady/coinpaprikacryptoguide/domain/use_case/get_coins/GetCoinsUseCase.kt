package space.arkady.coinpaprikacryptoguide.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import space.arkady.coinpaprikacryptoguide.common.Resource
import space.arkady.coinpaprikacryptoguide.data.remote.dto.toCoin
import space.arkady.coinpaprikacryptoguide.domain.model.Coin
import space.arkady.coinpaprikacryptoguide.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected Error occured"))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Coin>>(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }


}