package tree.tree;

import java.util.ArrayList;

public class TreeNode{
    private String data ;
    private ArrayList<TreeNode> treeNodes;

    public TreeNode(String data){
        this.data = data;
        this.treeNodes = new ArrayList<>();
    }

    public void add(TreeNode treeNode){
        treeNodes.add(treeNode);
    }

    public String print(int level){ /// this pre-order prints and also we have two more type one is post order and n order
        StringBuilder ret ;
        ret = new StringBuilder("  ".repeat(level) + data + "\n");
        for (TreeNode t :
                this.treeNodes) {
            ret.append(t.print(level+1));
        }
        return ret.toString();
    }

}
