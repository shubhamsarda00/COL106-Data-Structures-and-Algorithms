
public class SparseTwoDBlockMatrix extends TwoDBlockMatrix{
	public SparseTwoDBlockMatrix(float[][] array) {
		super(array);
	}
	public static SparseTwoDBlockMatrix buildTwoDBlockMatrix(java.io.InputStream in) throws java.io.IOException, java.lang.NumberFormatException{
		TwoDBlockMatrix temp=TwoDBlockMatrix.buildTwoDBlockMatrix(in);
		SparseTwoDBlockMatrix s= new SparseTwoDBlockMatrix(temp.array);
		return s;
	}
	public SparseTwoDBlockMatrix transpose() {
		float[][] f=this.array;
		int r=0;
		int c=0;
		r=f.length;
		c=f[0].length;
		float[][] t=new float[c][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				t[j][i]=f[i][j];
			}
		}
		SparseTwoDBlockMatrix trans=new SparseTwoDBlockMatrix(t);
		return trans;
	}
	public SparseTwoDBlockMatrix multiply ( SparseTwoDBlockMatrix other) throws IncompatibleDimensionException{
		TwoDBlockMatrix d=new TwoDBlockMatrix(this.array);
		TwoDBlockMatrix f=new TwoDBlockMatrix(other.array);
		TwoDBlockMatrix temp=d.multiply(f);
		SparseTwoDBlockMatrix s= new SparseTwoDBlockMatrix(temp.array);
		return s;
	}
	public SparseTwoDBlockMatrix getSubBlock ( int row_start, int col_start, int row_end, int col_end) throws SubBlockNotFoundException{
		TwoDBlockMatrix d=new TwoDBlockMatrix(this.array);
		TwoDBlockMatrix temp=d.getSubBlock(row_start, col_start, row_end, col_end);
		SparseTwoDBlockMatrix s= new SparseTwoDBlockMatrix(temp.array);
		return s;
	}
	public SparseTwoDBlockMatrix inverse () throws InverseDoesNotExistException{
		TwoDBlockMatrix d=new TwoDBlockMatrix(this.array);
		TwoDBlockMatrix temp=d.inverse();
		SparseTwoDBlockMatrix s= new SparseTwoDBlockMatrix(temp.array);
		return s;
	}
}
