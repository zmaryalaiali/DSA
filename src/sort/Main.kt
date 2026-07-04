package sort

import kotlin.math.sqrt

fun main() {
    val doublearray = DoubleArray(5)
    doublearray[0] = 4.0
    doublearray[1] = 2.0
    doublearray[2] = 8.0
    doublearray[3] = 3.0
    doublearray[4] = 1.0

    println(doublearray.joinToString())

    println(sortArrayByBucket(doublearray).joinToString())
}


fun sortArrayByBucket(array: DoubleArray): DoubleArray {
    if (array.isEmpty()) return array

    val bucketCount = sqrt(array.size.toDouble()).toInt().coerceAtLeast(1)
    val buckets = Array(bucketCount) { mutableListOf<Double>() }

    val min = array.minOrNull()!!
    val max = array.maxOrNull()!!

    // Avoid division by zero if all elements are equal
    val range = max - min
    if (range == 0.0) return array

    // Distribute elements into buckets
    for (value in array) {
        val normalized = (value - min) / range
        val index = (normalized * (bucketCount - 1)).toInt()
        buckets[index].add(value)
    }

    // Sort each bucket
    for (bucket in buckets) {
        bucket.sort()
    }

    // Merge buckets back into array
    var idx = 0
    for (bucket in buckets) {
        for (value in bucket) {
            array[idx++] = value
        }
    }

    return array
}