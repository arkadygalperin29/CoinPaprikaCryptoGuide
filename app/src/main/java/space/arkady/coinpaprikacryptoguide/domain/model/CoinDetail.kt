package space.arkady.coinpaprikacryptoguide.domain.model

import space.arkady.coinpaprikacryptoguide.data.remote.dto.TeamMembers

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<TeamMembers>
)


