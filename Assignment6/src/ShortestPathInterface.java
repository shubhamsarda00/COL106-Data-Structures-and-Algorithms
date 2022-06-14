package Assignment6.src;

import java.util.ArrayList;

interface ShortestPathInterface {
    // Dual graph
    public int numDualNodes();
    public int numDualEdges();
    public ArrayList<int[]> dualGraph();

    // Shortest path
    public boolean hasValidPath();
    public int ShortestPathValue();
    public ArrayList<int[]> getShortestPath();    
}
