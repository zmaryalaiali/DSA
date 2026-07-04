package trie

class Trie {
    var root: Node = Node()

    constructor() {
        println("Trie is Created ")
    }

    fun insert(word: String) {

        var current = root

        for (i in 0..<word.length) {
            val ch = word[i]
            var node = current.ChildNode[ch]
            if (node == null) {
                node = Node()
                current.ChildNode[ch] = node
            }
            current = node
        }
        current.endOfString = true
    }

    public fun find(word: String): Boolean {
        var current = root
        for (i in 0..<(word.length)) {
            val ch = word[i]
            var node = current.ChildNode[ch]
            if (node == null) {
                return false
            }
            current = node
        }
        return current.endOfString
    }
}