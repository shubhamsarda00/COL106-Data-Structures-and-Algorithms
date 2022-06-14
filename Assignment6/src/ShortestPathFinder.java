package col106.assignment6;


import java.util.ArrayList;

import java.util.Collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import java.util.Set;

public class ShortestPathFinder implements ShortestPathInterface {
	/**
	 * Computes shortest-path from the source vertex s to destination vertex t in
	 * graph G. DO NOT MODIFY THE ARGUMENTS TO THIS CONSTRUCTOR
	 *
	 * @param G       the graph
	 * @param s       the source vertex
	 * @param t       the destination vertex
	 * @param left    the cost of taking a left turn
	 * @param right   the cost of taking a right turn
	 * @param forward the cost of going forward
	 * @throws IllegalArgumentException unless 0 <= s < V
	 * @throws IllegalArgumentException unless 0 <= t < V where V is the number of
	 *                                  vertices in the graph G.
	 */
	Digraph G;
	int cf;
	int cr;
	int cl;
	Vertex source;
	Vertex dest;
	DualGraph DG;
	int runs = 0;
	HashMap<DualVertex, Integer> d;
	HashMap<DualVertex, DualVertex> prev;
	//
	// int[] d;
	// DualVertex[] prev;

	//
	int shortestdist = Integer.MAX_VALUE;
	DualVertex terminal = null;
	ArrayList<int[]> path = null;
	/*
	 * public static void main(String[] args) throws FileNotFoundException { String
	 * file = "A6SkeletonCode/test_cases/input_files/in1.csv"; Digraph G = new
	 * Digraph(file); int[] s = new int[]{0, 0}; int[] t = new int[]{1,1 }; int
	 * forward = 0; int left = 8; int right = 1; ShortestPathFinder sp=new
	 * ShortestPathFinder(G, s, t, left, right, forward); DualGraph dg =sp.DG;
	 * 
	 * System.out.println(dg.E); System.out.println(dg.V); ArrayList<int[]>
	 * a=sp.dualGraph(); System.out.println(sp.hasValidPath()); Scanner sc = new
	 * Scanner(new File("A6SkeletonCode/test_cases/dual_graph/1.csv")); int nodes0 =
	 * sc.nextInt(); int edges0 = sc.nextInt(); ArrayList<int[]> hooks0 = new
	 * ArrayList<int[]>();
	 * 
	 * while(sc.hasNextInt()){ int a1 = sc.nextInt(); int a2 = sc.nextInt(); int b1
	 * = sc.nextInt(); int b2 = sc.nextInt(); int c1 = sc.nextInt(); int c2 =
	 * sc.nextInt(); int w = sc.nextInt(); hooks0.add(new int[]{a1, a2, b1, b2, c1,
	 * c2, w}); } ArrayList<String> hooks0_str = new ArrayList<String>();
	 * ArrayList<String> hooks_str = new ArrayList<String>(); for (int i=0;
	 * i<hooks0.size(); i++){ int[] h0 = hooks0.get(i); int[] h1 = a.get(i);
	 * hooks0_str.add(Arrays.toString(h0)); hooks_str.add(Arrays.toString(h1)); }
	 * Collections.sort(hooks0_str); Collections.sort(hooks_str); for (int i=0;
	 * i<hooks0.size(); i++){
	 * System.out.println(hooks0_str.get(i)+" "+hooks_str.get(i));
	 * System.out.println();
	 * 
	 * } if (!hooks_str.equals(hooks0_str)){
	 * System.out.println("Dual graphs do not match");
	 * 
	 * }
	 * 
	 * 
	 * 
	 * Scanner sc1 = new Scanner(new
	 * File("A6SkeletonCode/test_cases/output_path/1.csv")); int hPath0 =
	 * sc1.nextInt(); boolean hasPath0 = (hPath0 == 1); int pathLength0 =
	 * sc1.nextInt(); ArrayList<int[]> path0 = new ArrayList<int[]>();
	 * while(sc1.hasNextInt()){ int n1 = sc1.nextInt(); int n2 = sc1.nextInt();
	 * path0.add(new int[]{n1, n2}); // System.out.println("(" + n1 + "," + n2 +
	 * ")"); }
	 * 
	 * boolean hasPath = sp.hasValidPath(); int pathLength = sp.ShortestPathValue();
	 * ArrayList<int[]> path = sp.getShortestPath();
	 * 
	 * // Check 1 : Does a valid path exist if (hasPath != hasPath0){
	 * System.out.println("No path found");
	 * 
	 * }
	 * 
	 * // Check 2 : Do the path lengths match if (pathLength != pathLength0){
	 * System.out.println("Path lengths do not match");
	 * 
	 * } System.out.println(pathLength);
	 * 
	 * // Check 3 : Does the path match for (int i=0;i<path0.size();i++){ int[]
	 * node0 = path0.get(i); int[] node1 = path.get(i);
	 * 
	 * if ((node0[0] != node1[0]) || (node0[1] != node1[1])) {
	 * System.out.println(node0[0] + " " + node0[1]); System.out.println(node1[0] +
	 * " " + node1[1]);
	 * 
	 * System.out.println("Path nodes do not match");
	 * 
	 * } }
	 * 
	 * 
	 * }
	 */

