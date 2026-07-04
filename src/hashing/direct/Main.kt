package hashing.direct

fun main() {
    val direction = DirectChain(2)

    direction.insert("the")
    direction.insert("quick")
    direction.insert("brown")
    direction.insert("fox")
    direction.insert("over")
    println(direction.search("the"))
    direction.show()
}