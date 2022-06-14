package Project.src.index;

public class MNIST_Image {
	public int[][] img;
	public int index;
	public int label=0;
	public MNIST_Image(int[][] t, int i) {
		img=t;
		index=i;
		
	}
	public int getIndexFromTrainingSet() {
		return index;
	}
	
	
}
