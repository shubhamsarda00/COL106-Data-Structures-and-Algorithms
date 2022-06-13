package Assignment3.Election;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import Assignment3.BST.BST;
import Assignment3.BST.BST.node;
import Assignment3.Heap.Heap;


public class Election implements ElectionInterface {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	public static void main() {
		ElectionDriverCode EDC = new ElectionDriverCode();
		System.setOut(EDC.fileout());
	}
	/*
	 * end code
	 */
	
	//write your code here 
	private class cand  implements Comparable{
		private String name;
		private String candID;
		private String state; 
		private String district;
		private String constituency;
		private String party;
		private String votes;
		
		@Override
		
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			cand b=(cand) o;
			if(Integer.parseInt(this.votes)>Integer.parseInt(b.votes)) {
				return 1;
			}
			else if(Integer.parseInt(this.votes)<Integer.parseInt(b.votes)) {
				return -1;
			}
			else {
				return 0;
			}
			
		}
		private cand(String name, String candID, String state, String district, String constituency, String party, String votes) {
			this.name=name;
			this.candID=candID;
			this.state=state;
			this.district=district;
			this.constituency=constituency;
			this.party=party;
			this.votes=votes;
			
		}
		
	}
	private class cobj{
		private String constituency;
		private Heap<String, cand> cheap;
		private cobj(String c) {
			cheap= new Heap<String, cand>();
			this.constituency=c;
		}
	}
	private class pobj implements Comparable{
		private String votes;
		private String party;
		public pobj(String party, String votes) {
			this.party=party;
			this.votes=votes;
		}	
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			pobj m= (pobj) o;
			if(Integer.parseInt(this.votes)>Integer.parseInt(m.votes)){
				return 1; 
			}
			else if(Integer.parseInt(this.votes)<Integer.parseInt(m.votes)) {
				return -1;
				
			}
			else {
				
				if(this.party.compareTo(m.party)>0) {
					return -1;
				}
				else return 1;
			}
		}
		
		
	}
	private class sobj{
		private String state;
		private int votes;
		private Heap<String, pobj> sheap;
		private LinkedList<cobj> clist;
		private sobj(String s) {
			this.state=s;
			votes=0;
			sheap=new Heap<String, Election.pobj>();
			clist=new LinkedList<Election.cobj>();
		}
	}
	private BST<String, cand> mybst;
	private LinkedList<sobj> statelist;
	private int votes;
	private Heap<String, pobj> globaltally;
	public Election() {
		votes=0;
		mybst =new BST<String, Election.cand>();
		statelist=new LinkedList<sobj>();
		globaltally= new Heap<String, Election.pobj>();
	}
    public void insert(String name, String candID, String state, String district, String constituency, String party, String votes){
		//write your code here 
    	cand c= new cand(name, candID,  state, district, constituency,party, votes);
    	this.votes+=Integer.parseInt(votes);
    
    	mybst.insert(candID, c);
    	
    	pobj po=globaltally.getvalue(party);
    	if(po==null) {
    		globaltally.insert(party, new pobj(party,votes));
    		
    	}
    	else {
   
    		globaltally.increaseKey(party,new pobj(party,Integer.toString(Integer.parseInt(po.votes)+Integer.parseInt(votes))));
    		
    		
    	}
    	
    
    	
    	boolean s1=true;
    	if(statelist.size()==0) {
    		sobj snew=new sobj(state);
			snew.votes=Integer.parseInt(votes);
			snew.sheap.insert(party, new pobj(party,votes));
			cobj n=new cobj(constituency);
			n.cheap.insert(candID, c);
			snew.clist.add(n);
			statelist.add(snew);
		}
    	else {
    	for (sobj s:statelist) {
    		s1=true;
    		if (s.state.equals(state)) {
    			s1=false;
    			s.votes+=Integer.parseInt(votes);
    			boolean c2=true;
    			boolean p=true;
    			for(cobj c1:s.clist) {
    				if(c1.constituency.equals(constituency)) {
    					
    					c1.cheap.insert(candID, c);
    					c2=false;
    					break;
    				}	
    			}
    			if(c2) {
    				
    				cobj c3=new cobj(constituency);
    				c3.cheap.insert(candID, c);	
    				s.clist.add(c3);
    			}
    			
    			pobj p3=s.sheap.getvalue(party);
    			if(p3==null) {
    				
    				s.sheap.insert(party, new pobj(party,votes));
    			}
    			else {
    				int v=Integer.parseInt(p3.votes);
    				v+=Integer.parseInt(votes);
    				String vvotes=Integer.toString(v);
    				s.sheap.delete(party);
    				s.sheap.insert(party, new pobj(party,vvotes));
    			}
    		break;	
    		}
    		
    	}
    		if(s1) {
    	
    		sobj o=new sobj(state);
    		o.votes=Integer.parseInt(votes);
    		o.sheap.insert(party, new pobj(party,votes));
    		cobj p=new cobj(constituency);
    		p.cheap.insert(candID, c);
    		o.clist.add(p);
    		statelist.add(o);

    		}
    	
    	}
    	
	}
	public void updateVote(String name, String candID, String votes){
		//write your code here
		cand c =mybst.getvalue(mybst.searchk(mybst.root(), candID));
		String n1=c.name;
		String ci=c.candID;
		String v=c.votes;
		String d=c.district;
		String st=c.state;
		String con=c.constituency;
		String pa=c.party;
		mybst.delete(candID);
		
		
		
		cand cnew= new cand(name,candID,st,d,con,pa,votes);
		mybst.insert(candID, cnew);
		pobj po=globaltally.getvalue(cnew.party);
		String m=po.votes;
    	pobj n=new pobj(cnew.party,Integer.toString(Integer.parseInt(m)+Integer.parseInt(votes)-Integer.parseInt(v)));
		globaltally.delete(pa);
		globaltally.insert(pa, n);
		
		this.votes+=Integer.parseInt(votes)-Integer.parseInt(v);
		
		for (sobj s:statelist) {
    		if (s.state.equals(cnew.state)) {
   
    			s.votes+=Integer.parseInt(cnew.votes)-Integer.parseInt(v);
    			
    			
    			for(cobj c1:s.clist) {
    				if(c1.constituency.equals(con)) {
    					c1.cheap.delete(ci);
    					c1.cheap.insert(candID, cnew);
    					break;
    				}	
    			}
    			
    			pobj p3=s.sheap.getvalue(pa);
    			
    				int v1=Integer.parseInt(p3.votes);
    				v1+=Integer.parseInt(votes)-Integer.parseInt(v);
    				String vvotes=Integer.toString(v1);
    				s.sheap.delete(pa);
    				s.sheap.insert(pa, new pobj(pa,vvotes));
    				
    		
    		break;	
    		}
    		
    	}
		
	}
	public void topkInConstituency(String constituency, String k){
		//write your code here
		cand[] arr=new cand[Integer.parseInt(k)];
		int i=0;
		int k1=Integer.parseInt(k);
		int k7=0;
		for(sobj s:statelist) {
			
			for(cobj c1:s.clist) {
				if(c1.constituency.equals(constituency)) {
					while(!c1.cheap.isempty()&&i<k1) {
						
					arr[i]=c1.cheap.extractMax();
					i++;
					}
					
					for(int g=0;g<i;g++){
						
						c1.cheap.insert(arr[g].candID, arr[g]);
						System.out.println(arr[g].name+", "+arr[g].candID+", "+arr[g].party);
					}
					k7++;
					break;
				}
				
				
			}
			if(k7>0) {
				break;
			}
			
		}
	}
	public void leadingPartyInState(String state){
		//write your code here
		String v;
		LinkedList<pobj> ll=new LinkedList<pobj>();
		for(sobj s:statelist) {
			
			if(s.state.equals(state)) {
				v=s.sheap.max().votes;
				ll.add(s.sheap.max());
				System.out.println(s.sheap.extractMax().party);
				
				while(!s.sheap.isempty() && s.sheap.max().votes.equals(v)) {
					ll.add(s.sheap.max());
					System.out.println(s.sheap.extractMax().party);
				}
				while(!ll.isEmpty()) {
					
					pobj tmep=ll.poll();
					s.sheap.insert(tmep.party, tmep);
				}
				break;
			}
			
		}
	}
	public void cancelVoteConstituency(String constituency){
		//write your code here
		Heap<cand,String> myheap=new Heap<Election.cand, String>();
		sobj k=null;
		cobj cc=null;
		boolean b=false;
		for(sobj s:statelist) {
			
			b=false;
			for(cobj c1:s.clist) {
				if(c1.constituency.equals(constituency)) {
					cc=c1;
					k=s;
					b=true;
				}
			}
		if(b) {
		if(cc!=null) k.clist.remove(cc);
		/*LinkedList<node> q = new LinkedList<node>(); 
        q.add(mybst.root()); 
    	while(q.size()!=0) {
    		node temp=q.poll();
    		cand temp1=mybst.getvalue(temp);
    		if(temp1.constituency==constituency) {
    			this.votes-=Integer.parseInt(temp1.votes);
    			k.votes-=Integer.parseInt(temp1.votes);
    			mybst.deletev(temp1);
    		}
    		if(mybst.left(temp)!=null) {
    			q.add(mybst.left(temp));
    		}
    		if(mybst.right(temp)!=null) {
    			q.add(mybst.right(temp));
    			
    		}
    	}*/
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		cancelint(mybst.root(), constituency, k,hm,myheap);
		for(String ss:hm.keySet()) {
			int vv=hm.get(ss);
			String d=ss;
			String d1=d;
			pobj pp=k.sheap.getvalue(ss);
			Integer temp=Integer.parseInt(pp.votes);
			Integer v=hm.get(ss);
			pobj pnew=new pobj(ss,String.valueOf(temp-v));
			k.sheap.delete(ss);
			k.sheap.insert(d, pnew);
			pobj ppp=globaltally.getvalue(d);
			Integer temp1=Integer.parseInt(ppp.votes);
			globaltally.delete(d);
			pobj pnew1=new pobj(d1,String.valueOf(temp1-v));
			globaltally.insert(d1, pnew1);
			
		}
		break;
		}
	}
		ArrayList<cand> arr= new ArrayList<cand>();
		
		while(!myheap.isempty()) {
			arr.add(myheap.emaxkey());
		}
		
		int g=arr.size()-1;
		while(g>=0) {
			
			mybst.delete(arr.get(g).candID);
			g--;
		}
		
	}
	private void cancelint(BST<String, cand>.node n, String c,sobj k,HashMap<String, Integer> hm, Heap<Election.cand, String> myheap) {
		if (n == null) 
            return; 
		
        /* first recur on left child */
        cancelint(mybst.left(n), c,k,hm,myheap) ;
  
        /* then print the data of node */
        cand p=mybst.getvalue(n);
        if (p.constituency.equals(c) && p.state.equals(k.state)) {
        		
        		this.votes-=Integer.parseInt(p.votes);
        		k.votes-=Integer.parseInt(p.votes);
        		myheap.insert(p, p.candID);
        		if(hm.containsKey(p.party)) {
        			
        			Integer u=hm.get(p.party);
        			
        			u+= Integer.parseInt(p.votes);
        			hm.replace(p.party, u);
        		}
        		else {
        			hm.put(p.party, Integer.parseInt(p.votes));
        			
        		}
        		
        		//pobj pp=k.sheap.getvalue(p.party);
        		//pp.votes=String.valueOf(Integer.parseInt(pp.votes)-Integer.parseInt(p.votes));
        		//pobj ppp=globaltally.getvalue(p.party);
        		//ppp.votes=String.valueOf(Integer.parseInt(ppp.votes)-Integer.parseInt(p.votes));
        		
        		
			
			}
  
        /* now recur on right child */
        cancelint(mybst.right(n), c,k,hm,myheap) ;
		
	
		
	}
		
	
	public void leadingPartyOverall(){
		//write your code here
		LinkedList<pobj> ll=new LinkedList<pobj>();
		String v=globaltally.max().votes;
		
		ll.add(globaltally.max());
		System.out.println(globaltally.extractMax().party);
		while(!globaltally.isempty() && globaltally.max().votes.equals(v)) {
			ll.add(globaltally.max());
			System.out.println(globaltally.extractMax().party);
		}
		while(!ll.isEmpty()) {
			pobj tmep=ll.poll();
			globaltally.insert(tmep.party, tmep);
		}
		
	}
	public void voteShareInState(String party,String state){
		//write your code here
		int totalvotes=1;
		int partyvotes=1;
		for(sobj s:statelist) {
			if(s.state.equals(state)) {
				totalvotes=s.votes;
				
				partyvotes=Integer.parseInt(s.sheap.getvalue(party).votes);
				break;
			}
		}
		
		double d=partyvotes*100d/totalvotes;
		
		System.out.println((int) d );
	}
	
	public void printElectionLevelOrder() {
		//write your code here
		LinkedList<node> q = new LinkedList<node>(); 
        q.add(mybst.root()); 
    	while(q.size()!=0) {
    		node temp=q.poll();
    		cand temp1=mybst.getvalue(temp);
    			System.out.println(temp1.name+", "+temp1.candID+", "+temp1.state+", "+temp1.district+", "+temp1.constituency+", "+temp1.party+", "+temp1.votes);
    		
    		if(mybst.left(temp)!=null) {
    			q.add(mybst.left(temp));
    		}
    		if(mybst.right(temp)!=null) {
    			q.add(mybst.right(temp));
    			
    		}
    	}
		
	}
}











