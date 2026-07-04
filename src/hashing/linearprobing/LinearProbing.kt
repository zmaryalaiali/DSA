package hashing.linearprobing

class LinearProbing constructor(private val size: Int) {
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
            insertValue(i)
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

    fun insertValue(i: String) {
        val index = asciiOfWord(i)

        if (getLoadFactor() >= 0.75) {
            reHash()
        } else {
            for (j in index..<array.size) {
                val newIndex = j % array.size

                if (array[newIndex] == null) {
                    array[newIndex] = i
                    println("the $i successful inserted in location $newIndex ")
                    break
                } else {
                    println("the index Of ${newIndex}already occupied ")
                }
            }
        }

        numberUse++

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