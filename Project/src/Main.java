package col106.bigassignment;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



import col106.bigassignment.classifier.OneNNClassifier;
import col106.bigassignment.index.MNIST_Image;
import col106.bigassignment.index.VPTreeImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Collection<MNIST_Image> collection=new ArrayList<MNIST_Image>();
		FileInputStream f = new FileInputStream(args[0]);
		DataInputStream in = new DataInputStream(f);
		//FileInputStream f1 = new FileInputStream("test_labels");
		//DataInputStream in1 = new DataInputStream(f1);
		int m= in.readInt();
		//int m1=in1.readInt();
		int num_images=in.readInt();
		//int num_labels=in1.readInt();
		int r= in.readInt();
		int c= in.readInt();
		for( int s=0;s<num_images;s++) {
			int[][] temp= new int[r][c];
			for (int i=0;i<r;i++) {
				for (int j=0;j<c;j++) {
					temp[i][j]=in.readUnsignedByte();
				}
			}
			
			MNIST_Image im=new MNIST_Image(temp,-1);
			//im.label=in1.readUnsignedByte();
			collection.add(im);
	
		}
		//in1.close();
		in.close();
		//double t1= System.currentTimeMillis();
		OneNNClassifier knn= new OneNNClassifier();
		
		knn.train(knn.c);
		//double t2=System.currentTimeMillis();
		VPTreeImpl vp=knn.getvptree();  ///Tree corresponding to the classifier
		
		Collection<MNIST_Image> output= knn.predict(collection) ; //Collection of Preds
		//double t3=System.currentTimeMillis();
		ArrayList<MNIST_Image> preds=new ArrayList<MNIST_Image>(); //ArrayList of Preds
		
		for (MNIST_Image t:output) {
			preds.add(t);
		}
		//System.out.println(t2-t1);
		//System.out.println(t3-t2);
	}

}
