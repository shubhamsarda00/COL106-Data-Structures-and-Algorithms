
package col106.assignment6;

import java.util.ArrayList;
import java.util.HashMap;

import col106.assignment6.DualVertex;
import col106.assignment6.Edge;
import col106.assignment6.Vertex;


public class DualGraph {
	public int V;
	public int E=0;
	int H=0;
	int W=0;
	int Vmax=0;
    public HashMap<DualVertex,ArrayList<DualEdge>> map;
    //private ArrayList<DualEdge>[] adj;
    //private HashMap<Integer, DualVertex> nodemap;
	
    public DualGraph(Digraph G, Vertex s,Vertex t, int left, int right, int forward ){
    	/*int[] degree = new int[G.V()];
    	ArrayList<Edge>[] adjacencyG=G.adjacency();
    	for(int i=0;i<adjacencyG.length;i++) {
    		degree[i]=adjacencyG[i].size();
    	}
    */
    	W=G.W();
    	H=G.H();
    	///////////
    	Vmax=H*(W-1)+W*(H-1)+2;
    	/*adj = new ArrayList[Vmax];
    	for (int v = 0; v < Vmax; v++) {
            adj[v] = new ArrayList<DualEdge>();
        }
    	nodemap=new HashMap<Integer, DualVertex>();
    	/////////////
    	*/
    	ArrayList<Edge>[] adjacencyG=G.adjacency();
    	boolean[] vis=new boolean[G.V()];
    	
    	ArrayList<DualVertex> a = new ArrayList<DualVertex>();
    	map=new HashMap<DualVertex, ArrayList<DualEdge>>();
    	DualVertex sour=new DualVertex(new Vertex(-1,-1,-1),s,0,0);
    	///////
    	//nodemap.put(sour.key, sour);
    	////////
    	a.add(sour); ///Change key
    	
    	map.put(sour, new ArrayList<DualEdge>());
    	DFS(s,vis,a,adjacencyG,G.getHashMap());
    	for(int i=0;i<G.V();i++) {
    		if(vis[i]==false) {
    			DFS(G.nodemap(i),vis,a,adjacencyG,G.getHashMap());
    		}
    	}
    	
    	this.V=a.size();
        
    	for(int i=0; i<a.size();i++) {
    		DualVertex v=a.get(i);
    		ArrayList<Edge> temp=adjacencyG[v.j.key];
    		for (int j=0;j<temp.size();j++) {
    			Edge e= temp.get(j);
    			DualVertex d=new DualVertex(v.j,G.nodemap(e.to()),0,e.weight()); ///change key
    		/////////////
    			d.key=getkey(d);
    			///////////
    			double w=d.weight;
				w+=turnpenalty(v, d, left, right, forward);
				addEdge(new DualEdge(v,d,w ));
				
    		}
    	
    	}
    	
    	
    
    
    }
    
    private void DFS(Vertex c, boolean[] vis, ArrayList<DualVertex> a,ArrayList<Edge>[] adjacencyG,HashMap<Integer, Vertex> map) {
        
    	if(vis[c.key]==true) {
        	return;
        }
    	vis[c.key] = true;
        for(int i=0;i<adjacencyG[c.key].size();i++) {
			Edge e=adjacencyG[c.key].get(i);
			Vertex temp1=map.get(e.to());
			DualVertex v=new DualVertex(c,temp1, 0,e.weight());//change key
			////
			v.key=getkey(v);
			//nodemap.put(v.key, v);
			//////
			a.add(v);
			this.map.put(v, new ArrayList<DualEdge>());
			if(!vis[temp1.key]) {
				
				 
				
				DFS(temp1,vis,a,adjacencyG,map);
			}
				
		}
        
        
      }
    public void addEdge(DualEdge e) {
    	
			
		
        DualVertex v = e.from();
        DualVertex w = e.to();
        map.get(v).add(e);
        /////
        //adj[v.key].add(e);
        /////
        E++;
    	
    	
    }
    private int turnpenalty(DualVertex v,DualVertex w, int left, int right ,int forward) {
    	
    	Vertex a=v.i;
    	if(v.i.i==-1&&v.i.j==-1) {
    		return 0;
    	}
    	Vertex b=v.j;
    	Vertex c=w.j;
    	if(b.i>a.i && b.j==a.j) {
    		if(c.i==b.i && c.j>b.j) {
    			return left;
    		}
    		else {
    			return forward;
    		}
    		
    	}
    	else {
    		if(c.j==b.j && c.i>b.i) {
    			return right;
    		}
    		else {
    			return forward;
    		}
    	}
    	
    }
    private int getkey(DualVertex dv) {
    	Vertex v=dv.i;
    	Vertex w=dv.j;
    	if(v.i==w.i) {
    		if(w.j>v.j) {
    		return (2*W-1)*w.i+w.j;
    	}
    		else {
    			return (2*W-1)*w.i+v.j;
    		}
    	}
    	else {
    		if(w.i>v.i) {
    		return (W-1)*w.i+(w.i-1)*W+w.j+1;
    		}
    		else {
    			return (W-1)*w.i+(v.i-1)*W+w.j+1;
    		}
    	}
    	
    }
    //public ArrayList<DualEdge>[] adjacency() {
      //  return adj;
    //}
    //public DualVertex nodemap(int a){
    	//return nodemap.get(a);
    //}
    //public Iterable<DualEdge> adj(int v) {
        
