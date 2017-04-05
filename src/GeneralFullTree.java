import java.util.ArrayList;

/**
 * Created by huseyin on 30.03.2017.
 */
public class GeneralFullTree {

    private TreeNode root;
    private int branch_f;
    private int depth;
    private int position;
    private int ID;

    public GeneralFullTree() {
        branch_f = 0;
        depth = 0;
        root = null;
        position = -1;
        ID = 0 ;
    }

    public GeneralFullTree(int b, int d, int p) {
        depth = d;
        branch_f = b;
        position = p - 1;
        createID();

        root = new TreeNode(0);

        // int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        for (int i = 0 ; i < depth ; i++ ) {
            TreeNode expand = queue.get(0);
            queue.remove(0);
            for ( int j = 0 ; j < branch_f ; j++ ) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                queue.add(newTreeNode);
            }
        }
    }

    private void createID() {
        this.ID = ( position * 100 ) + depth ;
    }

    /*
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
    } */

    public int getBranch_f() {
        return branch_f;
    }

    public int getDepth() {
        return depth;
    }

    public int getPosition() {
        return position;
    }

    public int getID() {
        return ID;
    }
}