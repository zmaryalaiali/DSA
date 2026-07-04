package tree.avltree


fun main() {

    val tree = AVLTree()

    tree.root = tree.insert(tree.root, 10)
    tree.root = tree.insert(tree.root, 20)
    tree.root = tree.insert(tree.root, 30) // triggers rotation5)

    tree.preorder(tree.root)

}