package col106.assignment3.Heap;

import java.util.ArrayList;

public class Heap<T, E extends Comparable> implements HeapInterface <T, E> {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	public static void main() {

		/*Heap<Integer,Integer> h=new Heap<Integer, Integer>();
		h.insert(1, 100);
		h.insert(2, 10);
		h.insert(3, 30);
		h.insert(4, 50);
		h.insert(5, 150);
		h.insert(6, 1);
		h.insert(7, 3);
		h.printHeap();
		h.delete(1);
		h.printHeap();
		h.insert(8, 500);
		h.printHeap();
		h.extractMax();
		h.printHeap();
		h.increaseKey(7, 70);
		h.printHeap();*/
		//Heap<Integer, Integer> h1=new Heap<Integer, Integer>();
		//for(int i=0;i<10000;i++) {
		//	h1.insert(i, i);
		//}
		
		//for(int i=0;i<10000;i++) {
		//	System.out.println(h1.extractMax());
		
		//}
		
				
	}
	/*
	 * end code
	 */
	
	// write your code here	
	private class hnode{
			private T key;
			private E value;
			private hnode(T k,E val) {
				this.key=k;
				this.value=val;
			}
		}
	private int i=6;
	private int size=0;
	private ArrayList<hnode> myarray;
	public Heap() {

		this.myarray=new ArrayList<Heap<T,E>.hnode>();
		for(int i=0;i<=126;i++) {
			myarray.add(null);
			}
		}
	public boolean isempty() {
		return size==0;
	}
	private void swap(int i,int j) {
		hnode t1=myarray.get(i);
		myarray.set(i, myarray.get(j));
		myarray.set(j, t1);
		}
	private void internalinsert(T key, E value) {
		//write your code here
		hnode n= new hnode(key,value);
		myarray.set(size,n);
		size++;
		if(size==Math.pow(2, i+1)-1) {
			i++;
			/*hnode[] temp = (hnode[]) new Object[(int)(Math.pow(2, i+1))-1];
			/*for(int i=0;i<this.myarray.length;i++) {
				temp[i]=this.myarray[i];
			}
			System.arraycopy(this.myarray, 0, temp, 0, this.size);
			this.myarray=temp;
			*/
			int m=size;
			while(m<=Math.min(Math.pow(2, i+1)-1, Integer.MAX_VALUE)) {
				myarray.add( null);
				m++;
			}
		}
		if(size!=1) {
			int k=size-1;
			while(k>0) {
				if(k%2==0) {
					if(myarray.get((k-2)/2).value.compareTo(value) < 0) {
						swap(k,(k-2)/2);
						k=(k-2)/2;
						}
					else {
						break;
						}
					}
					else {
						if(myarray.get((k-1)/2).value.compareTo(value) < 0) {
							swap(k,(k-1)/2);
							k=(k-1)/2;
							}
						else {
							break;
						}
						
					}
				}
			}

		}
	public void insert(T key, E value) {
		//write your code here
		internalinsert(key,value);
		/*hnode n= new hnode(key,value);
		myarray.set(size++,n);
		if(size==Math.pow(2, i+1)-1) {
			i++;
			/*hnode[] temp = (hnode[]) new Object[(int)(Math.pow(2, i+1))-1];
			/*for(int i=0;i<this.myarray.length;i++) {
				temp[i]=this.myarray[i];
			}
			System.arraycopy(this.myarray, 0, temp, 0, this.size);
			this.myarray=temp;
			*/
			/*int m=size;
			while(m<=Math.min(Math.pow(2, i+1)-1, Integer.MAX_VALUE)) {
				myarray.add( null);
				m++;
			}
		}
		if(size!=1) {
			int k=size-1;
			while(k>0) {
				if(k%2==0) {
					if(myarray.get((k-2)/2).value.compareTo(value) < 0) {
						swap(k,(k-2)/2);
						k=(k-2)/2;
						}
					else {
						break;
						}
					}
					else {
						if(myarray.get((k-1)/2).value.compareTo(value) < 0) {
							swap(k,(k-1)/2);
							k=(k-1)/2;
							}
						else {
							break;
						}
						
					}
				}
			}
		*/
	}
	public int search(T key) {
		if(size==0) {
			return -1;
		}
		int j=0;
		boolean b=false;
		while(j<size) {
			if(myarray.get(j).key.equals(key)) {
				
				b=true;
				break;	
			}
			else {
				j++;
			}
		}
		if(!b) { return -1;}
		return j;
		
		}
	public E getvalue(T key) {
		if(size==0) {
			return null;
			
		}
		int k=0;
		k=search(key);
		if(k<0) {
			return null;
		}
		else {
			return myarray.get(k).value;
		}
	}
	private void internaldelete(T key) {
		//write your code here

		int j=search(key);
		swap(j,size-1);
		
		myarray.set(size-1, null);
		size--;
		
		/*while(2*j+1<size && myarray.get(2*j+1).value.compareTo(myarray.get(j).value)>0) {
			if(myarray.get(2*j+2)==null) {
				swap(2*j+1,j);
				break;
			}
			else {
				if(myarray.get(2*j+2).value.compareTo(myarray.get(2*j+1).value)>0) {
					swap(2*j+2,j);
				}
				else {
					swap(j,2*j+1);
				}
			}
		}
		*/
		while(2*j+1<size) {
		boolean b1=false;
		boolean b2=false;
		E temp1=null;
		E temp2=null;
			if(myarray.get(2*j+1).value.compareTo(myarray.get(j).value)>0) {
				b1=true;
				temp1=myarray.get(2*j+1).value;
				if(2*j+2<size) {
					if(myarray.get(2*j+2).value.compareTo(myarray.get(j).value)>0) {
						temp2=myarray.get(2*j+2).value;
					}
				}
				if(temp2==null) {
					swap(2*j+1,j);
					j=2*j+1;
					continue;
					}
				else {
					if(temp1.compareTo(temp2)>0) {
						swap(2*j+1,j);
						j=2*j+1;
						continue;
						
					}
					else {
						swap(2*j+2,j);
						j=2*j+2;
						continue;
						
					}
				}
				
				
			}
			if(2*j+2<size) {
				if(myarray.get(2*j+2).value.compareTo(myarray.get(j).value)>0) {
					b2=true;
					swap(2*j+2,j);
					j=2*j+2;
					continue;
				}
			}
			if(b1==false && b2==false) {
				break;
			}
		}
		

	}
	public E max() {
		return myarray.get(0).value; 
		
	}
	public E extractMax() {
		//write your code here
		E temp=myarray.get(0).value;
		internaldelete(myarray.get(0).key);
		return temp;
		
	}
	public T emaxkey() {
		T temp=myarray.get(0).key;
		internaldelete(myarray.get(0).key);
		return temp;
	}

