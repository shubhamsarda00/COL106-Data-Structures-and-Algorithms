package col106.bigassignment.index;

//
// Implement this interface on specific distance functions
// such as L1, L2, Linf distances
// 
public interface DistanceFunction   {
    double distance(MNIST_Image one, MNIST_Image two); // returns L1, L2 or L∞ distance
}
