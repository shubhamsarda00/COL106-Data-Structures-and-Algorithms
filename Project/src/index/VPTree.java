package col106.bigassignment.index;

import java.util.Collection;

public abstract class VPTree {
	// Create VPTree from collection based on the DistanceFunction d
    public VPTree (Collection <MNIST_Image> collection, DistanceFunction  d) {}
    public abstract String toString();
    public abstract  DistanceFunction getDistanceFunc (); //return the distance function being used in this index
    public abstract  MNIST_Image findOneNN (MNIST_Image q); //should print root-leaf pivots
    public abstract void printTree(); //print four lines: pivot, root, left subtree collection, right subtree collection
}
