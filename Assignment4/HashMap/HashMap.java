package col106.assignment4.HashMap;
import java.util.ArrayList;
import java.util.Vector;

public class HashMap<V> implements HashMapInterface<V> {
	/*public static void main (String[] args) {
		HashMap<Integer> h=new HashMap<Integer>(100);
		
		for(int i=0;i<100;i++) {
			h.put(Integer.toString(i), i);
		}
		
		for(int i=0;i<99;i++) {
			h.remove(Integer.toString(i));
		}
		
		for(String s:h.getKeysInOrder() ) {
			System.out.println(s);
		}
	}*/
	// to make the array of hashnodes, make hashnode class generic!
	// private class hashnode<V> { }
	// finally use array instead of an arraylist and make the required changes
	
	private class hashnode{
		private String key;
		private V value;
		private hashnode(String key, V value) {
			this.key=key;
			this.value=value;
		}
	}
	private ArrayList<hashnode> htable;
	private int size;
	private String dummy="";
	private int hashfunc(String k) {
		if(k.length()==0) {
			return 0;
		}
		int m=0;
		//or directly use poly func instead of horner's rule
		
		for(int i=k.length()-1;i>0;i--) {
			m=(41*((m+k.charAt(i))%size))%size;
			
		}
		m=(m+k.charAt(0))%size;
		
		return m;
	}
	public int search(String k) {
		int h=hashfunc(k);
		int g=0;
		hashnode q=null;
		while(true) {
			g++;
			q=htable.get(h);
			if(q.key==null) {
				return -1;
			}
			if(q.key.equals(k)) {
				return h;
			}
			h=(h+1)%size;
			if(g>size+1)return -1;
		}
	}
	public void upd(int h,V val) {
		htable.get(h).value=val;
	}
	public HashMap(int size) {
		// write your code here
		htable =new ArrayList<hashnode>(size);
		this.size=size;
		for(int i=0;i<size;i++) {
			htable.add(new hashnode(null,null));
		}
	}

	public V put(String key, V value){
		// write your code here
		int h=hashfunc(key);
		hashnode q=null;
		while(true) {
		q=htable.get(h);	
		if(q.key==null) {
			//if(temp==-1) {
			q.key=key;
			q.value=value;
			return null;
			//}
			/*else {
				htable.get(temp).key=key;
				htable.get(temp).value=value;
				return null;
			}*/
		}
		/*if(temp==-1) {
		if(q.key.equals(dummy)) {
			temp=h;
			
		}
		}*/
		if(q.key.equals(key)) {
			V val=q.value;
			q.value=value;
			return val;
		}
		h=(h+1)%this.size;
		}
	}

	public V get(String key){
		// write your code here
		int h=hashfunc(key);
		
		hashnode q=null;
		while(true) {
			q=htable.get(h);
			if(q.key==null) {
				return null;
			}
			if(q.key.equals(key)) {
				return q.value;
			}
			h=(h+1)%size;
		}
	}

	public boolean remove(String key){
		// write your code here
		int h=search(key);
		if(h==-1) {
			return false;
		}
		hashnode q=htable.get(h);
		q.key=null;
		q.value=null;
		int i=h;
		int t=i;
		i=(i+1)%size;
		
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(i);
		while(true) {
			q=htable.get(i);	
			if(q.key==null) {
				break;
			}
			else {
				int hh=hashfunc(q.key);
				if(l.contains(hh)) {
					i=(i+1)%size;
					l.add(i);
					continue;
				}
				else {
					l.clear();
					hashnode shift=htable.get(t);
					shift.key=q.key;
					shift.value=q.value;
					t=i;
					q.key=null;
					q.value=null;
					i=(i+1)%size;
					l.add(i);
				}
			}
		}
		return true;
	}

	public boolean contains(String key){
		// write your code here
		if(search(key)!=-1) {
			return true;
		}
		return false;
	}

	public Vector<String> getKeysInOrder(){
		// write your code here
		Vector<String> keys=new Vector<String>();
		int i=0;
		for(hashnode q :htable) {
			if(q!=null && q.key!=null) {
				keys.add(i, q.key);
				i++;
			}
			
		}
		return keys;
	}
}
