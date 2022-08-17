package space.arkady.coinpaprikacryptoguide.di


import space.arkady.coinpaprikacryptoguide.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.arkady.coinpaprikacryptoguide.common.Constants
import space.arkady.coinpaprikacryptoguide.data.remote.CoinPaprikaApi
import space.arkady.coinpaprikacryptoguide.data.repository.CoinRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryImpl(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}