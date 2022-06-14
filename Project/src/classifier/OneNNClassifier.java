package col106.bigassignment.classifier;

import java.io.DataInputStream;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import col106.bigassignment.index.DistanceFunction;
import col106.bigassignment.index.L2Dist;
import col106.bigassignment.index.VPTreeImpl;
import col106.bigassignment.index.MNIST_Image;

public class OneNNClassifier implements Classifier  {
	public VPTreeImpl vp ;
	public ArrayList<MNIST_Image> c;
	
//	public static void main(String[] args) throws IOException {
//		double d= System.currentTimeMillis();
//		OneNNClassifier o= new OneNNClassifier();
//		o.train(this.c);
//		double r=System.currentTimeMillis();
//		
//		o.test(null);
//		
//		double f= System.currentTimeMillis();
//		System.out.println(r-d);
//		System.out.println(f-r);
//		
//	}
	public OneNNClassifier() throws IOException{
		// TODO Auto-generated constructor stub
		
		c=new ArrayList<MNIST_Image>();
		FileInputStream f = new FileInputStream("col106/bigassignment/Data/train_images");
		DataInputStream in = new DataInputStream(f);
		FileInputStream f1 = new FileInputStream("col106/bigassignment/Data/train_labels");
		DataInputStream in1 = new DataInputStream(f1);
		int m= in.readInt();
		int m1=in1.readInt();
		int num_images=in.readInt();
		int num_labels=in1.readInt();
		int r= in.readInt();
		int c= in.readInt();
		for( int s=0;s<num_images;s++) {
			int[][] temp= new int[r][c];
			for (int i=0;i<r;i++) {
				for (int j=0;j<c;j++) {
					temp[i][j]=in.readUnsignedByte();
				}
			}
			//System.out.println(s);
			//System.out.println(temp[14][14]);
			MNIST_Image im=new MNIST_Image(temp,s);
			im.label=in1.readUnsignedByte();
			this.c.add(im);
			
		}
		in.close();
		in1.close();
		
	}
	@Override
	public void train(Collection<MNIST_Image> trainingSet) {
		// TODO Auto-generated method stub
		vp = new VPTreeImpl(trainingSet,(DistanceFunction) new L2Dist());////Can change to L1Dist() or LinfDist()
		vp.root=vp.create_vp(vp.c);
		
		
		
	}
	@Override
	public void test(Collection<MNIST_Image> testSet) {
		// TODO Auto-generated method stub
		
//		for (int i=0;i<28;i++) {
//			for (int j=0;j<28;j++) {
//				System.out.print(test[i][j]+" "+ vp.best[i][j]);
//			}
//			System.out.println();
//		}
//		ArrayList<Integer> r= new ArrayList<Integer>();
//		for(MNIST_Image i:c) {
//		System.out.println(i.getIndexFromTrainingSet());	
//		MNIST_Image d=this.vp.findOneNN(i);	
//		if(Arrays.deepEquals(i.img, d.img)) {
//			r.add(1);
//		}
//		}
//		System.out.println(r.size());
//	
	}
	
	@Override
	public void printAccuracy() {
		// TODO Auto-generated method stub
		
	}
	public Collection<MNIST_Image> predict(Collection <MNIST_Image> images){
		ArrayList<MNIST_Image> imgs= (ArrayList<MNIST_Image>) images;
		Collection<MNIST_Image> preds = new ArrayList<MNIST_Image>();
		for (MNIST_Image img : imgs) {
			
			preds.add(vp.findOneNN(img));
		}
		return preds;
		
	}
	public VPTreeImpl getvptree() {
		return this.vp;
	}
	
	
}
