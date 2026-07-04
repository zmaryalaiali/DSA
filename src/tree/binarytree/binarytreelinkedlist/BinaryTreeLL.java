package tree.binarytree.binarytreelinkedlist;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTreeLL {
    TreeNode root;

    public BinaryTreeLL() { ///time and space is o(1)
        this.root = null;
    }


    public void preorder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }


    public void postorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        inorder(node.right);
        System.out.print(node.value + " ");

    }

    public void levelOrder() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            var present = queue.remove();
            System.out.print(present.value + " ");
            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
        System.out.println();
    }

    public void search(String searchValue) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            var present = queue.poll();
            if (Objects.equals(searchValue, present.value)) {
                System.out.print("the search value is found " + present.value + " ");
                return;
            } else {
                if (present.left != null) {
                    queue.add(present.left);
                }
                if (present.right != null) {
                    queue.add(present.right);
                }
            }
        }
        System.out.print("the search value is not found ");
    }

    public void insert(String value) {
        var node = new TreeNode(value);
        if (root == null) {
            root = node;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            var present = queue.poll();

            if (present.left == null) {
                present.left = node;
                return;
            }
            if (present.right == null) {
                present.right = node;
                return;
            }
            queue.add(present.left);
            queue.add(present.right);
        }
        System.out.print("the search value is not found ");
    }

    public TreeNode getDeepestNode() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        TreeNode present = null;
        while (!queue.isEmpty()) {
            present = queue.poll();

            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
        return present;
    }


    public void deleteDeepestNode() {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode current = null;
        TreeNode parent = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.left != null) {
                parent = current;
                queue.add(current.left);
            }

            if (current.right != null) {
                parent = current;
                queue.add(current.right);
            }
        }

        // Now 'current' is deepest node
        // 'parent' is its parent

        if (parent != null) {
            if (parent.right == current)
                parent.right = null;
            else
                parent.left = null;
        } else {
            // Tree had only root
            root = null;
        }
    }

    public void deleteNode(String value) {
        if (Objects.equals(root.value, value)) {
            root.value = getDeepestNode().value;
            deleteDeepestNode();
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        TreeNode present = null;
        while (!queue.isEmpty()) {
            present = queue.poll();
            if (Objects.equals(present.value, value)){
                present.value = getDeepestNode().value;
                deleteDeepestNode();
                return;
            }

            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
    }
}
