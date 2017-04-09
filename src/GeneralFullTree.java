import java.util.*;

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

    GeneralFullTree(int b, int d, Queue<TreeNode> queue) {
        depth = d;
        branch_f = b;
        root = new TreeNode(0);
        //System.out.println( "Generating bf: " + b + ", d: " + d);

        int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        int lowBound = (int) (Math.pow(branch_f, depth ) - 1) / (branch_f - 1) + 1;

        position = lowBound + (int) (Math.random() * (nodeCount-lowBound));
        createID();

        queue.clear();
        queue.offer(root);
        //System.out.println("Added root");
        int i = 0;
        while (nodeCount > 0) {
            TreeNode expand = queue.poll();
            for (int j = 0; j < branch_f; j++) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                queue.add(newTreeNode);
                nodeCount--;
            }
            //System.out.println(nodeCount);
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
        this.ID = (position * 1000) + depth ;
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

    @Override
    public int hashCode()
    {
        int[] arr = new int[] { position, depth };
        return Arrays.hashCode(arr);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof GeneralFullTree)) return false;

        GeneralFullTree otherTree = (GeneralFullTree) other;

        return (this.position == otherTree.position && this.depth == otherTree.depth);
    }
}
