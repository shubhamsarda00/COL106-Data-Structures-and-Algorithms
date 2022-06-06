public class MyStack<A>{
	private A[] myarray;
	private int size;
	
	public MyStack(){
		this.myarray = (A[]) new Object[200];
		this.size=0;
		}
	public void push(A element) {
		if(this.size==this.myarray.length) {
			int n= 2*this.myarray.length;
			A[] temp = (A[]) new Object[n];
			/*for(int i=0;i<this.myarray.length;i++) {
				temp[i]=this.myarray[i];
			}*/
			System.arraycopy(this.myarray, 0, temp, 0, this.size);
			this.myarray=temp;
		}
		this.myarray[size] = element;
		++size;
	}
	public A pop() throws EmptyStackException{
		if(size==0) {
			throw new EmptyStackException("Cannot pop from an empty stack");
		}
		--size;
		return myarray[size];
		
	}
	public A top() throws EmptyStackException{
		if(size!=0) {
			return myarray[size-1];
		}
		throw new EmptyStackException("No element in stack");
			
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size () {
		return size;
	}
	/*public static void main (String[] args) throws EmptyStackException {
		MyStack<Integer> j= new MyStack<Integer>();
		for(int i=0;i<1000000;i++) {
			j.push(1);
		}
		System.out.println(j.size());
		for(int i=0;i<1000000;i++) {
			j.pop();
		}
		System.out.println(j.size()+" "+ j.isEmpty());
	}*/
	
}

