package tree.avltree

class Tree {
    var right: Tree? = null
    var left: Tree? = null
    var height = 0
    var value: Int? = null

    constructor(value: Int) {
        this.height = 0
    }

}