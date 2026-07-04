package graph.matrix

fun main() {
    val list = listOf<GraphNode>(
        GraphNode(name = "A", index = 0),
        GraphNode(name = "B", index = 1),
        GraphNode(name = "C", index = 2),
        GraphNode(name = "D", index = 3),
        GraphNode(name = "E", index = 4),
        GraphNode(name = "F", index = 5),
        GraphNode(name = "G", index = 6),
        GraphNode(name = "H", index = 7),
    )
    val graph = Graph(list)

    val list1: MutableList<String> = mutableListOf("A", "B", "C", "D", "E", "F", "G", "H")

    graph.addEdge(0, listOf(2))
    graph.addEdge(1, listOf(2, 3))
    graph.addEdge(2, listOf(4))
    graph.addEdge(3, listOf(5))
    graph.addEdge(4, listOf(5, 7))
    graph.addEdge(5, listOf(6))
    graph.addEdge(6, listOf())
    graph.addEdge(7, listOf())


    graph.printMatrix()
    println()

    graph.bfsForSSSPP()

}