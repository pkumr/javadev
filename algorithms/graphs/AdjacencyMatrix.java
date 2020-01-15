/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pk.algorithms.graphs;

/**
 *
 * @author parveenkumar
 */
public class AdjacencyMatrix implements Graph {
    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;
    public AdjacencyMatrix(int numOfVertices, GraphType graphType){
        this.numVertices = numOfVertices;
        this.graphType = graphType;
        adjacencyMatrix = new int[numOfVertices][numOfVertices];
        for(int i = 0; i < numOfVertices; i++){
            for(int j = 0; j < numOfVertices; j++){
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    
    @Override
    public void addEdge(int v1, int v2) {
       adjacencyMatrix[v1][v2] = 1;
       if(graphType == GraphType.UNDIRECTED){
           adjacencyMatrix[v2][v1] = 1;
       }
    }

    @Override
    public int findIndegree(int vertex) {
        int indegree = 0;
        for(int i = 0; i < numVertices; i++){
            if(adjacencyMatrix[i][vertex] != 0){
                indegree++;
            }
        }
        return indegree;
    }
    
    
}
