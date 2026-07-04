package graph.dikjistra

import java.util.*

class WeightGraph constructor(val nodes: MutableList<WeightNode>) {
    fun dijkstra(start: WeightNode = nodes.first()) {

        for (n in nodes) {
            n.distance = Int.MAX_VALUE
            n.parent = null
        }

        start.distance = 0

        val priorityQueue = PriorityQueue<WeightNode>()
        priorityQueue.addAll(nodes)

        while (priorityQueue.isNotEmpty()) {

            val current = priorityQueue.poll()

            for (neighbour in current.neighbors) {

                val weight = current.hashMap[neighbour] ?: continue
                val newDistance = current.distance + weight

                if (priorityQueue.contains(neighbour) &&
                    newDistance < neighbour.distance
                ) {

                    neighbour.distance = newDistance
                    neighbour.parent = current

                    priorityQueue.remove(neighbour)
                    priorityQueue.add(neighbour)
                }
            }
        }

        for (node in nodes) {
            print("Node ${node.name} distance ${node.distance} path:")
            printPath(node)
            println()
        }
    }


    public fun printPath(node: WeightNode) {
        if (node.parent != null) {
            printPath(node.parent!!)
        }
        print(" ${node.name}")
    }


    fun addWeightNode(i: Int, j: Int, d: Int) {
        val first = nodes[i]
        val second = nodes[j]

        first.hashMap[second] = d
        first.neighbors.add(second)
    }


    fun bellManFor() {
        nodes[0].distance = 0

        for (i in 0..<nodes.size - 1) {
            for (node in nodes) {
                for (neighbour in node.neighbors) {
                    val weight = node.hashMap[neighbour] ?: continue
                    if (node.distance != Int.MAX_VALUE &&
                        neighbour.distance > node.distance + weight
                    ) {
                        neighbour.distance = node.distance + weight
                        neighbour.parent = node
                    }
                }
            }
        }


        println("Checking for negative weights")

        for (node in nodes) {
            for (neighbour in node.neighbors) {
                val weightr = node.hashMap[neighbour] ?: continue
                if (node.distance != Int.MAX_VALUE &&
                    neighbour.distance > node.distance + weightr
                ) {
                    println("negative distance found \n vertext name : ${neighbour.name} \n old distance $weightr  \n new distance is ${weightr + node.distance}  ")

                    return
                }
            }
        }

        println("Negative not found  ")


        for (node in nodes) {
            print("Node ${node.name} distance ${node.distance} path:")
            printPath(node)
            println()
        }

    }


    fun floydWarshall() {
        val size = nodes.size
        val v = Array(size) { IntArray(size) }
        for (i in 0 until size) {
            val first = nodes[i]
            for (j in 0 until size) {
                val second = nodes[j]

                v[i][j] = when {
                    i == j -> 0
                    first.hashMap.containsKey(second) -> first.hashMap[second]!!
                    else -> Int.MAX_VALUE / 10
                }
            }
        }

        for (k in 0..<size) {
            for (i in 0..<size) {
                for (j in 0..<size) {
                    if (
                        v[i][j] > v[i][k] + v[k][j]
                    ) {
                        v[i][j] = v[i][k] + v[k][j]
                    }
                }
            }
        }

        for (i in 0 until size) {
            print("${nodes[i]}: ")
            for (j in 0 until size) {
                print(
                    "${v[i][j]} "
                )
            }
            println()
        }

    }


}