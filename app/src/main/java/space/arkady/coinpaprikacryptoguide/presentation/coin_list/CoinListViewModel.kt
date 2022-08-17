package space.arkady.coinpaprikacryptoguide.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import space.arkady.coinpaprikacryptoguide.common.Resource
import space.arkady.coinpaprikacryptoguide.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        CoinListState(error = result.message ?: "Unexpected error could happen")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}