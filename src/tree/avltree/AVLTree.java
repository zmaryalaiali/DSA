package tree.avltree;

import java.util.HashMap;
import java.util.Map;

class AVLTree {

    Node root;

    static void main() {
        Map<Character, Integer> ma = new HashMap<>();

    }

    // Get height
    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    // Get balance factor
    int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    // Right rotate
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert node
    Node insert(Node node, int key) {

        // 1. BST insert
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // no duplicates

        // 2. Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Rotations

        // Left Left
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.printf("value of the tree " + root.key);
        preorder(root.left);
        preorder(root.right);
    }

    static class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }
//    fun preorder(root:Node?) {
//        root ?:return
//                println("value of tree ${root.value}")
//        preorder(root.left)
//        preorder(root.right)
//    }


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
//    fun levelOrder(root: Tree?) {
//        root ?: return
//        println("value of tree ${root.value}")
//        preorder(root.left)
//        preorder(root.right)
//    }
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
}