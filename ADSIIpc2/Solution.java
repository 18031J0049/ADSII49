

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


class Graph1 
{     
    class Edge { 
        int src, dest, weight; 
        Edge() { 
            src = dest = weight = 0; 
        } 
    }
    int V, E;
    LinkedList<Integer> adj[];
    int dist[];
    Edge edge[];  
   Graph1(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[e]; 
        dist = new int[V];
        for (int i=0; i<e; ++i)
        {
        	edge[i] = new Edge();
        }
            
    }
    public void addEdge(Graph1 g, int src, int dest,int w) 
    { 
        int i=0;
        g.adj[src].add(dest); 
        g.dist[i]=w;
        i++;
    } 
    public void findPath(Graph1 g,int src,int dest)
    {
    	DirectedPaths(g,src,dest);
    }
    public void printGraph(Graph1 g)
    {
    	
    	System.out.print(g);
    }
  //to find whether the path is present or not
    void dfs(int v) 
    { 
       
        boolean visited[] = new boolean[V]; 
        dfsUtil(v, visited); 
    } 
    void dfsUtil(int v,boolean visited[]) 
    { 
        visited[v] = true; 
        //System.out.print(v+" "); 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
            {
            	dfsUtil(n, visited);
            }
                 
        } 
    } 
    
	

  //used shortest path method to get least distance
    void DirectedPaths(Graph1 g,int src,int dest) 
    { 
        int V = g.V;
        int E = g.E; 
        int dist[] = new int[V]; 
        for (int i=0; i<V; ++i) 
        {
        	dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; 
        for (int i=1; i<V; ++i) 
        { 
            for (int j=0; j<E; ++j) 
            { 
                int u = g.edge[j].src; 
                int v = g.edge[j].dest; 
                int weight = g.edge[j].weight; 
                if ((dist[u]!=Integer.MAX_VALUE) && (dist[u]+weight<dist[v])) 
                {
                	dist[v]=dist[u]+weight;
                }   
            } 
        } 
        printArray(dist, V); 
    } 
    void printArray(int dist[], int V) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i=0; i<V; ++i) 
        {
        	System.out.println(i+"  "+dist[i]); 
        }  
    } 
}

public class Solution
{

	public static void main(String[] args) 
	{
		//number of cities
		int n;
		//number of roads
		int k;
		Scanner scan = new Scanner(System.in);
		String s=scan.next();
		String str[]=s.split(" ");
		n=Integer.parseInt(str[0]);
		k=Integer.parseInt(str[1]);
		Graph1 g = new Graph1(n,k);
		while(scan.hasNext())
		{
			String s1=scan.nextLine();
			String[] str1=s1.split(" ");
			int src=Integer.parseInt(str[0]+1);
			int dest=Integer.parseInt(str1[1]+1);
			int w=Integer.parseInt(str1[2]+1);
			g.addEdge(g, src, dest, w);
		}
		String caseToGo=scan.next();
		switch(caseToGo)
		{
		case "Graph": g.printGraph(g);
		break;
		case "DirectedPaths":  
			int src=0,dest=6;
				g.findPath(g,src,dest);
			break;
		case "ViaPaths": 
			break;
		}
	}
}
