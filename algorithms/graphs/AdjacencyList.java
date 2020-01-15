/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pk.algorithms.graphs;
import java.util.LinkedList;
/**
 *
 * @author parveenkumar
 */
public class AdjacencyList implements Graph{
    int numVertices = 0;
    private LinkedList<Integer>[] adjacencyList;
    private GraphType graphType = GraphType.DIRECTED;
    
    public AdjacencyList(int numOfVertices, GraphType graphType){
        this.numVertices = numOfVertices;
        adjacencyList = new LinkedList[numOfVertices];
        for(int i = 0; i < numOfVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    @Override
    public void addEdge(int v1, int v2) {
        adjacencyList[v1].add(v2);
        if(graphType == GraphType.UNDIRECTED){
            adjacencyList[v2].add(v1);
        }
    }
    

    @Override
    public int findIndegree(int vertex) {
        int indegree = 0;
        for(int i = 0; i < numVertices; i++){
            if(adjacencyList[i].contains(vertex)){
                indegree++;
            }
        }
        return indegree;
    }
    
}
