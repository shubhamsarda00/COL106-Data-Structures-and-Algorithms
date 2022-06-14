package col106.assignment6;
 
public class PQNode implements Comparable<PQNode> {
		
	DualVertex v;
	double dist;
	public PQNode(DualVertex v, double d) {
		this.v=v;
		this.dist=d;
		
	}

	@Override
	public int compareTo(PQNode o) {
		// TODO Auto-generated method stub
		if(this.dist>o.dist) {
			return 1;
		}
		else if(this.dist<o.dist) {
			return -1;
		}
		return 0;
		
	}
	public boolean equals(Object o) {
		PQNode p=(PQNode) o;
		
		return(p.v.equals(v));
		
	}
	
}
