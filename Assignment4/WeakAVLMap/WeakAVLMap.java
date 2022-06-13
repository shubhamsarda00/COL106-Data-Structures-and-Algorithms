package col106.assignment4.WeakAVLMap;
import java.util.LinkedList;
import java.util.Vector;

public class WeakAVLMap<K extends Comparable,V> implements WeakAVLMapInterface<K,V>{
	/*public static void main (String[] args) {
		WeakAVLMap<Integer, Integer> w=new WeakAVLMap<Integer, Integer>();
		
	w.put(30886, 92777);
		w.put(47793, 38335);
		w.put(60492, 16649);
		
		w.put(35000, 90027);
		w.remove(47793);
		System.out.println(w.root.key);*/
		/*w.put(20059, 97763);
		
		w.put(89172, 55736);
		//GET	
//56429
//GET
//60492
//BFS_ORDER
		w.remove(89172);
		

		//System.out.println(w.root.left.rank);
		w.put(33069, 98167);
		
		
		w.remove(47793);
		w.remove(84421);
		//System.out.println(w.root.rank);
		
//HEIGHT
//GET
//2362
//BFS_ORDER
		w.remove(2362);
		
		w.put(30886, 59956);
		//Vector b=w.BFS();
		//System.out.println(w.get(30886));
//BFS_ORDER
//GET
//30886
//GET
//33069
//GET
//30886
//GET
//33069
//GET
//30886
//HEIGHT
//GET
//60492 
		//System.out.println(w.root.right.left.rank);
		w.remove(30886);
		Vector b=w.BFS();
		//w.remove(33069);
//GET
//20059
//GET
//60492
		//w.put(99932, 95060);
		//w.put(10012, 36226);
//GET
//10012
//HEIGHT
//HEIGHT
//GET
//66601
//ROTATE_COUNT
		//w.put(26652, 60756);
		//w.put(9441, 53865);
//GET
//9441
		//w.remove(8117);
//ROTATE_COUNT
//ROTATE_COUNT
//GET
//10012
		//w.put(26652, 79497);
		//w.put(55306, 64683);
//HEIGHT
//BFS_ORDER
		//w.put(26652, 48829);
		//w.put(10012, 63368);
//GET
//10012
//BFS_ORDER
//ROTATE_COUNT
//BFS_ORDER
		//w.remove(55306);
		//w.put(92379, 97488);
//GET
//92350
		//w.remove(9441);
//GET
//26652
//GET
//10012
		//w.remove(60492);
//GET
//99932
			//w.put(53275, 75407);
//BFS_ORDER
//ROTATE_COUNT
//GET
//53275
//GET
//92379
			//w.remove(31011);
			//w.put(22404, 64443);
//GET
//99932
//GET
//26652
			//w.remove(97369);
			//w.remove(22404);
//BFS_ORDER
		
		
		
		
		
		for(int i=0;i<b.size();i++) {
			System.out.println(b.get(i));
		}
		*/
	//}
	
	public class node{
		private K key;
		private V value;
		private node parent;
		private node left;
		private node right;
		private int rank=0;
		public node(node p, node l,node r,K k,V v) {
			this.key=k;
			this.value=v;
			this.parent=p;
			this.left=l;
			this.right=r;
			if(left!=null) left.parent=this;
			if (right!=null) right.parent=this;
		}
		
	}
	private void addext(node n) {
		n.left=new node(n,null,null,null,null);
		n.right=new node(n,null,null,null,null);
	}
	private int size=0;
	private node root;
	int rotatatecount=0;
	private int rankdiff(node n) {
		if(n.parent!=null) {
		return n.parent.rank-n.rank;}
		return -1;
	}
	private node root() {
		return root;
	}
	public K getkey(node n) {
		return n.key;
	}
	private node left(node n) {
		return n.left;
	}
	private node right(node n) {
		return n.right;
	}
	
