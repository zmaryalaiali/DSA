package greedy.coin

fun main() {
    println(
        CoinChange.coinChange(
            intArrayOf(1, 3, 4),
            amount = 6
        )
    )
}