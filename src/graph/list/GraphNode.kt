package graph.list

class GraphNode(
    val name: String,
    var visibility: Boolean = false,
    var parent: GraphNode? = null,
    val neighbors: MutableList<GraphNode> = mutableListOf()
) {

    public fun addParent(parent: GraphNode?) {
        this.parent = parent
    }

    override fun toString(): String {
        return name
    }
}