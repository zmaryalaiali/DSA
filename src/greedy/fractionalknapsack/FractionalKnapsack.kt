package greedy.fractionalknapsack

class FractionalKnapsack {

    companion object {
        @JvmStatic
        fun fractional(items: Array<KnapsackItem>, capacity: Int) {
            val sortArray = items.sortedBy {
                it.ratio
            }                       // 10 20 30 10 capacity = 50
            var inserted = 0
            var total = 0
            for (i in sortArray.size - 1 downTo 0) {
                if (inserted + sortArray[i].height <= capacity) {
                    sortArray[i].index = 1
                    inserted += sortArray[i].height
                    total += sortArray[i].height
                    println("item take it ${sortArray[i].index} value ${sortArray[i].value} and height ${sortArray[i].height}")
                } else {
                    val fractional = capacity - total
                    val value = (sortArray[i].value * fractional) / sortArray[i].height
                    if (sortArray[i].height >= fractional) {
                        inserted += fractional
                        println("item take it ${sortArray[i].index} value $value and height $fractional")
                        break
                    }
                }
            }

        }
    }
}