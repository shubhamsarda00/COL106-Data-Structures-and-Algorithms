package Project.src.index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;



public final class VPTreeImpl extends VPTree {
	
	public double tau;
	public MNIST_Image best;
	public Node root;
	public ArrayList<MNIST_Image> c;
	//public ArrayList<Integer> i;
	DistanceFunction d;
	public VPTreeImpl(Collection<MNIST_Image> collection, DistanceFunction d) {
		super(collection, d);
		// TODO Auto-generated constructor stub
		c=(ArrayList<MNIST_Image>) collection;
		this.d=d;
		root= null;
		//i=new ArrayList<Integer>();
	}
	//public static void main(String[] args) {
		//ArrayList<int[][]> collection = new ArrayList<int[][]>();
//		int[][] a1= new int[1][1];
//		a1[0][0]=1;
//		collection.add(a1);
//		int[][] a2= new int[1][1];
//		a2[0][0]=3;
//		collection.add(a2);
//		int[][] a3= new int[1][1];
//		a3[0][0]=10;
//		collection.add(a3);
//		int[][] a4= new int[1][1];
//		a4[0][0]=18;
//		collection.add(a4);
//		int[][] a5= new int[1][1];
//		a5[0][0]=68;
//		collection.add(a5);
//		int[][] a6= new int[1][1];
//		a6[0][0]=26;
//		collection.add(a6);
//		int[][] a7= new int[1][1];
//		a7[0][0]=34;
//		collection.add(a7);
//		for(int i=0;i<100;i++) {
//			int[][] a1= new int[1][1];
//			a1[0][0]=i;
//			collection.add(a1);
//		}
		
//		VPTreeImpl<int[][]> vp= new VPTreeImpl<int[][]>(collection, new L2Dist<int[][]>());
//		vp.root=vp.create_vp(vp.c);
//		vp.tau=Integer.MAX_VALUE;
//		vp.best=null;
//		int[][] a7= new int[1][1];
//		a7[0][0]=34;
//		vp.search(vp.root,a7 );
//		int[][] s=vp.best;
//		System.out.println(s[0][0]);
//	}
	private class Node{
		MNIST_Image val;
		Node l;
		Node r;
		ArrayList<Double> bounds;
		public Node(MNIST_Image val,Node l,Node r, ArrayList<Double> d) {
			this.l=l;
			this.r=r;
			this.bounds=d;
			this.val=val;
		}
		
		
	}
	
	private class item{
		MNIST_Image val;
		ArrayList<Double> hist;
		public item(MNIST_Image val, ArrayList<Double> d) {
			this.val=val;
			this.hist=d;	
		}
		public boolean equals(Object o) {
			item i=(item) o;
			int[][] tv= this.val.img;
			int[][] iv= i.val.img;
			return Arrays.deepEquals(tv, iv);
			
		}
		
	}
	public Node create_vp(ArrayList<MNIST_Image> data){
		ArrayList<item> items=new ArrayList<item>();
		for( MNIST_Image image : data) {
			
			items.add(new item(image, new ArrayList<Double>()));
		}
		//System.out.println(items.size());
		return create_vp_helper(items,0);
		
	}
	public Node create_vp_helper(ArrayList<item> items,int bn){
		if(items==null || items.size()==0) {
			
			return null;
		}
		bn++;
		//System.out.println("bn="+bn);
		
		Node n=new Node(null,null,null, new ArrayList<Double>());
		//if(bn==1) {
		//	this.root=n;
			
		//}
		// We get the data point of highest distance variance among a random set of points chosen from items list 
		
		item t=get_vantage_point(items);
		//int[][] ry=(int[][])t.val;
		//System.out.println(ry[0][0]);
		n.val=t.val;
		items.remove(new item(n.val, null));
		
		ArrayList<Double> a=new ArrayList<Double>(); 
		//System.out.println(items.size());
		if(items.size()>0) {
		for(item i:items) {
			double dist=getDistanceFunc().distance(n.val,i.val);
			//System.out.println(dist);
			i.hist.add(dist);
			//sortedadd(i.hist, dist);
			a.add(dist);
			//sortedadd(a,dist);
			
		}
		double mu=getmedian(a);
		//System.out.println(mu);
		ArrayList<item> Left=new ArrayList<item>();
		ArrayList<item> Right=new ArrayList<item>();
		//System.out.println(items.size());
		int k= items.size();
		for(int i=0;i<k ;i++) {
				item p=items.get(i);
				//System.out.println(i);
				//System.out.println(6);
				if(p.hist.get(p.hist.size()-1)<mu) {
					Left.add(p);	
					//System.out.println(3);
				}
				else {
					//System.out.println(7);
					Right.add(p);
				}
				//items.remove(i);
			}
		n.l=create_vp_helper(Left,bn);
		n.r=create_vp_helper(Right,bn);
		//if(items.size()==1) {
			//n.bounds=t.hist;
			//}
		//else {
			if(n.l==null) {
				n.bounds=getbounds(null, n.r.bounds, t.hist);
			}
			else {
			n.bounds=getbounds(n.l.bounds, n.r.bounds,t.hist );
			}
		}
		else {
			//System.out.println(8);
			n.r=null;
			n.l=null;
			//System.out.println(t.hist.get(0));
			n.bounds=getbounds(null, null, t.hist);
			//System.out.println(n.bounds.get(1));
		}
		
		
		return n;
	}
	