      //  return adj[v];
    //}

}
//
//package col106.assignment6;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import col106.assignment6.DualVertex;
//import col106.assignment6.Edge;
//import col106.assignment6.Vertex;
//
//
//public class DualGraph {
//	public int V;
//	public int E=0;
//	int H=0;
//	int W=0;
//	int Vmax=0;
//    //public HashMap<DualVertex,ArrayList<DualEdge>> map;
//    private ArrayList<DualEdge>[] adj;
//    private HashMap<Integer, DualVertex> nodemap;
//	
//    public DualGraph(Digraph G, Vertex s,Vertex t, int left, int right, int forward ){
//    	/*int[] degree = new int[G.V()];
//    	ArrayList<Edge>[] adjacencyG=G.adjacency();
//    	for(int i=0;i<adjacencyG.length;i++) {
//    		degree[i]=adjacencyG[i].size();
//    	}
//    */
//    	W=G.W();
//    	H=G.H();
//    	///////////
//    	Vmax=H*(W-1)+W*(H-1)+1;
//    	adj = new ArrayList[Vmax];
//    	for (int v = 0; v < Vmax; v++) {
//            adj[v] = new ArrayList<DualEdge>();
//        }
//    	nodemap=new HashMap<Integer, DualVertex>();
//    	/////////////
//    	
//    	ArrayList<Edge>[] adjacencyG=G.adjacency();
//    	boolean[] vis=new boolean[G.V()];
//    	
//    	ArrayList<DualVertex> a = new ArrayList<DualVertex>();
//    	//map=new HashMap<DualVertex, ArrayList<DualEdge>>();
//    	DualVertex sour=new DualVertex(new Vertex(-1,-1,-1),s,0,0);
//    	///////
//    	nodemap.put(sour.key, sour);
//    	////////
//    	a.add(sour); ///Change key
//    	
//    	//map.put(sour, new ArrayList<DualEdge>());
//    	DFS(s,vis,a,adjacencyG,G.getHashMap());
//    	for(int i=0;i<G.V();i++) {
//    		if(vis[i]==false) {
//    			DFS(G.nodemap(i),vis,a,adjacencyG,G.getHashMap());
//    		}
//    	}
//    	
//    	this.V=a.size();
//        
//    	for(int i=0; i<a.size();i++) {
//    		DualVertex v=a.get(i);
//    		ArrayList<Edge> temp=adjacencyG[v.j.key];
//    		for (int j=0;j<temp.size();j++) {
//    			Edge e= temp.get(j);
//    			DualVertex d=new DualVertex(v.j,G.nodemap(e.to()),0,e.weight()); ///change key
//    		/////////////
//    			d.key=getkey(d);
//    			///////////
//    			double w=d.weight;
//				w+=turnpenalty(v, d, left, right, forward);
//				addEdge(new DualEdge(v,d,w ));
//				
//    		}
//    	
//    	}
//    	
//    	
//    
//    
//    }
//    
//    private void DFS(Vertex c, boolean[] vis, ArrayList<DualVertex> a,ArrayList<Edge>[] adjacencyG,HashMap<Integer, Vertex> map) {
//        
//    	if(vis[c.key]==true) {
//        	return;
//        }
//    	vis[c.key] = true;
//        for(int i=0;i<adjacencyG[c.key].size();i++) {
//			Edge e=adjacencyG[c.key].get(i);
//			Vertex temp1=map.get(e.to());
//			DualVertex v=new DualVertex(c,temp1, 0,e.weight());//change key
//			////
//			v.key=getkey(v);
//			nodemap.put(v.key, v);
//			//////
//			a.add(v);
//			//this.map.put(v, new ArrayList<DualEdge>());
//			if(!vis[temp1.key]) {
//				
//				 
//				
//				DFS(temp1,vis,a,adjacencyG,map);
//			}
//				
//		}
//        
//        
//      }
//    public void addEdge(DualEdge e) {
//    	
//			
//		
//        DualVertex v = e.from();
//        DualVertex w = e.to();
//        //map.get(v).add(e);
//        /////
//        adj[v.key].add(e);
//        /////
//        E++;
//    	
//    	
//    }
//    private int turnpenalty(DualVertex v,DualVertex w, int left, int right ,int forward) {
//    	
//    	Vertex a=v.i;
//    	if(v.i.i==-1&&v.i.j==-1) {
//    		return 0;
//    	}
//    	Vertex b=v.j;
//    	Vertex c=w.j;
//    	if(b.i>a.i && b.j==a.j) {
//    		if(c.i==b.i && c.j>b.j) {
//    			return left;
//    		}
//    		else {
//    			return forward;
//    		}
//    		
//    	}
//    	else {
//    		if(c.j==b.j && c.i>b.i) {
//    			return right;
//    		}
//    		else {
//    			return forward;
//    		}
//    	}
//    	
//    }
//    private int getkey(DualVertex dv) {
//    	Vertex v=dv.i;
//    	Vertex w=dv.j;
//    	if(v.i==w.i) {
//    		if(w.j>v.j) {
//    		return (2*W-1)*w.i+w.j;
//    	}
//    		else {
//    			return (2*W-1)*w.i+v.j;
//    		}
//    	}
//    	else {
//    		if(w.i>v.i) {
//    		return (W-1)*w.i+(w.i-1)*W+w.j+1;
//    		}
//    		else {
//    			return (W-1)*w.i+(v.i-1)*W+w.j+1;
//    		}
//    	}
//    	
//    }
//    public ArrayList<DualEdge>[] adjacency() {
//        return adj;
//    }
//    public DualVertex nodemap(int a){
//    	return nodemap.get(a);
//    }
//    public Iterable<DualEdge> adj(int v) {
//        
//        return adj[v];
//    }
//
//}
//
