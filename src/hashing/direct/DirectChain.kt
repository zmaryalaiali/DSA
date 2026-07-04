package hashing.direct


class DirectChain constructor(private val size: Int) {
    private val hashtable = arrayOfNulls<MutableList<String>>(size)


    fun asciiOfWord(word: String): Int {

        val chars = word.toCharArray()

        var sum: Int = 0

        for (c in chars) {
            sum += c.code
        }

        return sum % hashtable.size

    }

    public fun insert(word: String): Boolean {
        val code = asciiOfWord(word)
        val isAvailable = hashtable[code]
        if (isAvailable == null) {
            hashtable[code] = mutableListOf(word)
            return true
        }
        hashtable[code]?.add(word)
        return false
    }


    public fun show() {
        var index = 0
        for (i in hashtable) {
            println(" $index  $i")
            index++
        }

    }


    public fun remove(word: String) {

        val index = asciiOfWord(word)
        hashtable[index]?.remove(word)
    }


    public fun search(word: String): Boolean {

        val index = asciiOfWord(word)

        if (hashtable[index] == null || hashtable[index]?.contains(word) == false) {
            return false
        }
        return true


    }
}
