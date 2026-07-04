package binaryheap

import kotlin.properties.Delegates

public class Main constructor(size: Int) {
    var array: IntArray = IntArray(size)
    var sizeOfHB by Delegates.notNull<Int>()

    init {
        sizeOfHB = 0
    }


}

fun main(args: Array<String>) {
    val start = System.nanoTime()
    val heap = BinaryHeap(12)
    heap.insert(5, "Min")
    heap.insert(10, "Min")
    heap.insert(80, "Min")
    heap.insert(20, "Min")
    heap.insert(30, "Min")
    heap.insert(40, "Min")
    heap.insert(50, "Min")
    heap.insert(60, "Min")

    heap.preOrder(1)
    println()
    heap.levelOrder()
    println()
    println(heap.extractRoot("Min"))

    heap.preOrder(1)

}
