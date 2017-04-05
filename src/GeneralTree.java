import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by huseyin on 30.03.2017.
 */
public class GeneralTree {

    private List<TreeNode> nodes;
    private int branch_f;
    private int depth;

    public GeneralTree() {
        branch_f = 0;
        depth = 0;
        nodes = new ArrayList<TreeNode>();
    }

    public void createFullTree(int b, int d) {
        depth = d;
        branch_f = b;
        nodes.add(new TreeNode(0));

        int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        ArrayList<TreeNode> queue = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            TreeNode expand = queue.get(0);
            queue.remove(0);
            for (int j = 0; j < branch_f; j++) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                nodes.add(newTreeNode);
                queue.add(newTreeNode);
            }
        }
    }
    public void inorderTraverse(){

        int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        ArrayList<TreeNode> queue = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            queue.remove(0);
            for (int j = 0; j < branch_f; j++) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                nodes.add(newTreeNode);
                queue.add(newTreeNode);
            }
        }
    }

    public int getBranch_f() {
        return branch_f;
    }

    public void setBranch_f(int branch_f) {
        this.branch_f = branch_f;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

    public static void main(String[] args) {
        GeneralTree t = new GeneralTree();
        t.createFullTree(2, 3);


    }
}