	public ShortestPathFinder(final Digraph G, final int[] s, final int[] t, final int left, final int right,
			final int forward) throws IllegalArgumentException {
		// YOUR CODE GOES HERE
		// if(!(s>=0 && s<G.V())) {
		//
		// }
		
		this.G = G;
		this.cf = forward;
		this.cr = right;
		this.cl = left;
		this.source = new Vertex(s[0], s[1], s[0] * G.W() + s[1]);
		this.dest = new Vertex(t[0], t[1], t[0] * G.W() + t[1]);
		if (!(0 <= source.key && source.key < G.V())) {
			throw new IllegalArgumentException("Source is not a valid vertex!");
		}
		if (!(0 <= dest.key && dest.key < G.V())) {
			throw new IllegalArgumentException("Destination is not a valid vertex!");
		}

		DG = new DualGraph(G, source, dest, left, right, forward);
		d = new HashMap<DualVertex, Integer>();

		prev = new HashMap<DualVertex, DualVertex>();
		///
		// d=new int[DG.Vmax];
		// prev=new DualVertex[DG.Vmax];

		///

	}

	// Return number of nodes in dual graph
	public int numDualNodes() {
		// YOUR CODE GOES HERE
		return DG.V;
	}

	// Return number of edges in dual graph
	public int numDualEdges() {
		// YOUR CODE GOES HERE
		return DG.E;
	}

	// Return hooks in dual graph
	// A hook (0,0) - (1,0) - (1,2) with weight 8 should be represented as
	// the integer array {0, 0, 1, 0, 1, 2, 8}
	public ArrayList<int[]> dualGraph() {
		// YOUR CODE GOES HERE

		ArrayList<int[]> a = new ArrayList<int[]>();
		HashMap<DualVertex, ArrayList<DualEdge>> m = DG.map;
		Collection<ArrayList<DualEdge>> c = m.values();
		// ArrayList<DualEdge>[] c=DG.adjacency();
		for (ArrayList<DualEdge> s : c) {
			for (int i = 0; i < s.size(); i++) {
				int[] temp = new int[7];
				DualEdge e = s.get(i);
				temp[0] = e.from().i.i;
				temp[1] = e.from().i.j;
				temp[2] = e.from().j.i;
				temp[3] = e.from().j.j;
				temp[4] = e.to().j.i;
				temp[5] = e.to().j.j;
				temp[6] = (int) e.weight();
				a.add(temp);
			}
		}
		return a;

	}

	// Return true if there is a path from s to t.
	public boolean hasValidPath() {
		// YOUR CODE GOES HERE
		boolean[] vis = new boolean[G.V()];
		dfs(source, vis, G.adjacency(), G.getHashMap());
		return vis[dest.key];
	}

	// Return the length of the shortest path from s to t.
	public int ShortestPathValue() {
		// YOUR CODE GOES HERE
		/*
		 * if(runs==0) { getShortestPath(); runs+=1; } return shortestdist;
		 */
		getShortestPath();
		return shortestdist;
	}

