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

    public GeneralFullTree(int b, int d) {
        depth = d;
        branch_f = b;
        position = (int) (Math.random() * ( Math.pow(b, d)  + 1 ) );
        createID();

        root = new TreeNode(0);

        int nodeCount = (int) (Math.pow(branch_f, depth +1) - branch_f-1) / (branch_f - 1);

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 0;
        while(nodeCount>0) {
            TreeNode expand = queue.get(0);
            queue.remove(0);
            for ( int j = 0 ; j < branch_f ; j++ ) {
                TreeNode newTreeNode = new TreeNode(i * branch_f + j + 1);
                expand.addChild(newTreeNode);
                queue.add(newTreeNode);
                nodeCount--;
            }
            i++;
        }
    }


    public ArrayList<TreeNode> depthFirstSearch(){   // you can do this by giving the parent til the root but might take more time

        // int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode expand = queue.get(0);
            queue.remove(0);
            path.add(expand);
            if(expand.getData() == position){
                return path;
            }
            else {
                if(expand.getChildren().size() > 0) {
                    for (int j = branch_f - 1; j >= 0; j--) {
                        queue.add(0, expand.getChildren().get(j));
                    }
                }
            }

        }
        return null;
    }


    public boolean IterativeDeepeningDFS() {
        for( int depthBound = 0 ; depthBound <= this.getDepth() ; depthBound++ ) {
            System.out.println("Now we are entering depth bounded dfs...");
            if( depthBoundedDFS( root, depthBound ) )
                return true;
        }
        return false;
    }
    private boolean depthBoundedDFS( TreeNode root, int depthBound ) {
        System.out.print( root.getData() + " ");
        if ( depthBound == 0 && isGoal(root) ) {
            return true;
        }
        if(depthBound > 0 )
            for ( TreeNode child : root.getChildren() ) {
                if( depthBoundedDFS(child, depthBound-1) ) {
                    return true;
                }
            }
        return false;
    }

    private boolean isGoal(TreeNode node) {
        return node.getData() == getPosition();
    }

    private void createID() {
        this.ID = ( position * 100 ) + depth ;
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


    public static void main(String[]args){
        GeneralFullTree t = new GeneralFullTree(2, 3);
        System.out.println(t.getPosition());

        System.out.print("finito: " + t.IterativeDeepeningDFS() );
    }
}
