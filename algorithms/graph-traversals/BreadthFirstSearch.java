/*
 * 
 */
package com.pk.algorithms.graphs;

import java.util.LinkedList;

/**
 *
 * @author parveenkumar
 */
public class BreadthFirstSearch{ 
    
    private LinkedList<Integer>[] adjacencyList;
    private int[][] adjacencyMatrix;
    private int numberOfVertices;
    
    public BreadthFirstSearch(int noOfVertices){
        this.numberOfVertices = noOfVertices;
        adjacencyList = new LinkedList[noOfVertices];
        for(int i = 0; i < noOfVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
        
        adjacencyMatrix = new int[noOfVertices][noOfVertices];
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix[0].length; j++){
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    //Directed Graph
    public void addEdgeAdjListDirected(int source, int target){
        adjacencyList[source].add(target);
    }
    //Undirected Graph
    public void addEdgeAdjListUndirected(int source, int target){
        adjacencyList[source].add(target);
        adjacencyList[target].add(source);
    }
    //Mark matrix value = 1, if there is an edge between vertices
    public void addEdgeAdjMatDirected(int source, int target){
        adjacencyMatrix[source][target] = 1;
    }
    //
    public void addEdgeAdjMatUndirected(int source, int target){
        adjacencyMatrix[source][target] = 1;
        adjacencyMatrix[target][source] = 1;
    }
    public void BFSAdjList(int source){
        //vertice once visited, mark it true
        boolean[] marked = new boolean[numberOfVertices];
        //Queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        //Add source in the queue;
        queue.add(source);
        while(!queue.isEmpty()){
            int node = queue.remove();
            marked[node] = true;
            for(int i = 0; i < adjacencyList[node].size(); i++ ){
                int n = adjacencyList[node].get(i);
                if(!marked[n]){
                    marked[n] = true;
                    System.out.println("Visited --> " + n);
                    queue.add(n);
                }
            }
            //System.out.println("<-- Next Level Search -->");
        }
    }
    
    public void BFSAdjMatrix(int source){
        
    }
    public static void main_BFS(String[] args){
        System.out.println("BFS Graph Traversal ");
        /*
                    0 --- 5
                   / \
                  1   4
                 /
                2 -- 3
        0 -- Source Node
        BFS Should go to nodes of 0 first
            0 --> 1
            0 --> 4
            0 --> 5
        1, 4, 5 can be visited in any order.
        
        Then Search move to next level means
            1 --> 2
        Search then move to next level 
            2 --> 3
                
        */
        BreadthFirstSearch obj = new BreadthFirstSearch(6);
        obj.addEdgeAdjListDirected(0, 1);
        obj.addEdgeAdjListDirected(1, 2);
        obj.addEdgeAdjListDirected(2, 3);
        obj.addEdgeAdjListDirected(0, 4);
        obj.addEdgeAdjListDirected(0, 5);
        obj.BFSAdjList(0);
        
    }
}