	// Return the shortest path computed from s to t as an ArrayList of nodes,
	// where each node is represented by its location on the grid.
	public ArrayList<int[]> getShortestPath() {
		// YOUR CODE GOES HERE
		/*
		 * if(runs>0) { return path; } runs+=1;
		 */
		// System.out.println(42);
		PriorityQueue<PQNode> pq = new PriorityQueue<PQNode>();

		Set<DualVertex> s = DG.map.keySet();

		for (DualVertex v : s) {
			if (v.i.i == -1) {
				pq.add(new PQNode(v, 0));
				d.put(v, 0);
				prev.put(v, null);
				continue;
			}

			pq.add(new PQNode(v, Integer.MAX_VALUE));
			d.put(v, Integer.MAX_VALUE);
			prev.put(v, null);
			// DualVertex x=new DualVertex(new Vertex(v.i.i,v.i.j,4),new
			// Vertex(v.j.i,v.j.j,4),46,76);
			// System.out.println(d.get(x));

		}

		////
		/*
		 * for( int i=0;i<DG.Vmax;i++) { DualVertex v= DG.nodemap(i); if(v!=null) {
		 * if(v.i.i==-1) { pq.add(new PQNode(v, 0)); //d.put(v, 0); //prev.put(v, null);
		 * /// d[v.key]=0; prev[v.key]=null;
		 * 
		 * 
		 * // continue; }
		 * 
		 * 
		 * pq.add(new PQNode(v, Integer.MAX_VALUE)); //d.put(v,Integer.MAX_VALUE);
		 * //prev.put(v,null); ///// d[v.key]=Integer.MAX_VALUE; prev[v.key]=null;
		 * 
		 * /////
		 * 
		 * }
		 * 
		 * }
		 */

		/////////
		while (!pq.isEmpty()) {
			PQNode p = pq.poll();
			DualVertex v = p.v;
			ArrayList<DualEdge> a = DG.map.get(v);
			// ArrayList<DualEdge>[] aa=DG.adjacency();
			// ArrayList<DualEdge> a=aa[v.key];
			for (int i = 0; i < a.size(); i++) {
				DualEdge e = a.get(i);
				// System.out.println(d.get);
				// System.out.println(d.get(e.to()));

				if (d.get(e.to()) > e.weight() + d.get(v)) {
					pq.remove(new PQNode(e.to(), d.get(e.to())));
					d.replace(e.to(), (int) e.weight() + d.get(v));
					pq.add(new PQNode(e.to(), d.get(e.to())));
					prev.put(e.to(), e.from());
					if (e.to().j.i == dest.i && e.to().j.j == dest.j) {
						if (shortestdist > e.weight() + d.get(v)) {
							shortestdist = (int) e.weight() + d.get(v);
							terminal = e.to();
						}
					}
				}

				////////
				/*
				 * if(d[e.to().key]>e.weight()+d[v.key]) { pq.remove(new
				 * PQNode(e.to(),d[e.to().key])); d[e.to().key]=(int)e.weight()+d[v.key];
				 * pq.add(new PQNode(e.to(),d[e.to().key])); prev[e.to().key]= e.from();
				 * if(e.to().j.i==dest.i && e.to().j.j==dest.j) {
				 * if(shortestdist>e.weight()+d[v.key]) { shortestdist=(int)
				 * e.weight()+d[v.key]; terminal=e.to(); } } }
				 */

				//////

			}

		}
		if (terminal != null) {

			path = new ArrayList<int[]>();
			LinkedList<int[]> l = new LinkedList<int[]>();

			while (terminal != null) {
				int[] temp = new int[2];
				temp[1] = terminal.j.j;

				temp[0] = terminal.j.i;
				// System.out.println(temp[0]+" "+ temp[1]);
				l.add(temp);
				terminal = prev.get(terminal);
				////

				// terminal=prev[terminal.key];
				/////

			}
			while (!l.isEmpty()) {
				path.add(l.removeLast());
			}
			// System.out.println(8);
			return path;

		}

		return path;
	}

	private void dfs(Vertex c, boolean[] vis, ArrayList<Edge>[] adjacencyG, HashMap<Integer, Vertex> map) {
		if (vis[c.key] == true) {
			return;
		}
		vis[c.key] = true;
		for (int i = 0; i < adjacencyG[c.key].size(); i++) {
			Edge e = adjacencyG[c.key].get(i);
			Vertex temp1 = map.get(e.to());

			if (!vis[temp1.key]) {

				// change key

				dfs(temp1, vis, adjacencyG, map);
			}

		}

	}

}

