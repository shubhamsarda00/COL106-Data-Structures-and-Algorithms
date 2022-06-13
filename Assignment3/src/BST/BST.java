package Assignment3.src.BST;
import java.util.LinkedList;

public class BST<T, E extends Comparable> implements BSTInterface<T, E>  {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	public static void main() {

		//BST<Integer,Integer> b=new BST<Integer, Integer>();
		/*for(int i=0;i<1000;i++) {
		b.insert(i, i);
		}
		for(int i=0;i<800;i++1) {
			b.delete( i);
			}
		b.printBST();*/
		/*b.insert(1, 1);
		b.insert(3, 3);
		b.insert(2, 2);
		b.insert(5, 5);
		b.delete(3);
		b.insert(4, 4);
		
		b.insert(0,0);
		b.insert(-2, -2);
		
		//b.insert(6, 6);
		//b.delete(1);
		//b.delete(6);
		b.delete(-2);
	
		b.printBST();*/
		//BST<Integer,Integer> b=new BST<Integer, Integer>();
		//for(int i=0;i<10000;i++) {
		//b.insert(10000-i,10000- i);
		//}
		//b.delete(1000);
		//b.printBST();
	}
	/*
	 * end code
	 * start writing your code from here
	 */
	
	//write your code here 
	public class node{
		private T key;
		private E value;
		private node parent;
		private node left;
		private node right;
		public node(node p, node l,node r,T k,E v) {
			this.key=k;
			this.value=v;
			this.parent=p;
			this.left=l;
			this.right=r;
			if(left!=null) left.parent=this;
			if (right!=null) right.parent=this;
		}
	}	
	private int size=0;
	private node root;
	public BST() {
		root=new node(null,null,null,null,null);
		
	}
	public node root() {
		return root;
	}
	public T getkey(node n) {
		return n.key;
	}
	public node left(node n) {
		return n.left;
	}
	public node right(node n) {
		return n.right;
	}
	
	public E getvalue(node n) {
		return n.value;
	}
	public boolean isexternal(node n) {
		return (n.left==null && n.right==null);
	}
	private boolean isroot(node n) {
		return n.parent==null;
	}
	public boolean isempty() {
		return this.size==0;
	}
	
	
	private node searchv(node n,E val) {
		if (isexternal(n)||n.value.equals(val)) {
			return n;
		}
		else if(val.compareTo(n.value)>0) {
			if(n.right!=null)return searchv(n.right,val);
			else return n;
		}
		else {
			if(n.left!=null) {
			return searchv(n.left,val);
			}
			else {
				return n;
			}
		}
		
		
	}
	public node searchk(node n, T key) {
		//node k=new node(null,null,null,null,null);
		//return intsearchk(k,n,key,false,null);
		return intsearchk(key);
		
		
	}
	private node intsearchk(T key) {
		/*if(check) {
			return temp;
		}
		if(n.left!=null) {
			intsearchk(k,n.left,key,false,temp);
		}
		
		if(n.key.equals(key)) {
			//k.left=n.left;k.right=n.right;k.parent=n.parent;k.key=n.key;k.value=n.value;
			check = true;
			temp = n;
			//return;
		}
		
		if(n.right!=null) {
			intsearchk(k,n.right, key, false, temp);
		}
		if(check) {
			return temp;
		}
		return null;
			*/
		LinkedList<node> q = new LinkedList<node>(); 
        q.add(root); 
        
    	while(q.size()!=0) {
    		node temp=q.poll();
    		
    		if(temp.key.equals(key)) {
    			
    			return temp;}
    		if(temp.left!=null) {
    			q.add(temp.left);
    		}
    		if(temp.right!=null) {
    			q.add(temp.right);
    		}
    	}
    	return null;
	}
	
    public void insert(T key, E value) {
		//write your code here
    	if(size!=0) {
    	node n=searchv(this.root,value);
    	//System.out.println("Inserting -2: "+(n==this.root));
    	if(isexternal(n)) {
    		node t=new node(n,null,null,key,value);
    	//	System.out.println("In insert - "+t);
    		if(value.compareTo(n.value)>0) {
    			n.right=t;
    		}
    		else {
    			n.left=t;
    		}
    		size++;
    		//System.out.println("Left - "+n.left.value);
    		return;
    	}
    	else if(n.right==null) {
    		node t=new node(n,null,null,key,value);
    		n.right=t;
    		size++;
    		return;
    	}
    	else {
    		node t=new node(n,null,null,key,value);
    		n.left=t;
    		size++;
    		return;
    	}
    	}
    	else{
    		//ch1
    		root.key=key;
    		root.value=value;
    		size++;
    		
    	}
    }

    public void update(T key, E value) {
		//write your code here
    	delete(key);
    	insert(key,value);
    	
    }

