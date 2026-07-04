package tree.binarytree.binarytreelinkedlist;

import tree.binarytree.binarytreelinkedlist.BinaryTreeLL;
import tree.binarytree.binarytreelinkedlist.TreeNode;

public class Main {
    public static void main(String[] args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
        TreeNode n1 = new TreeNode("N1");
        TreeNode n2 = new TreeNode("N2");
        TreeNode n3 = new TreeNode("N3");
        TreeNode n4 = new TreeNode("N4");
        TreeNode n5 = new TreeNode("N5");
        TreeNode n6 = new TreeNode("N6");
        TreeNode n7 = new TreeNode("N7");
        TreeNode n8 = new TreeNode("N8");
        TreeNode n9 = new TreeNode("N9");
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n8;
        n4.right = n9;
        n3.left = n6;
        n3.right = n7;

        binaryTreeLL.root = n1;

//        binaryTreeLL.preorder(binaryTreeLL.root);
//        System.out.println();
//        binaryTreeLL.inorder(binaryTreeLL.root);
//        System.out.println();
//        binaryTreeLL.postorder(binaryTreeLL.root);
        binaryTreeLL.levelOrder();
   binaryTreeLL.deleteNode("N1");
        binaryTreeLL.levelOrder();
    }


}
