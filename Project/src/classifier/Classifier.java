package col106.bigassignment.classifier;

import java.util.Collection;
import col106.bigassignment.index.MNIST_Image;
public interface Classifier {
	public void train (Collection<MNIST_Image> trainingSet);
	public void test (Collection<MNIST_Image> testSet);
	public void printAccuracy ();
	
}
