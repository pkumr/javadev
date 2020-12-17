/*
 * 
 */
package com.pk.algorithms.graphs;

import java.util.LinkedList;

/**
 *
 * @author parveenkumar
 */
public class DepthFirstSearch {
    private LinkedList<Integer>[] adjacencyList;
    private int[][] adjacencyMatrix;
    private int numberOfVertices;
    
    public DepthFirstSearch(int noOfVertices){
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
    
    public void DFSAdjList(int source){
        boolean[] visited = new boolean[numberOfVertices];
        DFSAdjList_Helper(source, visited);
    }
    private void DFSAdjList_Helper(int source, boolean[] visited){
        visited[source] = true;
        System.out.println("Visited --> " + source);
        for(int i = 0; i < adjacencyList[source].size(); i++ ){
                int n = adjacencyList[source].get(i);
                if(!visited[n]){
                    DFSAdjList_Helper(n, visited);
                }
            }
    }
    public static void main_DFS(String[] args){
        System.out.println("DFS Graph Traversal ");
        /*
                    0 --- 3
                   / \
                  1   2
                 /
                4 -- 5
        0 -- Source Node
        DFS Should go to leaf node on pne path
            0 --> 1
            1 --> 4
            4 --> 5
        1, 4, 5 can be visited in order.
        
        Then Search move to next level path
            0 --> 2
        Search then move to next level 
            0 --> 3
                
        */
        DepthFirstSearch obj = new DepthFirstSearch(6);
        obj.addEdgeAdjListDirected(0, 1);
        obj.addEdgeAdjListDirected(1, 4);
        obj.addEdgeAdjListDirected(4, 5);
        obj.addEdgeAdjListDirected(0, 2);
        obj.addEdgeAdjListDirected(0, 3);
        obj.DFSAdjList(0);
        
    }
}
