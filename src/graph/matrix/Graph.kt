package graph.matrix

import java.util.*

class Graph(private val nodes: List<GraphNode>) {
    val array = Array(nodes.size) { IntArray(nodes.size) }

    fun addEdge(i: Int, linkedList: List<Int>) {
        for (k in linkedList) {
            array[i][k] = 1
        }
    }

    fun printNodes() {
        print("$nodes ")
    }


    fun printMatrix() {
        print("    ")
        for (i in nodes) {
            print("${i.name} ")
        }
        println()
        for ((i, row) in array.withIndex()) {
            print("${nodes[i].name} : ")
            println(row.joinToString(" "))
        }
    }

    public fun getNeighbors(node: GraphNode): List<GraphNode> {
        val neighbors = ArrayList<GraphNode>()
        val index = node.index
        for (i in 0 until array.size) {
            if (array[index][i] == 1) {
                neighbors.add(nodes[i])
            }

        }
        return neighbors
    }


    public fun bfsTraversal() {
        for (node in nodes) {
            if (!node.visibility) {
                val queue: Queue<GraphNode> = LinkedList<GraphNode>()
                queue.add(node)
                while (queue.isNotEmpty()) {
                    val currentNode = queue.poll()
                    print("${currentNode.name}   ")
                    currentNode.visibility = true
                    val neighbors = getNeighbors(currentNode)
                    for (neighbor in neighbors) {
                        if (!neighbor.visibility) {
                            neighbor.visibility = true
                            queue.add(neighbor)
                        }
                    }
                }
            }
        }
    }

    public fun dfsTraversal(node: GraphNode = nodes[0]) {
        val stack = ArrayDeque<GraphNode>()
        stack.addFirst(node)
        while (stack.isNotEmpty()) {
            val currentNode = stack.removeFirst()
            print("${currentNode.name}   ")
            currentNode.visibility = true
            val neighbors = getNeighbors(currentNode)
            for (neighbor in neighbors) {
                if (!neighbor.visibility) {
                    neighbor.visibility = true
                    stack.addFirst(neighbor)
                }
            }
        }
    }


    fun topologicalSort() {
        val stack = ArrayDeque<GraphNode>()
        fun visit(node: GraphNode) {
            if (node.visibility)
                return
            node.visibility = true
            for (neighbor in getNeighbors(node)) {
                visit(neighbor)
            }

            stack.push(node)
        }
        for (node in nodes) {
            visit(node)
        }
        while (stack.isNotEmpty()) {
            print("${stack.pop().name} ")
        }

    }


    public fun printPath(node: GraphNode) {
        if (node.parent != null) {
            printPath(node.parent!!)
        }
        print(" ${node.name}")
    }

    public fun bfsForSSSPP() {
        for (node in nodes) {
            if (!node.visibility) {
                val queue = ArrayDeque<GraphNode>()
                queue.push(node)

                while (queue.isNotEmpty()) {
                    val currentNode = queue.poll()
                    print(" printing path for node  ${currentNode.name}   ")
                    printPath(currentNode)
                    println()
                    currentNode.visibility = true
                    val neighbors = getNeighbors(currentNode)
                    for (neighbor in neighbors) {
                        if (!neighbor.visibility) {
                            neighbor.visibility = true
                            neighbor.parent = currentNode
                            queue.add(neighbor)
                        }
                    }
                }
            }
        }
    }


}