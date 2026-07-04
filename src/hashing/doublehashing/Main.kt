package hashing.doublehashing

fun main() {
    val probing = DoubleHashing(13)

    probing.insert("the")
    probing.insert("quick")
    probing.insert("brown")
    probing.insert("fox")
    probing.insert("over")
    println(probing.hashCode())

    probing.show()
}