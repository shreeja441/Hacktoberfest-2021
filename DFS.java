
import java.util.Scanner; 
import java.util.ArrayList; 
import datastructure.utils.ArrayFunction;

/**
 * this DFS traversal work with < -- adjMatrix --> representation of Graph. 
 */

public class DFS {
   
    private Graph graph; 
    private ArrayList<Integer> visited_list; 
    private int main_source_vertex; 

    public DFS(Graph graph, int source_vertex) {
        this.graph = graph; 
        this.visited_list = new ArrayList<Integer>(); 
        this.main_source_vertex = source_vertex - 1; 
        visited_list.add(this.main_source_vertex); 
        int prnt_ = this.main_source_vertex + 1;
        System.out.print(prnt_); 
        System.out.print(", "); 
        this.tarverse(this.main_source_vertex);
    } 

    public void tarverse(int source_vertex) {
        
        // get all vertex adjcent to our source vertex. 
        for(int i = 0; i < graph.number_of_vertex; i++) {
            if(graph.ajdencyMatrix[source_vertex][i] != 0) {
                if(!ArrayFunction.isIn(visited_list, i)) {
                    int prnt_ = i + 1;
                    System.out.print(prnt_); 
                    System.out.print(", "); 
                    this.visited_list.add(i); 
                    this.tarverse(i);
                }
            }
        }
    }

}   