/*
 * package col106.assignment6;
 * 
 * 
 * import java.io.File; import java.io.FileNotFoundException; import
 * java.util.ArrayList; import java.util.Arrays; import java.util.Collection;
 * import java.util.Collections; import java.util.HashMap; import
 * java.util.LinkedList; import java.util.PriorityQueue; import
 * java.util.Scanner; import java.util.Set;
 * 
 * public class ShortestPathFinder implements ShortestPathInterface {
 *//**
	 * Computes shortest-path from the source vertex s to destination vertex t in
	 * graph G. DO NOT MODIFY THE ARGUMENTS TO THIS CONSTRUCTOR
	 *
	 * @param G       the graph
	 * @param s       the source vertex
	 * @param t       the destination vertex
	 * @param left    the cost of taking a left turn
	 * @param right   the cost of taking a right turn
	 * @param forward the cost of going forward
	 * @throws IllegalArgumentException unless 0 <= s < V
	 * @throws IllegalArgumentException unless 0 <= t < V where V is the number of
	 *                                  vertices in the graph G.
	 *//*
		 * Digraph G; int cf; int cr; int cl; Vertex source; Vertex dest; DualGraph DG;
		 * int runs=0; //HashMap<DualVertex, Integer > d; //HashMap<DualVertex,
		 * DualVertex> prev; // int[] d; DualVertex[] prev;
		 * 
		 * // int shortestdist=Integer.MAX_VALUE; DualVertex terminal=null;
		 * ArrayList<int[]> path=null; public static void main(String[] args) throws
		 * FileNotFoundException { String file =
		 * "A6SkeletonCode/test_cases/input_files/in1.csv"; Digraph G = new
		 * Digraph(file); int[] s = new int[]{0, 0}; int[] t = new int[]{1,1 }; int
		 * forward = 0; int left = 8; int right = 1; ShortestPathFinder sp=new
		 * ShortestPathFinder(G, s, t, left, right, forward); DualGraph dg =sp.DG;
		 * 
		 * System.out.println(dg.E); System.out.println(dg.V); ArrayList<int[]>
		 * a=sp.dualGraph(); System.out.println(sp.hasValidPath()); Scanner sc = new
		 * Scanner(new File("A6SkeletonCode/test_cases/dual_graph/1.csv")); int nodes0 =
		 * sc.nextInt(); int edges0 = sc.nextInt(); ArrayList<int[]> hooks0 = new
		 * ArrayList<int[]>();
		 * 
		 * while(sc.hasNextInt()){ int a1 = sc.nextInt(); int a2 = sc.nextInt(); int b1
		 * = sc.nextInt(); int b2 = sc.nextInt(); int c1 = sc.nextInt(); int c2 =
		 * sc.nextInt(); int w = sc.nextInt(); hooks0.add(new int[]{a1, a2, b1, b2, c1,
		 * c2, w}); } ArrayList<String> hooks0_str = new ArrayList<String>();
		 * ArrayList<String> hooks_str = new ArrayList<String>(); for (int i=0;
		 * i<hooks0.size(); i++){ int[] h0 = hooks0.get(i); int[] h1 = a.get(i);
		 * hooks0_str.add(Arrays.toString(h0)); hooks_str.add(Arrays.toString(h1)); }
		 * Collections.sort(hooks0_str); Collections.sort(hooks_str); for (int i=0;
		 * i<hooks0.size(); i++){
		 * System.out.println(hooks0_str.get(i)+" "+hooks_str.get(i));
		 * System.out.println();
		 * 
		 * } if (!hooks_str.equals(hooks0_str)){
		 * System.out.println("Dual graphs do not match");
		 * 
		 * }
		 * 
		 * 
		 * 
		 * Scanner sc1 = new Scanner(new
		 * File("A6SkeletonCode/test_cases/output_path/1.csv")); int hPath0 =
		 * sc1.nextInt(); boolean hasPath0 = (hPath0 == 1); int pathLength0 =
		 * sc1.nextInt(); ArrayList<int[]> path0 = new ArrayList<int[]>();
		 * while(sc1.hasNextInt()){ int n1 = sc1.nextInt(); int n2 = sc1.nextInt();
		 * path0.add(new int[]{n1, n2}); // System.out.println("(" + n1 + "," + n2 +
		 * ")"); }
		 * 
		 * boolean hasPath = sp.hasValidPath(); int pathLength = sp.ShortestPathValue();
		 * ArrayList<int[]> path = sp.getShortestPath();
		 * 
		 * // Check 1 : Does a valid path exist if (hasPath != hasPath0){
		 * System.out.println("No path found");
		 * 
		 * }
		 * 
		 * // Check 2 : Do the path lengths match if (pathLength != pathLength0){
		 * System.out.println("Path lengths do not match");
		 * 
		 * } System.out.println(pathLength);
		 * 
		 * // Check 3 : Does the path match for (int i=0;i<path0.size();i++){ int[]
		 * node0 = path0.get(i); int[] node1 = path.get(i);
		 * 
		 * if ((node0[0] != node1[0]) || (node0[1] != node1[1])) {
		 * System.out.println(node0[0] + " " + node0[1]); System.out.println(node1[0] +
		 * " " + node1[1]);
		 * 
		 * System.out.println("Path nodes do not match");
		 * 
		 * } }
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * public ShortestPathFinder (final Digraph G, final int[] s, final int[] t,
		 * final int left, final int right, final int forward) throws
		 * IllegalArgumentException { // YOUR CODE GOES HERE //if(!(s>=0 && s<G.V())) {
		 * // //}
		 * 
		 * this.G= G; this.cf=forward; this.cr=right; this.cl=left; this.source =new
		 * Vertex(s[0], s[1], s[0]*G.W()+s[1]); this.dest =new Vertex(t[0], t[1],
		 * t[0]*G.W()+t[1]); if(!(0<=source.key && source.key<G.V())){ throw new
		 * IllegalArgumentException("Source is not a valid vertex!"); } if(!(0<=dest.key
		 * && dest.key<G.V())){ throw new
		 * IllegalArgumentException("Destination is not a valid vertex!"); }
		 * 
		 * DG=new DualGraph(G, source, dest, left, right, forward); //d =new
		 * HashMap<DualVertex, Integer>();
		 * 
		 * //prev =new HashMap<DualVertex, DualVertex>(); /// d=new int[DG.Vmax];
		 * prev=new DualVertex[DG.Vmax];
		 * 
		 * ///
		 * 
		 * 
		 * }
		 * 
		 * // Return number of nodes in dual graph public int numDualNodes() { // YOUR
		 * CODE GOES HERE return DG.V; }
		 * 
		 * // Return number of edges in dual graph public int numDualEdges() { // YOUR
		 * CODE GOES HERE return DG.E; }
		 * 
		 * // Return hooks in dual graph // A hook (0,0) - (1,0) - (1,2) with weight 8
		 * should be represented as // the integer array {0, 0, 1, 0, 1, 2, 8} public
		 * ArrayList<int[]> dualGraph() { // YOUR CODE GOES HERE
		 * 
		 * ArrayList<int[]> a = new ArrayList<int[]>(); //HashMap<DualVertex,
		 * ArrayList<DualEdge>> m =DG.map; //Collection<ArrayList<DualEdge>>
		 * c=m.values(); ArrayList<DualEdge>[] c=DG.adjacency(); for(ArrayList<DualEdge>
		 * s: c) { for(int i=0;i<s.size();i++) { int[] temp = new int[7]; DualEdge e=
		 * s.get(i); temp[0]=e.from().i.i; temp[1]=e.from().i.j; temp[2]=e.from().j.i;
		 * temp[3]=e.from().j.j; temp[4]=e.to().j.i; temp[5]=e.to().j.j; temp[6]=(int)
		 * e.weight(); a.add(temp); } } return a;
		 * 
		 * }
		 * 
		 * // Return true if there is a path from s to t. public boolean hasValidPath()
		 * { // YOUR CODE GOES HERE boolean[] vis=new boolean[G.V()]; dfs(source,
		 * vis,G.adjacency(), G.getHashMap()); return vis[dest.key]; }
		 * 
		 * // Return the length of the shortest path from s to t. public int
		 * ShortestPathValue() { // YOUR CODE GOES HERE if(runs==0) { getShortestPath();
		 * runs+=1; } return shortestdist;
		 * 
		 * getShortestPath(); return shortestdist; }
		 * 
		 * // Return the shortest path computed from s to t as an ArrayList of nodes, //
		 * where each node is represented by its location on the grid. public
		 * ArrayList<int[]> getShortestPath() { // YOUR CODE GOES HERE if(runs>0) {
		 * return path; } runs+=1;
		 * 
		 * System.out.println(32); PriorityQueue<PQNode> pq= new
		 * PriorityQueue<PQNode>();
		 * 
		 * Set<DualVertex> s=DG.map.keySet();
		 * 
		 * for(DualVertex v:s) { if(v.i.i==-1) { pq.add(new PQNode(v, 0)); d.put(v, 0);
		 * prev.put(v, null); continue; }
		 * 
		 * 
		 * pq.add(new PQNode(v, Integer.MAX_VALUE)); d.put(v,Integer.MAX_VALUE);
		 * prev.put(v, null); //DualVertex x=new DualVertex(new
		 * Vertex(v.i.i,v.i.j,4),new Vertex(v.j.i,v.j.j,4),46,76);
		 * //System.out.println(d.get(x));
		 * 
		 * }
		 * 
		 * ////
		 * 
		 * for( int i=0;i<DG.Vmax;i++) { DualVertex v= DG.nodemap(i); if(v!=null) {
		 * if(v.i.i==-1) { pq.add(new PQNode(v, 0)); //d.put(v, 0); //prev.put(v, null);
		 * /// d[v.key]=0; prev[v.key]=null;
		 * 
		 * 
		 * // continue; }
		 * 
		 * 
		 * pq.add(new PQNode(v, Integer.MAX_VALUE)); //d.put(v,Integer.MAX_VALUE);
		 * //prev.put(v,null); ///// d[v.key]=Integer.MAX_VALUE; prev[v.key]=null;
		 * 
		 * /////
		 * 
		 * }
		 * 
		 * }
		 * 
		 * ///////// while(!pq.isEmpty()) { PQNode p= pq.poll(); DualVertex v=p.v;
		 * //ArrayList<DualEdge> a=DG.map.get(v); ArrayList<DualEdge>[]
		 * aa=DG.adjacency(); ArrayList<DualEdge> a=aa[v.key]; for(int
		 * i=0;i<a.size();i++) { DualEdge e= a.get(i); //System.out.println(d.get);
		 * //System.out.println(d.get(e.to()));
		 * 
		 * if(d.get(e.to())>e.weight()+d.get(v)) { pq.remove(new
		 * PQNode(e.to(),d.get(e.to()))); d.replace(e.to(),(int)e.weight()+d.get(v));
		 * pq.add(new PQNode(e.to(),d.get(e.to()))); prev.put(e.to(), e.from());
		 * if(e.to().j.i==dest.i && e.to().j.j==dest.j) {
		 * if(shortestdist>e.weight()+d.get(v)) { shortestdist=(int)
		 * e.weight()+d.get(v); terminal=e.to(); } } }
		 * 
		 * 
		 * //////// if(d[e.to().key]>e.weight()+d[v.key]) { pq.remove(new
		 * PQNode(e.to(),d[e.to().key])); d[e.to().key]=(int)e.weight()+d[v.key];
		 * pq.add(new PQNode(e.to(),d[e.to().key])); prev[e.to().key]= e.from();
		 * if(e.to().j.i==dest.i && e.to().j.j==dest.j) {
		 * if(shortestdist>e.weight()+d[v.key]) { shortestdist=(int)
		 * e.weight()+d[v.key]; terminal=e.to(); } } }
		 * 
		 * //////
		 * 
		 * 
		 * }
		 * 
		 * 
		 * } if(terminal!=null) {
		 * 
		 * path= new ArrayList<int[]>(); LinkedList<int[]> l =new LinkedList<int[]>();
		 * 
		 * while(terminal!=null) { int[] temp = new int[2]; temp[1]=terminal.j.j;
		 * 
		 * temp[0]=terminal.j.i; //System.out.println(temp[0]+" "+ temp[1]);
		 * l.add(temp); ///terminal=prev.get(terminal); ////
		 * 
		 * terminal=prev[terminal.key]; /////
		 * 
		 * } while(!l.isEmpty()) { path.add(l.removeLast()); } //System.out.println(8);
		 * return path;
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * return path; } private void dfs(Vertex c, boolean[] vis, ArrayList<Edge>[]
		 * adjacencyG,HashMap<Integer, Vertex> map) { if(vis[c.key]==true) { return; }
		 * vis[c.key] = true; for(int i=0;i<adjacencyG[c.key].size();i++) { Edge
		 * e=adjacencyG[c.key].get(i); Vertex temp1=map.get(e.to());
		 * 
		 * if(!vis[temp1.key]) {
		 * 
		 * //change key
		 * 
		 * dfs(temp1,vis,adjacencyG,map); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
