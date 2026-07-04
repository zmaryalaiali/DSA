package tree.binarytree.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        searchTree.insert(70);
        searchTree.insert(50);
        searchTree.insert(90);
        searchTree.insert(30);
        searchTree.insert(60);
        searchTree.insert(80);
        searchTree.insert(100);
        searchTree.insert(20);
        searchTree.insert(40);

//        searchTree.preorder(searchTree.root);
//        System.out.println();
//        searchTree.inorder(searchTree.root);
//        System.out.println();
//        searchTree.postorder(searchTree.root);
//        System.out.println();
//        searchTree.levelOrder();
//        System.out.println(searchTree.search(5));

        searchTree.levelOrder();
        searchTree.remove(30);
        System.out.println();
        searchTree.levelOrder();

    }
}
