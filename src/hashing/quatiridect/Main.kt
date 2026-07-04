package hashing.quatiridect

fun main() {
    val probing = Quadratic(13)

    probing.insertValue("the")
    probing.insertValue("quick")
    probing.insertValue("brown")
    probing.insertValue("fox")
    probing.insertValue("over")

    probing.show()
    probing.remove("over")
    probing.show()
}