	public V getvalue(node n) {
		return n.value;
	}
	private boolean isexternal(node n) {
		return (n.left==null && n.right==null);
	}
	private boolean isleaf(node n) {
		return isexternal(n.left) && isexternal(n.right);
	}
	private boolean isroot(node n) {
		return n.parent==null;
	}
	public boolean isempty() {
		return this.size==0;
	}
	public WeakAVLMap(){
		// write your code here
		root=new node(null,null,null,null,null);
	}
	private node intsearchv(V val) {
		LinkedList<node> q = new LinkedList<node>(); 
        q.add(root); 
        
    	while(q.size()!=0) {
    		node temp=q.poll();
    		
    		if(temp.value.equals(val)) {
    			
    			return temp;}
    		if(temp.left.rank!=0) {
    			q.add(temp.left);
    		}
    		if(temp.right.rank!=0) {
    			q.add(temp.right);
    		}
    	}
    	return null;
	}
	private node searchk(node n,K k) {
		if (isleaf(n)||n.key.equals(k)) {
			return n;
		}
		else if(k.compareTo(n.key)>0) {
			if(n.right.rank!=0)return searchk(n.right,k);
			else return n;
		}
		else {
			if(n.left.rank!=0) {
			return searchk(n.left,k);
			}
			else {
				return n;
			}
		}
		
		
	}
	private node searchv(node n, V val) {
		
		return intsearchv(val);
		
	}
	private node sibling(node n) {
		node p=n.parent;
		if(p.left==n) {
			return p.right;
		}
		return p.left;
	}
	private void rotateleft(node x) {
		node y=x.parent;
		node z=y.parent;
		node t2=y.left;
		if(isroot(z)) {
			z.right=t2;
			t2.parent=z;
			y.left =z;
			z.parent=y;
			y.parent=null;
			root=y;
			
			}
		else {
			node p=z.parent;
			if(p.left==z) {
				p.left=y;
			}
			else p.right=y;
			y.parent=p;
			z.right=t2;
			t2.parent=z;
			y.left =z;
			z.parent=y;
			
		}
		rotatatecount++;
		
	}
	private void rotateright(node x) {
		
		node y=x.parent;
		node z=y.parent;
		node t3=y.right;
		if(isroot(z)) {
		z.left=t3;
		t3.parent=z;
		y.right =z;
		z.parent=y;
		y.parent=null;
		root=y;
		
		}
		else {
			node p=z.parent;
			if(p.left==z) {
				p.left=y;
			}
			else p.right=y;
			y.parent=p;
			z.left=t3;
			t3.parent=z;
			y.right =z;
			z.parent=y;
			
		}
		
		rotatatecount++;
	}
	private void searchrangehelper(Vector<V> v,node n,K k1,K k2) {
		if (n.rank == 0) 
            return; 
  
        
        searchrangehelper(v,n.left,k1,k2); 
  
        if(n.key.compareTo(k2)<=0 && n.key.compareTo(k1)>=0) {
        	v.add(n.value);
        }
  
        
        searchrangehelper(v,n.right,k1,k2);
	}
	private int max (int p,int o) {
		if(p>=o) return p;
		return o;
	}
	private int heighthelper(node n) {
		if(n.key==null) {
			return 0;
		}
		int j=0;
		j=max(j, 1+heighthelper(n.left));
		j=max(j,1+heighthelper(n.right));
		return j;
	}
	public V put(K key, V value){
		// write your code her 
		if(size==0) {
			root.key=key;
    		root.value=value;
    		addext(root);
    		root.rank++;
    		
    		size++;
		}
		else {
			node q=null;
			node n=searchk(root, key);
			if(n.key.equals(key)) {
				V val=n.value;
				n.value=value;
				return val;
			}
			if(isleaf(n)) {
	    		//node t=new node(n,null,null,key,value);
	    		
	    	//	System.out.println("In insert - "+t);
	    		if(key.compareTo(n.key)>0) {
	    			n.right.key=key;
	    			n.right.value=value;
	    			q=n.right;
	    			
	    		}
	    		else {
	    			n.left.key=key;
	    			n.left.value=value;
	    			q=n.left;
	    		}
	    		size++;
	    		//System.out.println("Left - "+n.left.value);
	    		
	    	}
	    	else if(n.right.rank==0) {
	    		n.right.key=key;
    			n.right.value=value;
    			q=n.right;
	    		size++;
	    	
	    	}
	    	else {
	    		n.left.key=key;
    			n.left.value=value;
    			q=n.left;
	    		size++;
	    	}
			addext(q);
			q.rank++;
			while(!isroot(q)) {
				if(rankdiff(q)==1) {
					break;
				}
				else {
					if(rankdiff(sibling(q))==1) {
						q=q.parent;
						q.rank++;
						continue;
					}
					else {
						node z=q.parent;
						if(z.left==q) {
							if(rankdiff(q.left)==1) {
								//left-left case
								node x=q.left;
								rotateright(x);
								node t=x.parent.right;
								t.rank--;
								break;
								
							}
							else {
								//left-right case
								
								node x=q.right;
								rotateleft(x.right);
								rotateright(x.left);
								x.rank++;
								x.left.rank--;
								x.right.rank--;
								break;
							}
						
						}
						else {
							if(rankdiff(q.left)==1) {
								//right-left case
								
								node x=q.left;
								rotateright(x.left);
								rotateleft(x.right);
								x.rank++;
								x.left.rank--;
								x.right.rank--;
								break;
							}
							else {
								//right-right case	
								node x=q.right;
								rotateleft(x);
								node t=x.parent.left;
								t.rank--;
								break;
							}
							
						}
						
						
					}
					
				}
				
			}
			
		}
		return null;
		
	}

