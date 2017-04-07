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

    public void depthFirstSearch(int key){

        // int nodeCount = (int) (Math.pow(branch_f, depth + 1) - 1) / (branch_f - 1);
        ArrayList<TreeNode> queue = new ArrayList<>();
        boolean found;
        found = false;
        queue.add(root);
       while(!queue.isEmpty()){
            TreeNode expand = queue.get(0);
            queue.remove(0);
            if(expand.getData() == key){
                System.out.print("found");
                found = true;
                break;
            }
            else {
                if(expand.getChildren().size() > 0) {
                    for (int j = branch_f - 1; j >= 0; j--) {
                            queue.add(0, expand.getChildren().get(j));
                    }
                }
            }
        }
        if(!found)
            System.out.println("Not found");
    }
}
