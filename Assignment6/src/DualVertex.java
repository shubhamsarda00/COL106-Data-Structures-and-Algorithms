package Assignment6.src;

public class DualVertex {
	Vertex i;
    Vertex j;
    int key;
    double weight;
    

    public DualVertex(Vertex i, Vertex j, int key,double weight){
        this.i = i;
        this.j = j;
        this.key = key;
        this.weight=weight;
    }
    
    public boolean equals(Object O) {
    	DualVertex  p=(DualVertex) O;
    	return ( i.i==p.i.i && i.j==p.i.j && j.i==p.j.i && j.j==p.j.j );
    }
    public int hashCode() {
    	return i.i+i.j+j.i+j.j;
    }

}
