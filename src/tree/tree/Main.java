package tree.tree;

public class Main {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        hot.add(tea);
        hot.add(coffee);
        TreeNode cold = new TreeNode("Cold");
        TreeNode wine = new TreeNode("Win");
        TreeNode bear = new TreeNode("Bear");
        TreeNode khear = new TreeNode("Khear");
        bear.add(khear);
        cold.add(wine);
        cold.add(bear);
        tree.add(hot);
        tree.add(cold);
        System.out.println(tree.print(5));

    }
}
