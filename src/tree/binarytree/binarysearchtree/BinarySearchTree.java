package tree.binarytree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            System.out.println("node value " + value);
            return new Node(value);

        } else if (value <= node.value) {
            node.left = insert(node.left, value);
            return node;
        } else {
            node.right = insert(node.right, value);
            return node;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null)
            return;

        preorder(node.left);
        System.out.print(node.value + " ");
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null)
            return;
        preorder(node.left);
        preorder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public int search(int searchValue) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (searchValue == currentNode.value)
                return searchValue;
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return -1;
    }

    public Node getDeepest() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return currentNode;
    }


    public void removeDeepest() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node currentNode = null, parent = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            if (currentNode.left != null) {
                parent = currentNode;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                parent = currentNode;
                queue.add(currentNode.right);
            }
        }
        if (parent.right == currentNode) {

            parent.right = null;
        } else {
            parent.left = null;
        }

    }

    public void remove(int value) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (value == currentNode.value){
             currentNode.value = getDeepest().value;
             removeDeepest();
             return;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}
