package binaryheap

class BinaryHeap constructor(size: Int) {
    private var arrayOfBinaryHeap = IntArray(size + 1)
    private var sizeOfHB: Int = 0


    public fun isEmpty(): Boolean {
        return sizeOfHB == 0 || arrayOfBinaryHeap.isEmpty()
    }

    public fun peek(): Int? {
        if (!isEmpty()) {
            return arrayOfBinaryHeap[sizeOfHB]
        }
        return null
    }

    public fun levelOrder() {
        for (i in 1..sizeOfHB) {
            print(arrayOfBinaryHeap[i].toString() + " ")
        }
        println()
    }

    fun preOrder(index: Int) {
        if (index > sizeOfHB) {
            return
        }
        print("${arrayOfBinaryHeap[index]}   ")
        preOrder(index * 2)
        preOrder(index * 2 + 1)
    }

    public fun size() = arrayOfBinaryHeap.size

    public fun heapifyBottomToTop(index: Int, type: String) {
        val parent = index / 2
        if (index <= 1) {
            return
        }

        if (type == "Min") {
            if (arrayOfBinaryHeap[index] < arrayOfBinaryHeap[parent]) {
                val temp = arrayOfBinaryHeap[index]
                arrayOfBinaryHeap[index] = arrayOfBinaryHeap[parent]
                arrayOfBinaryHeap[parent] = temp
            }
        } else if (type == "Max") {
            if (arrayOfBinaryHeap[index] < arrayOfBinaryHeap[parent]) {
                val temp = arrayOfBinaryHeap[index]
                arrayOfBinaryHeap[index] = arrayOfBinaryHeap[parent]
                arrayOfBinaryHeap[parent] = temp
            }
        }
    }


    public fun insert(value: Int, type: String) {
        arrayOfBinaryHeap[sizeOfHB.plus(1) ?: 0] = value
        sizeOfHB += 1

        heapifyBottomToTop(sizeOfHB, type)
    }

    public fun heapifyTopToBottom(index: Int, type: String) {

        val left = index * 2
        val right = left + 1
        var swapChild = 0


        if (sizeOfHB < index) return
        if (type == "Min") {

            if (sizeOfHB == left) {
                if (arrayOfBinaryHeap[index] < arrayOfBinaryHeap[left]) {
                    val temp = arrayOfBinaryHeap[left]
                    arrayOfBinaryHeap[left] = arrayOfBinaryHeap[index]
                    arrayOfBinaryHeap[index] = temp
                }

            } else {
                if (arrayOfBinaryHeap[left] > arrayOfBinaryHeap[right]) {
                    swapChild = left
                } else {
                    swapChild = right
                }
                if (arrayOfBinaryHeap[index] < arrayOfBinaryHeap[swapChild]) {
                    val temp = arrayOfBinaryHeap[swapChild]
                    arrayOfBinaryHeap[swapChild] = arrayOfBinaryHeap[index]
                    arrayOfBinaryHeap[index] = temp
                }
            }
        } else {

            if (sizeOfHB == left) {
                if (arrayOfBinaryHeap[index] > arrayOfBinaryHeap[left]) {
                    val temp = arrayOfBinaryHeap[left]
                    arrayOfBinaryHeap[left] = arrayOfBinaryHeap[index]
                    arrayOfBinaryHeap[index] = temp
                }

            } else {
                if (arrayOfBinaryHeap[left] < arrayOfBinaryHeap[right]) {
                    swapChild = left
                } else {
                    swapChild = right
                }
                if (arrayOfBinaryHeap[index] > arrayOfBinaryHeap[swapChild]) {
                    val temp = arrayOfBinaryHeap[swapChild]
                    arrayOfBinaryHeap[swapChild] = arrayOfBinaryHeap[index]
                    arrayOfBinaryHeap[index] = temp
                }
            }
        }

        heapifyTopToBottom(swapChild, type)
    }

    public fun extractRoot(type: String): Int {
        if (isEmpty())
            return -1
        val extract = arrayOfBinaryHeap[1]
        arrayOfBinaryHeap[1] = arrayOfBinaryHeap[sizeOfHB]
        sizeOfHB--
        heapifyTopToBottom(arrayOfBinaryHeap[sizeOfHB], type)
        return extract
    }
}