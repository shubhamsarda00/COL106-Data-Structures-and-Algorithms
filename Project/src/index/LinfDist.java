package col106.bigassignment.index;

public class LinfDist<T> implements DistanceFunction {

	@Override
	public double distance(MNIST_Image one, MNIST_Image two) {
		// TODO Auto-generated method stub
		int[][] a= one.img;
		int[][] b=  two.img;
		double d=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				d=Math.max(d, Math.abs((a[i][j]-b[i][j])));
			}
		}
		return d;
	}

}
