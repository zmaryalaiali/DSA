package graph.list

import java.util.*

class Graph {
    val listNodes = mutableListOf<GraphNode>()

    fun addEdge(node: GraphNode) {
        listNodes.add(node)
    }

    fun printGraph() {
        for (node in listNodes) {
            val neighborNames = node.neighbors.joinToString { it.name }
            println("${node.name} -> $neighborNames")
        }
    }


    public fun bfsTraversal(node: GraphNode = listNodes[0]) {
        val queue: Queue<GraphNode> = LinkedList<GraphNode>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            print("${currentNode.name}   ")
            currentNode.visibility = true
            val neighbors = currentNode.neighbors
            for (neighbor in neighbors) {
                if (!neighbor.visibility) {
                    neighbor.visibility = true
                    queue.add(neighbor)
                }
            }
        }
    }


    public fun dfsTraversal(node: GraphNode = listNodes[0]) {
        val stack: ArrayDeque<GraphNode> = ArrayDeque<GraphNode>()
        stack.addFirst(node)
        while (stack.isNotEmpty()) {
            val currentNode = stack.pop()
            print("${currentNode.name}   ")
            currentNode.visibility = true
            val neighbors = currentNode.neighbors
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
            if (node.neighbors.isNotEmpty()) {
                for (neighbor in node.neighbors) {
                    visit(neighbor)
                }
            }
            stack.addFirst(node)
        }
        for (node in listNodes) {
            visit(node)
        }
        while (stack.isNotEmpty()) {
            print("${stack.poll().name} ")
        }

    }

    public fun printPath(node: GraphNode) {
        if (node.parent != null) {
            printPath(node.parent!!)
        }
        print(" ${node.name}")
    }

    public fun bfsForSSSPP() {
        for (node in listNodes) {
            if (!node.visibility) {
                val queue = ArrayDeque<GraphNode>()
                queue.push(node)

                while (queue.isNotEmpty()) {
                    val currentNode = queue.poll()
                    print(" printing path for node  ${currentNode.name}   ")
                    printPath(currentNode)
                    println()
                    currentNode.visibility = true
                    val neighbors = currentNode.neighbors
                    for (neighbor in neighbors) {
                        if (!neighbor.visibility) {
                            neighbor.visibility = true
                            queue.add(neighbor)
                            neighbor.parent = currentNode
                        }
                    }
                }
            }
        }
    }


//    fun printMatrix() {
//        print("    ")
//        for (i in nodes) {
//            print("${i.name} ")
//        }
//        println()
//        for ((i, row) in array.withIndex()) {
//            print("${nodes[i].name} : ")
//            println(row.joinToString(" "))
//        }
//    }
}