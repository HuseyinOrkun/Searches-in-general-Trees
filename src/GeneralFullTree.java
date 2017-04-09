import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

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
        ID = 0;
    }

    GeneralFullTree(int b, int d) {
        depth = d;
        branch_f = b;
        root = new TreeNode(0);

        int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        int lowBound = (int) (Math.pow(branch_f, depth ) - 1) / (branch_f - 1) +1;

        position = lowBound + (int) (Math.random() * (nodeCount-lowBound));
        createID();

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 0;
        while (nodeCount > 0) {
            TreeNode expand = queue.get(0);
            queue.remove(0);
            for (int j = 0; j < branch_f; j++) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                queue.add(newTreeNode);
                nodeCount--;
            }
            i++;
        }
    }


    public boolean depthFirstSearch() {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode expand = stack.pop();
            if (isGoal(expand)) {
                return true;
            }
            if (expand.getChildren().size() > 0) {
                for (int j = getBranch_f() - 1; j >= 0; j--) {
                    stack.push(expand.getChildren().get(j));
                }
            }
        }
        return false;
    }




    public boolean IterativeDeepeningDFS() {
        for (int depthBound = 0; depthBound <= this.getDepth(); depthBound++) {
            if (depthBoundedDFS(root, depthBound))
                return true;
        }
        return false;
    }

    private boolean depthBoundedDFS(TreeNode root, int depthBound) {
        if (depthBound == 0 && isGoal(root)) {
            return true;
        }
        if (depthBound > 0)
            for (TreeNode child : root.getChildren()) {
                if (depthBoundedDFS(child, depthBound - 1)) {
                    return true;
                }
            }
        return false;
    }

    private boolean isGoal(TreeNode node) {
        return node.getData() == getPosition()-1;
    }

    private void createID() {
        this.ID = (position * 100) + depth ;
    }

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
