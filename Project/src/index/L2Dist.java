package Project.src.index;

public class L2Dist <T> implements DistanceFunction{

	@Override
	public double distance(MNIST_Image one, MNIST_Image two) {
		// TODO Auto-generated method stub
		int[][] a= one.img;
		int[][] b=  two.img;
		double d=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				d+=(a[i][j]-b[i][j])*(a[i][j]-b[i][j]);
			}
		}
		return Math.sqrt(d);
	}


}
