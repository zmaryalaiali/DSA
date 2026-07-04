package hashing.linearprobing

fun main() {
    val probing = LinearProbing(13)

    probing.insertValue("the")
    probing.insertValue("quick")
    probing.insertValue("brown")
    probing.insertValue("fox")
    probing.insertValue("over")

    probing.show()
    probing.remove("over")
    probing.show()
}