	public void delete(T key) {
		//write your code here
		internaldelete(key);
		/*int j=search(key);
		swap(j,size-1);
		myarray.set(size-1, null);
		size--;
		while(2*j+1<size && myarray.get(2*j+1).value.compareTo(myarray.get(j).value)>0) {
			if(myarray.get(2*j+2)==null) {
				swap(2*j+1,j);
				break;
			}
			else {
				if(myarray.get(2*j+2).value.compareTo(myarray.get(2*j+1).value)>0) {
					swap(2*j+2,j);
				}
				else {
					swap(j,2*j+1);
				}
			}
		}*/
		
	}

	public void increaseKey(T key, E value) {
		//write your code here
		int j=this.search(key);
		myarray.get(j).value=value;
		if(j!=0) {
			int k=j;
			while(k>0) {
				if(k%2==0) {
					if(myarray.get((k-2)/2).value.compareTo(value) < 0) {
						swap(k,(k-2)/2);
						k=(k-2)/2;
						}
					else {
						break;
						}
					}
					else {
						if(myarray.get((k-1)/2).value.compareTo(value) < 0) {
							swap(k,(k-1)/2);
							k=(k-1)/2;
							}
						else {
							break;
						}
						
					}
				}
			}
		//internaldelete(myarray.get(j).key);
		//internalinsert(key,value);
	}

	public void printHeap() {
		//write your code here
		int j=0;
		while(j<size) {
			System.out.println(myarray.get(j).key+", "+myarray.get(j).value);
			j++;
		}
	}	
}