    public void delete(T key) {
		//write your code here
    
    	if(size==1) {
    		root=new node(null,null,null,null,null);
    		
    	}
    	else {
    		node n=searchk(this.root,key);
    		
    		//.out.println("n - "+n);
    		//System.out.println("n parent = "+n.parent+"\tvalue - "+n.parent.value+"\tn left - "+n.left+"\t n right - "+n.right+"\tn value - "+n.value);
    		if(isexternal(n)) {
    			node p=n.parent;
    		//	System.out.println("n parent - "+p+"\t left - "+p.left+"\t right - "+p.right);
    			if(p.left==n) {
    				p.left=null;
    				
    			}
    			else if(p.right==n){
    				p.right=null;
    			}
    			else {
        			//System.out.println("Right here!");
    				//p.right=null;
    			}
    			n=null;
    		}
    		
    		else if(n.left==null){
    			if(!isroot(n)) {
    			
    			node r=n.right;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			n=null;
    			r.parent=p;
    			}
    			else {
    				this.root=n.right;
    				n.right.parent=null;
    				
    				n=null;
    		
    				
    			}
    		}
    		else if(n.right==null){
    			if(!isroot(n)) {
    			node r=n.left;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			n=null;
    			r.parent=p;
    			}
    			else {
    				root=n.left;
    				n=null;
    				root.parent=null;
    			}
    		}
    		else {
    	
    			node successor=null;
    			
    			node r=n.right;
    			r.parent=n;
    			while(r.left!=null) {
    				r=r.left;
    			}
    			successor=r;
    			
    			if(!isroot(n)) {
    			boolean r1=true;
    			node p1= n.parent;
    			if(p1.left==n) {
    				r1=false;
    			}
    			
    			n.value=r.value;
    			n.key=r.key;
    		
    			if(r1) {
    				n.parent.right=n;
    			}
    			else { n.parent.left=n;}
    			
    			r.key=null;
    			r.value=null;
    			
    			}
    			else {
    				n.value=r.value;
        			n.key=r.key;
        			root=n;
    			}
    			
    			if(r.right!=null) {
    			
    			node rr=r.right;
    			
    			node pp= r.parent;
    			
    			
    			if(pp.left==r) {
    				pp.left=rr;
    			}
    			else {
    				pp.right=rr;
    			}
    			
    			r=null;
    			rr.parent=pp;
    			
    			}
    			else {
    				
    				node p=r.parent;
    				
    				if(p.left==r) {
        				p.left=null;
        			}
        			else {
        				p.right=null;
        			}
    				r=null;
    				
        			
    			}
    		}
    	}
    	size--;
    }
    public void deletev(E value) {
    	if(size==1) {
    		root=new node(null,null,null,null,null);
    		
    	}
    	else {
    		node n=searchv(this.root,value);
    		if(isexternal(n)) {
    			node p=n.parent;
    		//	System.out.println("n parent - "+p+"\t left - "+p.left+"\t right - "+p.right);
    			if(p.left==n) {
    				p.left=null;
    				
    			}
    			else if(p.right==n){
    				p.right=null;
    			}
    			else {
        			//System.out.println("Right here!");
    				//p.right=null;
    			}
    			n=null;
    		}
    		
    		else if(n.left==null){
    			if(!isroot(n)) {
    			
    			node r=n.right;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			n=null;
    			r.parent=p;
    			}
    			else {
    				this.root=n.right;
    				n.right.parent=null;
    				
    				n=null;
    		
    				
    			}
    		}
    		else if(n.right==null){
    			if(!isroot(n)) {
    			node r=n.left;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			n=null;
    			r.parent=p;
    			}
    			else {
    				root=n.left;
    				n=null;
    				root.parent=null;
    			}
    		}
    		else {
    	
    			node successor=null;
    			
    			node r=n.right;
    			r.parent=n;
    			while(r.left!=null) {
    				r=r.left;
    			}
    			successor=r;
    			
    			if(!isroot(n)) {
    			boolean r1=true;
    			node p1= n.parent;
    			if(p1.left==n) {
    				r1=false;
    			}
    			
    			n.value=r.value;
    			n.key=r.key;
    		
    			if(r1) {
    				n.parent.right=n;
    			}
    			else { n.parent.left=n;}
    			
    			r.key=null;
    			r.value=null;
    			
    			}
    			else {
    				n.value=r.value;
        			n.key=r.key;
        			root=n;
    			}
    			
    			if(r.right!=null) {
    			
    			node rr=r.right;
    			
    			node pp= r.parent;
    			
    			
    			if(pp.left==r) {
    				pp.left=rr;
    			}
    			else {
    				pp.right=rr;
    			}
    			
    			r=null;
    			rr.parent=pp;
    			
    			}
    			else {
    				
    				node p=r.parent;
    				
    				if(p.left==r) {
        				p.left=null;
        			}
        			else {
        				p.right=null;
        			}
    				r=null;
    				
        			
    			}
    		}
    	}
    	size--;
    }
    public E searchndel(T key) {
    	node t=searchk(root, key);
    	
    	delete(key);
 
    	return t.value;
    }

    public void printBST () {
		//write your code here
    	LinkedList<node> q = new LinkedList<node>(); 
        q.add(root); 
    	while(q.size()!=0) {
    		node temp=q.poll();
    		System.out.println(temp.key+", "+temp.value);
    		if(temp.left!=null) {
    			q.add(temp.left);
    		}
    		if(temp.right!=null) {
    			q.add(temp.right);
    		}
    	}
    }

}

















