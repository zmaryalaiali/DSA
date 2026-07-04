package graph.dikjistra

fun main(args: Array<String>) {
    val graph = WeightGraph(
        mutableListOf(
            WeightNode("A", 0), // 0
            WeightNode("B", 1), // 1
            WeightNode("C", 2), // 2
            WeightNode("D", 3)  // 3
        )
    )

// A -> B (8)
    graph.addWeightNode(0, 1, 8)

// A -> D (1)
    graph.addWeightNode(0, 3, 1)

// B -> C (1)
    graph.addWeightNode(1, 2, 1)

    // C -> A (4)
    graph.addWeightNode(2, 0, 4)

// D -> C (9)
    graph.addWeightNode(3, 2, 9)

// D -> B (2)
    graph.addWeightNode(3, 1, 2)



    graph.floydWarshall()
}