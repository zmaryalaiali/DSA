package greedy.fractionalknapsack

data class KnapsackItem(var index: Int = 0, val value: Int, val height: Int, val ratio: Int = value / height)