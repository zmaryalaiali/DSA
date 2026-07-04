package greedy.coin

class CoinChange {
    companion object {
        @JvmStatic
        fun coinChange(coins: IntArray, amount: Int) {
            if (amount <= 0) return
            coins.sort()  /// o(n logn)
            for (i in coins.size - 1 downTo 0) {  // o(n)
                if (amount >= coins[i]) {
                    println(coins[i])
                    coinChange(coins, amount - coins[i])
                    break
                }
            }

        }
    }
}