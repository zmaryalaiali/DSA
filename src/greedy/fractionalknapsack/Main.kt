package greedy.fractionalknapsack

fun main() {
    FractionalKnapsack.fractional(
        items = arrayOf(
            KnapsackItem(value = 60, height = 12),
            KnapsackItem(value = 1, height = 15),
            KnapsackItem(value = 20, height = 16),
            KnapsackItem(value = 100, height = 24)
        ),
        capacity = 50
    )
}