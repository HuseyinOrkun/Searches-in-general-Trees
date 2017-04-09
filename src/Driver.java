import java.util.*;


/**
 * Created by Sena on 5.04.2017.
 */

public class Driver {

    public static final int SIZE = 1;

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

        // for quinary trees
        HashSet<GeneralFullTree> QuinaryTreesSet = new HashSet<>();

        while (QuinaryTreesSet.size() < SIZE) {
            GeneralFullTree tree = createRandomGeneralTree( 5, queue );
            QuinaryTreesSet.add(tree);
        }

        System.out.println("Done with quinary trees.");


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

        // DFS
        System.out.println("DFS for QT");
        for( GeneralFullTree qt : QuinaryTreesSet ) {
            long startTime = System.nanoTime();
            qt.depthFirstSearch();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with DFS for QT");

        // IDDFS
        System.out.println("IDS for QT");
        for( GeneralFullTree qt : QuinaryTreesSet ) {
            long startTime = System.nanoTime();
            qt.IterativeDeepeningDFS();
            System.out.println( System.nanoTime() - startTime );
        }

        System.out.println("Done with IDS for QT");
    }
}
