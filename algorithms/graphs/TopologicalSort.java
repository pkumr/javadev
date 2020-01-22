/*
 * Basic Toplogical Sort Implementation
 * Graph Datastructure - Adjacency List
 * Indegree Storage - HashTable
 * Interate the input - Queue
 */
package com.pk.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author parveenkumar
 */
public class TopologicalSort {
    private LinkedList<Integer>[] adjacencyList;
    private int numberOfVertices;
 
    private List<Integer> output;
    
    public TopologicalSort(int noOfVertices){
        this.numberOfVertices = noOfVertices;
        adjacencyList = new LinkedList[noOfVertices];
        for(int i = 0; i < noOfVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int target){
        adjacencyList[source].add(target);
    }
    public int getIndegree(int vertex) {
        int indegree = 0;
        for(int i = 0; i < numberOfVertices; i++){
            if(adjacencyList[i].contains(vertex)){
                indegree++;
            }
        }
        return indegree;
    }
    
     public void topologicalSort(){
        output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>(); 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numberOfVertices; i++){
            int indegree = getIndegree(i);
            map.put(i, indegree);
            if(indegree == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.remove();
            output.add(node);
            for(int i = 0; i < adjacencyList[node].size(); i++){
                map.put(adjacencyList[node].get(i), map.get(adjacencyList[node].get(i)) - 1);
                if(map.get(adjacencyList[node].get(i)) == 0){
                    queue.add(adjacencyList[node].get(i));
                }
            }
        }
        if(output.size() == numberOfVertices)
           for(int out : output)
                System.out.println(out + "-->");
        else
            System.out.println("Graph has cycles");
        
     }
     public static void main_TS(String[] args){
        TopologicalSort obj = new TopologicalSort(7);
        /*
        
       0-- 2--6--1
         \     /
          5--4
              \
               3
        
        It should Print -->
        
        */
        
        obj.addEdge(6, 1);
        obj.addEdge(4, 3);
        obj.addEdge(4, 6);
        obj.addEdge(5, 4);
        obj.addEdge(2, 6);
        obj.addEdge(0, 2);
        obj.addEdge(0, 5);
        //obj.addEdge(0, 1);
        obj.topologicalSort();
     }
}
