import java.util.*;


/**
 * Created by Sena on 5.04.2017.
 */

public class Driver {

    public static final int SIZE = 100;

    private static GeneralFullTree createRandomGeneralTree(int branch, Queue<TreeNode> queue) {

        int depth = 6 + (int)(Math.random() * 5);

        return (new GeneralFullTree(branch, depth, queue) );
    }

    public static void main(String[] args) {
        Queue<TreeNode> queue = new ArrayDeque<>(13000000);


        // for binary trees
        HashSet<GeneralFullTree> BinaryTreesSet = new HashSet<>();

        while (BinaryTreesSet.size() < SIZE) {
            GeneralFullTree tree = createRandomGeneralTree( 2, queue );
            BinaryTreesSet.add(tree);
        }

        System.out.println("Done with binary trees.");

        // for ternary trees
        HashSet<GeneralFullTree> TernaryTreesSet = new HashSet<>();

        while (TernaryTreesSet.size() < SIZE) {
            GeneralFullTree tree = createRandomGeneralTree( 3, queue );
            TernaryTreesSet.add(tree);
        }

        System.out.println("Done with ternary trees.");



        // DFS
        System.out.println("DFS for BT");
        for( GeneralFullTree bt : BinaryTreesSet ) {
            long startTime = System.nanoTime();
            bt.depthFirstSearch();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with DFS for BT");


        // IDDFS
        System.out.println("IDS for BT");
        for( GeneralFullTree bt : BinaryTreesSet ) {
            long startTime = System.nanoTime();
            bt.IterativeDeepeningDFS();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with IDS for BT");


        // DFS
        System.out.println("DFS for TT");
        for( GeneralFullTree tt : TernaryTreesSet ) {
            long startTime = System.nanoTime();
            tt.depthFirstSearch();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with DFS for TT");

        // IDDFS
        System.out.println("IDS for TT");
        for( GeneralFullTree tt : TernaryTreesSet ) {
            long startTime = System.nanoTime();
            tt.IterativeDeepeningDFS();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with IDS for TT");

        // DFSaınt
        ArrayList <Integer> visited = new ArrayList<Integer>(100);
        int k  = 0;
        System.out.println(" QT");
        while(visited.size() < 100) {
            GeneralFullTree tree = createRandomGeneralTree( 5, queue );

            if(!visited.contains(tree.getID())) {
               visited.add(tree.getID());
                long startTime = System.nanoTime();
                tree.depthFirstSearch();
                //the fisrt col is for dfs

                System.out.print((System.nanoTime() - startTime)+ " ");
                startTime = System.nanoTime();
                tree.IterativeDeepeningDFS();
                // second col is for ıddfs
                System.out.print((System.nanoTime() - startTime));
                System.out.println();
            }
        }
        System.out.println("done with everyhing");
    }
}
