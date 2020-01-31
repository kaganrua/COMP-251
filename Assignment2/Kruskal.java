import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        /* Fill this method (The statement return null is here only to compile) */
        
    	ArrayList<Edge> sortedEdge = g.listOfEdgesSorted();
    	
    	DisjointSets subsets = new DisjointSets(g.getNbNodes());			//
    	
    	WGraph MST = new WGraph();
    	
    	
    	int eCounter = 0;
    	while(eCounter < g.getNbNodes() - 1 && sortedEdge.size() != 0)
    	{
    		Edge edge = sortedEdge.remove(0);
    		
    		if(subsets.find(edge.nodes[0]) != subsets.find(edge.nodes[1]))
    		{
    			subsets.union(edge.nodes[0], edge.nodes[1]);
    			MST.addEdge(edge);
    			eCounter++;
    		}
    		
    	
    	}
    	
    	
        return MST;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){
    	
    	if(p.find(e.nodes[0]) != p.find(e.nodes[1]))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}

        /* Fill this method (The statement return 0 is here only to compile) */
        
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}