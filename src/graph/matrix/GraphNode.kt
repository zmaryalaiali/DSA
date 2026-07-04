package graph.matrix

data class GraphNode(val name: String, val index: Int, var visibility: Boolean = false, var parent: GraphNode? = null) {
    public fun addParent(node: GraphNode) {
        this.parent = node
    }
}
