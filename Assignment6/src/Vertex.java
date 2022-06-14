package Assignment6.src;

public class Vertex {
    int i;
    int j;
    int key;

    public Vertex(int i, int j, int key){
        this.i = i;
        this.j = j;
        this.key = key;
    }
    public boolean equals(Vertex v) {
    	if(this.i==v.i && this.j==v.j) {
    		return true;
    	}
    	return false;
    }
}
