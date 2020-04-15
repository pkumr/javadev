package com.revision.basics;
/*
* Union Find | Disjoint Set
* */
public class _24_UnionFind {
    public static void main(String[] args){

    }
    public static class UnionFind {
        //Initially each element is parent of
        private int[] parent;

        // rank is the number representing level of parent/element of sets.
        // Initially rank will be equal to total number of elements
        private int[] rank;

        // Count is number sets. Initially it will be no of elements
        private int count;
        //Constructor. length is equal to total number of elements

        public UnionFind(int length){
            parent = new int[length];
            rank = new int[length];
            for(int i = 0; i < length; i++){
                //marking parent of all elements as 0 to len(length)
                parent[i] = i;
                //initially rank of each set is 1 (containing one element)
                rank[i] = 1;
            }
            //number (count) of sets is length initially
            count = length;
        }
        //Find element by Rank (along with compression)
        public int find(int p){
            //In Constructor we assigned i = id[i] to all elements
            //So when union merges the subset, id[position] = position for root will not change
            //lets say we use the example in union and from set (0, 1)
            //we have to find root of 1
            while (p != parent[p]){
                //Path Compression is implemented here
                parent[p] = parent[parent[p]];
                //follow link to find the root!
                p = parent[p];
            }
            return p;
        }
        public boolean connected(int p, int q){
            //If root of both elements is same, then they are connected!
            return find(p) == find(q);
        }
        //Method to merge elements and make sets!
        public void union(int p, int q){
            //Let's say we have elements 0, 1, 2, 3, 4
            //and we have to perform union of 1, 2
            //And Lets say we have already performed union(0,1) in prev step
            //now we have one set (0, 1) and lets say 0 is root
            //and we have to merger 1 and 2.
            //pi = root(p) ==> 0
            int pi = find(p);
            int qi = find(q);
            if(rank[pi] < rank[qi]){
                //if size of pi is less than size of qi
                //we update id of pi equal to qi
                parent[pi] = qi;
                //size of qi is increased because qi is merged with pi
                rank[qi] += rank[pi];
            }else {
                parent[qi] = pi;
                rank[pi] += rank[qi];
            }
            //Decrease the count as two sets are merged and number of sets decreased by 1
            count--;
        }
        public int count(){
            return count;
        }
    }
    //## Example - 1: Find Common Friends on Social Network using Union Find
    

}
