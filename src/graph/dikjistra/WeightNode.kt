package graph.dikjistra

class WeightNode(
    val name: String,
    val index: Int
) : Comparable<WeightNode> {

    var visibility = false
    var distance = Int.MAX_VALUE
    var parent: WeightNode? = null

    val hashMap = hashMapOf<WeightNode, Int>()
    val neighbors = mutableListOf<WeightNode>()

    override fun compareTo(other: WeightNode): Int =
        distance.compareTo(other.distance)

    override fun toString(): String = name
}