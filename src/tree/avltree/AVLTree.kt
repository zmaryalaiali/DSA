//package tree.avltree
//
//class AVLTree {
//    var root: Tree? = null
//
//    constructor() {
//        root = null
//    }
//
//    fun preorder(root: Tree?) {
//        root ?: return
//        println("value of tree ${root.value}")
//        preorder(root.left)
//        preorder(root.right)
//    }
//
//    fun inorder(root: Tree?) {
//        root ?: return
//        preorder(root.left)
//        println("value of tree ${root.value}")
//        preorder(root.right)
//    }
//
//    fun postorder(root: Tree?) {
//        root ?: return
//        preorder(root.left)
//        preorder(root.right)
//        println("value of tree ${root.value}")
//    }
//
////    fun levelOrder(root: Tree?) {
////        root ?: return
////        println("value of tree ${root.value}")
////        preorder(root.left)
////        preorder(root.right)
////    }
//
//    fun search(root: Tree?, value: Int): Tree? {
//        if (root == null) return null
//        return if (root.value == value) {
//            println("value of tree ${root.value}")
//            root
//        } else {
//            if (value <= root.value!!) {
//                search(root.left, value)
//            } else {
//                search(root.right, value)
//            }
//        }
//
//
//    }
//
//}