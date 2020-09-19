package com.pk.algorithms.graphs;
/**
 *
 * @author parveenkumar
 */
public interface Graph {
    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }
    void addEdge(int v1, int v2);
    int findIndegree(int vertex);
    
}