	public V remove(K key){
		// write your code her 
		boolean rebal=false;
		node q=null;
		node n=searchk(this.root,key);
		V val=n.value;
		//doubt pt. as it may return null in below line
		if(!n.key.equals(key)) {
			return null;
		}
		
		if(size==1) {
    		root=new node(null,null,null,null,null);
    		
    	}
    	else {
    		
    		rebal=true;
    		//.out.println("n - "+n);
    		//System.out.println("n parent = "+n.parent+"\tvalue - "+n.parent.value+"\tn left - "+n.left+"\t n right - "+n.right+"\tn value - "+n.value);
    		if(isleaf(n)) {
    			
    			node p=n.parent;
    			boolean dem=false;
    		//	System.out.println("n parent - "+p+"\t left - "+p.left+"\t right - "+p.right);
    			if(p.left==n) {
    				p.left=n.left;
    				n.left.parent=p;
    				n.right=null;
    				q=p.left;
    				if(isexternal(p.right)) {
    					dem=true;
    				}
    			}
    			else if(p.right==n){
    				p.right=n.right;
    				n.right.parent=p;
    				n.left=null;
    				q=p.right;
    				if(isexternal(p.left)) {
    					dem=true;
    				}
    			}
    			else {
    	
        			//System.out.println("Right here!");
    				//p.right=null;
    			}
    			
    			n=null;
    			if(dem) {
    				q=p;
    				p.rank--;
    			}
    			//re balancing for leaf deletion 
    			
    			
    			
    			
    		}
    		
    		else if(n.left.rank==0){
    			if(!isroot(n)) {
    			
    			node r=n.right;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			r.parent=p;
    			n.left=null;
    			n=null;
    			q=r;
    			
    			}
    			else {
    				rebal=false;
    				this.root=n.right;
    				n.right.parent=null;
    				n.left=null;
    				n=null;
    		
    				
    			}
    		}
    		else if(n.right.rank==0){
    			if(!isroot(n)) {
    			node r=n.left;
    			node p= n.parent;
    			if(p.left==n) {
    				p.left=r;
    			}
    			else {
    				p.right=r;
    			}
    			r.parent=p;
    			n.right=null;
    			n=null;
    			q=r;
    			}
    			else {
    				rebal=false;
    				root=n.left;
    				n.left.parent=null;
    				n.right=null;
    				n=null;
    				
    			}
    		}
    		else {
    	
    			node successor=null;
    			
    			node r=n.right;
    			r.parent=n;
    			while(r.left.rank!=0) {
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
    			
    			
    			
    			}
    			else {
    				
    				n.value=r.value;
        			n.key=r.key;
        			
        			root=n;
    			}
    			
    			if(r.right.rank!=0) {
    			
    			node rr=r.right;
    			
    			node pp= r.parent;
    			
    			
    			if(pp.left==r) {
    				pp.left=rr;
    			}
    			else {
    				pp.right=rr;
    			}
    			rr.parent=pp;
    			r.left=null;
    			r=null;
    			q=rr;
    			
    			}
    			else {
    				
    				node p=r.parent;
    				boolean dem=false;
    				//System.out.println(p.key);
    				
    				if(p.left==r) {
        				p.left=r.left;
        				r.left.parent=p;
        				r.right=null;
        				q=p.left;
        				if(isexternal(p.right)) {
        					dem=true;
        				}
        				//System.out.println(p.key);
        				
        				
        			}
        			else {
        				p.right=r.right;
        				r.right.parent=p;
        				r.left=null;
        				q=p.right;
        				//System.out.println(p.rank);
        				if(isexternal(p.left)) {
        					dem=true;
        				}
        			}

    				r=null;
    				if(dem) {
        				q=p;
        				p.rank--;
        			}
        			
    			}
    		}
    	}
    	size--;
		if(rebal) {
			while(!isroot(q)) {
				if(rankdiff(q)==2) {
					break;
				}
				else if(rankdiff(q)==3) {
					node s=sibling(q);
					node p=q.parent;
					if(rankdiff(s)==2) {
						p.rank--;
						q=p;
						continue;
					}
					else if(rankdiff(s)==1) {
						if(rankdiff(s.left)==2 && rankdiff(s.right)==2) {
							p.rank--;
							s.rank--;
							q=p;
							continue;
						}
						else {
							node t=null;
							node l=s.left;
							node r=s.right;
							if(rankdiff(l)==1 && rankdiff(r)==1) {
								if(p.left==s) {
									//left-left
									rotateright(l);
									s.rank++;
									p.rank--;
									break;
								}
								else {
									//right-right
									rotateleft(r);
									s.rank++;
									p.rank--;
									break;
								}
								
							}
							else if(rankdiff(l)==1) {
								
								if(p.left==s) {
									//left-left
									rotateright(l);
									s.rank++;
									p.rank--;
									break;
								}
								else {
									
									//right-left
									rotateright(l.left);
									rotateleft(l.right);
									l.rank+=2;
									s.rank--;
									p.rank-=2;
									break;
									//System.out.println(p.parent.parent.rank);
								}
							}
							else if(rankdiff(r)==1) {
								if(p.left==s) {
									//left-right
									rotateleft(r.right);
									rotateright(r.left);
									r.rank+=2;
									s.rank--;
									p.rank-=2;
									break;
								}
								else {
									//right-right
									rotateleft(r);
									s.rank++;
									p.rank--;
									break;
								}
							}
							
						}
					}
					
					
				}
				else {
					
				}
			}
			
			
		}
		
		
		return val;
	}

	public V get(K key){
		// write your code her 
		node n=searchk(this.root,key);
		if(n.key.equals(key)) return n.value;
		return null;
	}

	public Vector<V> searchRange(K key1, K key2){
		// write your code her 
		Vector<V> vals=new Vector<V>();
		searchrangehelper(vals, root, key1, key2);
		return vals;
	}

	public int rotateCount(){
		// write your code her 
		return rotatatecount;
	}

	public int getHeight(){
		// write your code her 
		int height=heighthelper(root);
		return (height);
	}

	public Vector<K> BFS(){
		// write your code her 
		
		Vector<K> bfs =new Vector<K>();
		if(root.value==null) {
			return bfs;
		}
		LinkedList<node> q = new LinkedList<node>(); 
        q.add(root); 
    	while(q.size()!=0) {
    		node temp=q.poll();
    		bfs.add(temp.key);
    		if(temp.left.rank!=0) {
    			q.add(temp.left);
    		}
    		if(temp.right.rank!=0) {
    			q.add(temp.right);
    		}
    	}
    	return bfs;
	}

}
