import java.util.ArrayList;

/**
 * Created by Sena on 5.04.2017.
 */

public class Driver {

    public static GeneralFullTree createRandomGeneralTree( int branch ) {



        int depth = (int) (Math.random() * 3 + 5);
        int position = (int) (Math.random() * ( Math.pow(branch, depth)  + 1 ) );

        return (new GeneralFullTree(branch, depth, position) );
    }

    public static void main(String[] args) {

        // for binary trees
        ArrayList<GeneralFullTree> BinaryTrees = new ArrayList<GeneralFullTree>();
        while (BinaryTrees.size() <= 100) {
            GeneralFullTree tree = createRandomGeneralTree( 2 );

            boolean same = false;
            for ( GeneralFullTree bt : BinaryTrees ) {
                if( tree.getID() == bt.getID())
                    same = true;
            }

            if(!same)
                BinaryTrees.add(tree);

        }

        // for ternary trees
        ArrayList<GeneralFullTree> TernaryTrees = new ArrayList<GeneralFullTree>();
        while (TernaryTrees.size() <= 100) {
            GeneralFullTree tree = createRandomGeneralTree( 3 );

            boolean same = false;
            for ( GeneralFullTree tt : TernaryTrees ) {
                if( tree.getID() == tt.getID())
                    same = true;
            }

            if(!same)
                TernaryTrees.add(tree);

        }


        // for quinary trees
        ArrayList<GeneralFullTree> QuinaryTrees = new ArrayList<GeneralFullTree>();
        while (QuinaryTrees.size() <= 100) {
            GeneralFullTree tree = createRandomGeneralTree( 5 );

            boolean same = false;
            for ( GeneralFullTree qt : QuinaryTrees ) {
                if( tree.getID() == qt.getID())
                    same = true;
            }

            if(!same)
                QuinaryTrees.add(tree);

        }




    }
}
