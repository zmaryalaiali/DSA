package trie

fun main() {
    val trie = Trie()

    trie.insert("API")
    trie.insert("APIS")
    trie.insert("APII")
    println(trie.find("APISk"))

}