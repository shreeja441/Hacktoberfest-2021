package datastructure.Graphs;

import java.util.Scanner; 

public class Graph {
    public int[][] ajdencyMatrix; 
    public int number_of_vertex; 
    public int number_of_edges; 
    private boolean isDirected; 
    public Graph() {
        this.ajdencyMatrix = new int[10][10]; 
    }

    public Graph(int vertex, int edges, boolean directed) {
        this.number_of_vertex = vertex; 
        this.number_of_edges = edges; 
        this.ajdencyMatrix = new int[this.number_of_vertex][this.number_of_vertex];
        this.isDirected = directed; 
        this.initGraph(); // init. graph using adjency matrix. 
    }

    public void initGraph() {
        Scanner sc = new Scanner(System.in); 
        int start = -1, end = -1; 
        for(int i = 0; i < this.number_of_edges; i++) {
            start = sc.nextInt(); 
            end = sc.nextInt(); 
            this.ajdencyMatrix[start - 1][end - 1] = 1; 
            if(!this.isDirected) {
                this.ajdencyMatrix[end - 1][start - 1] = 1; 
            }
        }
        sc.close(); 
    }

    
    public void printMatrix() {
        for(int i = 0; i < this.number_of_vertex; i++) {
            for(int j  = 0; j < this.number_of_vertex; j++) {
                System.out.print(this.ajdencyMatrix[i][j] + " "); 
            }
            System.out.println(); // append new line. 
        }
    }
    

}
