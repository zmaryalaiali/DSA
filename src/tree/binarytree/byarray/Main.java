package tree.binarytree.byarray;

import tree.binarytree.binarytreelinkedlist.TreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>(9);
        binaryTree.insertNote("N1");
        binaryTree.insertNote("N2");
        binaryTree.insertNote("N3");
        binaryTree.insertNote("N4");
        binaryTree.insertNote("N5");
        binaryTree.insertNote("N6");
        binaryTree.insertNote("N7");
        binaryTree.insertNote("N8");
        binaryTree.insertNote("N9");
//
//        binaryTree.preorder(1);
//        System.out.println();
//        binaryTree.postorder(1);
//        System.out.println();
//        binaryTree.inorder(1);
//        System.out.println();
        binaryTree.levelOrder();
        binaryTree.delete("N4");
        binaryTree.levelOrder();


    }
}