	public ArrayList<Double> getbounds(ArrayList<Double> l,ArrayList<Double> r,ArrayList<Double> m ){
//		ArrayList<Double> merged=new ArrayList<Double>();
//		int l1=0;
//		int r1=0;
//		if(l==null && r==null) {
//			return m;
//		}
//		if(l==null) {
//			ArrayList<Double> finall = new ArrayList<Double>();
//			int m1=0;
//			int f1=0;
//			while(m1<m.size() && f1<r.size()) {
//				if(m.get(m1)<r.get(f1)) {
//					finall.add(m.get(m1));
//					m1++;
//				}
//				else {
//					finall.add(r.get(f1));
//					f1++;
//				}
//			}
//			while(m1<m.size()) {
//				finall.add(m.get(m1));
//				m1++;
//			}
//			while(f1<r.size()) {
//				finall.add(r.get(f1));
//				f1++;
//			}
//			
//			return finall;
//		}
//		while(l1<l.size() &&r1<r.size()) {
//			if(l.get(l1)<r.get(r1)) {
//				merged.add(l.get(l1));
//				l1++;
//			}
//			else {
//				merged.add(r.get(r1));
//				r1++;
//			}
//		}
//		while(l1<l.size()) {
//			merged.add(l.get(l1));
//			l1++;
//		}
//		while(r1<r.size()) {
//			merged.add(r.get(r1));
//			r1++;
//		}
//		ArrayList<Double> finall = new ArrayList<Double>();
//		int m1=0;
//		int f1=0;
//		while(m1<m.size() && f1<merged.size()) {
//			if(m.get(m1)<merged.get(f1)) {
//				finall.add(m.get(m1));
//				m1++;
//			}
//			else {
//				finall.add(merged.get(f1));
//				f1++;
//			}
//		}
//		while(m1<m.size()) {
//			finall.add(m.get(m1));
//			m1++;
//		}
//		while(f1<merged.size()) {
//			finall.add(merged.get(f1));
//			f1++;
//		}
//		
//		return finall;
		ArrayList<Double> b=new ArrayList<Double>();
		double max=Integer.MIN_VALUE;
		double min=Integer.MAX_VALUE;
		if(l!=null) {
			for(double d:l) {
				if(d<min) {
					min=d;
				}
				if(d>max) {
					max=d;
				}
			}
		}
		if(r!=null) {
			for(double d:r) {
				if(d<min) {
					min=d;
				}
				if(d>max) {
					max=d;
				}
			}
		}
		if(m!=null) {
			for(double d:m) {
				//System.out.println(d);
				if(d<min) {
					//System.out.println(d+"69");
					min=d;
				}
				if(d>max) {
					//System.out.println(d);
					max=d;
				}
			}
		}
		b.add(min);
		b.add(max);
		return b; 
	}
	public item get_vantage_point(ArrayList<item> items) {
		
		//int[][] r=(int[][])items.get(items.size()/2).val;
		//System.out.println("R"+r[0][0]);
		//return items.get(new Random().nextInt(items.size()));
		int num=0;
		if(items.size()>57) {
			num=56;
		
		}
		else {
			num=items.size();
		}
		ArrayList<item> sample =new ArrayList<item>();
		Random r= new Random();
		for(int i=0;i<num;i++) {
			sample.add(items.get(r.nextInt(items.size())));
			
		}
		item best=null;
		double d=-1;
		
		for(item i:sample) {
			ArrayList<Double> t=new ArrayList<Double>();
			ArrayList<item> sample1 =new ArrayList<item>();
			//Random r1= new Random();
			
			for(int i1=0;i1<num;i1++) {
				sample1.add(items.get(r.nextInt(items.size())));
				
			}
			for(item it:sample1) {
				t.add(getDistanceFunc().distance(i.val, it.val));
				
			}
			
			// Quick select can be used to find median in expected O(n) 
			Collections.sort(t);
			double mu=t.get(t.size()/2);
			double moment=0;
			for(double f:t) {
				moment+=(f-mu)*(f-mu);
			}
			if(moment>d) {
				best=i;
				d=moment;
			}
		}
		return best;
		//return items.get(items.size()/2);
		
	}
	public Double getmedian(ArrayList<Double> a) {
		
		ArrayList<Double> d= new ArrayList<Double>();
		Random r= new Random();
		int num=0;
		if(a.size()>56) {
			num=56;
		}
		else {
			num=56;
		}
		for(int i=0;i<num;i++) {
			d.add(a.get(r.nextInt(a.size())));
			
		}
		Collections.sort(d);
		// Quick select can be used to find median in expected O(n) 
		if(d.size()%2==0) {
			return (d.get((d.size()-1)/2)+d.get(d.size()/2))/2;
		}
		else {
			return d.get((d.size()-1)/2);
		}
	
	}
	public void sortedadd(ArrayList<Double> a, Double b) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i)<b) {
				continue;
			}
			else {
				a.add(i, b);
				return;
			}
				
		}
		a.add(b);
	}
	//before searching set tau to infinity and best to null
	public void search(Node n, MNIST_Image q) {
		if(n==null) {
			
			return;
		}
		double dist=getDistanceFunc().distance(n.val, q);
		//System.out.println(dist);
		if(dist<tau  ) {
			//System.out.println(n.val);
			
			tau=dist;
			best=n.val;
		}
		//System.out.println(n.l.bounds.get(1));
		//System.out.println(n.r.bounds.get(0));
		if(n.l!=null && n.r!=null) {
		double mid=(n.l.bounds.get(1)+n.r.bounds.get(0))/2;
		
		if (dist< mid) {
			if(dist>n.l.bounds.get(0)-tau && dist<n.l.bounds.get(1)+tau) {
				search(n.l, q);
			}
			 if(dist>n.r.bounds.get(0)-tau && dist<n.r.bounds.get(1)+tau) {
				search(n.r,q);
			}
		}
		else {
			if(dist>n.r.bounds.get(0)-tau && dist<n.r.bounds.get(1)+tau) {
				search(n.r,q);
			}
			 if(dist>n.l.bounds.get(0)-tau && dist<n.l.bounds.get(1)+tau) {
				search(n.l, q);
			}
			
		}
		}
		else if(n.l==null) {
			search(n.r,q);
		}
		else {
			return;
		}
		
		
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MNIST_Image findOneNN(MNIST_Image q) {
		// TODO Auto-generated method stub
		this.tau=Integer.MAX_VALUE;
		this.best=null;
		
		this.search(this.root, q);
		return this.best;
		
	}

	@Override
	public void printTree() {
		// TODO Auto-generated method stub
		preorder(this.root);
		
	}
	public void preorder(Node n) {
		if(n==null) {
			return;
		}
		System.out.println(n.val.index);
		//i.add(n.val.index);
		preorder(n.l);
		preorder(n.r);
		
	}

	@Override
	public  DistanceFunction getDistanceFunc() {
		// TODO Auto-generated method stub
		return  d;
		//return new L2Dist<T>();
		
	}
	
	

}
