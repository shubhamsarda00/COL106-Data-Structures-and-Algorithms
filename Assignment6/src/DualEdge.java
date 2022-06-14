package Assignment6.src;

public class DualEdge {
    private DualVertex u;
    private DualVertex v;
    private double weight;

    /**
     * Initializes a directed edge from vertex u to vertex v
     * @param u the source vertex
     * @param v the destination vertex
     * @param weight the weight of the directed edge
     * @throws IllegalArgumentException if either u or v is a negative integer
     * @throws IllegalArgumentException if {@code weight} is {@code NaN}
     */
    public DualEdge( DualVertex u, DualVertex v, double weight) {
        
       
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    /**
     * Returns the tail vertex of the directed edge.
     * @return the tail vertex of the directed edge
     */
    public DualVertex from() {
        return u;
    }

    /**
     * Returns the head vertex of the directed edge.
     * @return the head vertex of the directed edge
     */
    public DualVertex to() {
        return v;
    }

    /**
     * Returns the weight of the directed edge.
     * @return the weight of the directed edge
     */
    public double weight() {
        return weight;
    }
}
