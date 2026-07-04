package graph.list

fun main() {

    val a = GraphNode("A")
    val b = GraphNode("B")
    val c = GraphNode("C")
    val d = GraphNode("D")
    val e = GraphNode("E")
    val f = GraphNode("F")
    val g = GraphNode("G")
    val h = GraphNode("H")

// A -> C
    a.neighbors.add(c)

// B -> C, D
    b.neighbors.add(c)
    b.neighbors.add(d)

// C -> E
    c.neighbors.add(e)

// D -> F
    d.neighbors.add(f)

// E -> F, H
    e.neighbors.add(f)
    e.neighbors.add(h)

// F -> G
    f.neighbors.add(g)

// G -> no neighbors
// H -> no neighbors

    val graph = Graph()
    graph.addEdge(a)
    graph.addEdge(b)
    graph.addEdge(c)
    graph.addEdge(d)
    graph.addEdge(e)
    graph.addEdge(f)
    graph.addEdge(g)
    graph.addEdge(h)

    graph.printGraph()
    graph.bfsForSSSPP()
//    graph.dfsTraversal()


}