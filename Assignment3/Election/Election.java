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
	public static void main(String[] args) {

		/*
		 INSERT
Cand1, 1, S1, D11, C11, P1, 10
INSERT
Cand2, 2, S1, D11, C11, P2, 50
INSERT
Cand3, 3, S1, D11, C11, P3, 30
INSERT
Cand4, 4, S1, D12, C12, P1, 5
INSERT
Cand5, 5, S1, D12, C12, P2, 11
INSERT
Cand6, 6, S1, D12, C12, P3, 15
INSERT
Cand7, 7, S1, D13, C13, P1, 12
INSERT
Cand8, 8, S1, D13, C13, P2, 13
INSERT
Cand9, 9, S1, D13, C13, P3, 14
INSERT
Cand10, 10, S2, D21, C21, P1, 0
INSERT
Cand11, 11, S2, D21, C21, P2, 32
INSERT
Cand12, 12, S2, D21, C21, P3, 6
INSERT
Cand13, 13, S3, D31, C31, P1, 18
INSERT
Cand14, 14, S3, D31, C31, P2, 19
INSERT
Cand15, 15, S3, D31, C31, P3, 55
INSERT
Cand16, 16, S3, D32, C32, P1, 255
INSERT
Cand17, 17, S3, D32, C32, P2, 75
INSERT
Cand18, 18, S3, D33, C32, P3, 180
PRINT
GLOBAL LEADING PARTY
UPDATE
Cand3, 3, 100
PRINT
GLOBAL LEADING PARTY
LEADING PARTY IN STATE
S1
LEADING PARTY IN STATE
S2
LEADING PARTY IN STATE
S3
TOP k IN CONSTITUENCY
C11, 4
TOP k IN CONSTITUENCY
C12, 2
TOP k IN CONSTITUENCY
C21, 3
DISCARD ALL VOTES IN CONSTITUENCY
C11
PRINT
GLOBAL LEADING PARTY
VOTE SHARES
P2, S2
VOTE SHARES
P3, S1
VOTE SHARES
P1, S1
VOTE SHARES
P2, S1
		 */
		//Election e=new Election();
		Election poll=new Election();
	       poll.insert("Cand1" , "1" , "S1" , "D1" , "C11" , "P1" , "10");
	        poll.insert("Cand2" , "2" , "S1" , "D1" , "C11" , "P2" , "20");
	        poll.insert("Cand3" , "3" , "S1" , "D1" , "C12" , "P1" , "30");
	        poll.insert("Cand4" , "4" , "S1" , "D1" , "C12" , "P2" , "40");
	        poll.insert("Cand5" , "5" , "S2" , "D1" , "C21" , "P1" , "50");
	        poll.insert("Cand6" , "6" , "S2" , "D1" , "C21" , "P2" , "60");
	        poll.insert("Cand7" , "7" , "S2" , "D1" , "C22" , "P1" , "120");
	        poll.insert("Cand8" , "8" , "S2" , "D1" , "C22" , "P2" , "90");
	        poll.printElectionLevelOrder();
	        
	        poll.leadingPartyOverall();
	        poll.updateVote("Cand4", "4", "42");
	        poll.updateVote("Cand7", "7", "122");
	        poll.printElectionLevelOrder();
	        poll.leadingPartyOverall();
	        
	        poll.leadingPartyInState("S1");
	        
	        poll.leadingPartyInState("S2");
	        poll.topkInConstituency("C11", "5");
	        poll.topkInConstituency("C22", "10");
	        poll.topkInConstituency("C21", "1");
	        poll.cancelVoteConstituency("C12");
	        poll.printElectionLevelOrder();
	        poll.leadingPartyOverall();
	        poll.voteShareInState("P1", "S1");
	        poll.voteShareInState("P2", "S2");
		//e.leadingPartyInState("S1");
		//e.cancelVoteConstituency("C1");
		//e.leadingPartyInState("S1");
		//e.leadingPartyInState("S1");
		//e.leadingPartyOverall();
		//e.cancelVoteConstituency("C1");
		//e.leadingPartyOverall();
		//e.printElectionLevelOrder();
		//e.printElectionLevelOrder();
		//e.leadingPartyOverall();
		//e.updateVote("Cand1", "1", "2500");
		//e.updateVote("Cand8", "4", "1400");
		//e.printElectionLevelOrder();
		//e.insert("Cand9", "6", "S1", "D1", "C6", "P6", "20");
		//e.insert("Cand10", "7", "S2", "D2", "C3", "P2", "500");
		
		//e.printElectionLevelOrder();
		//e.topkInConstituency("C1", "5");
		//e.cancelVoteConstituency("C1");
		//e.printElectionLevelOrder();
		//e.leadingPartyInState("S1");
		//e.leadingPartyOverall();
		//e.voteShareInState("P1", "S1");
		//e.cancelVoteConstituency("C1");
		
		//e.printElectionLevelOrder();
		
		//e.insert("Cand1", "1", "S1", "D1", "C1", "P1", "4600");
		//e.insert("Cand2", "100", "S1", "D1", "C1", "P2", "4800");
		//e.leadingPartyInState("S1");
		//e.insert("Cand7", "3", "S2", "D3", "C3", "P3", "2000");
		//e.insert("Cand8", "4", "S1", "D4", "C4", "P4", "800");
		//e.insert("Cand9", "5", "S3", "D5", "C5", "P6", "1500");
		//e.cancelVoteConstituency("C1");
		//e.leadingPartyOverall();
		
		//e.leadingPartyInState("S3");
		
		
		
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











