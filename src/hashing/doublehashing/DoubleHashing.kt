package hashing.doublehashing

class DoubleHashing constructor(private val size: Int) {
    var array = arrayOfNulls<String>(size)
    var numberUse = 0

    fun reHash() {
        numberUse = 0
        val list = mutableListOf<String>()
        for (i in array) {
            if (i != null) {
                list.add(i)
            }
        }
        array = arrayOfNulls<String>(size * 2)

        for (i in list) {
            insert(i)
        }
//        insertValue(word)

    }


    fun asciiOfWord(word: String): Int {

        val chars = word.toCharArray()

        var sum: Int = 0

        for (c in chars) {
            sum += c.code
        }

        return sum % array.size

    }

    fun getLoadFactor(): Double {
        return numberUse * (1.0 / array.size)
    }

    private fun hash2(key: String): Int {
        return 7 - (asciiOfWord(key) % 7) // must not be 0
    }

    fun insert(key: String) {
        var index = asciiOfWord(key)

        if (array[index] == null) {
            array[index] = key
            return
        }

        val stepSize = hash2(key)
        var i = 1

        while (array[(index + i * stepSize) % size] != null) {
            i++
        }

        array[(index + i * stepSize) % size] = key
    }


    public fun show() {


        var index = 0
        for (i in array) {
            println(" $index  $i")
            index++
        }

    }


    fun remove(word: String) {
        val index = asciiOfWord(word)
        for (i in index..<index + array.size) {
            val newIndex = i % array.size
            if (array[newIndex] == word) {
                array[newIndex] = null
            }
        }
    }

    fun search(word: String) {
        val index = asciiOfWord(word)
        for (i in index..<index + array.size) {
            val newIndex = i % array.size
            if (array[newIndex] == word) {
                println("the $i successful searched in location $newIndex ")
                return
            }
        }
    }
}