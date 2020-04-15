package com.revision.basics;
/*
* Union Find | Disjoint Set
* */
public class _24_UnionFind {
    public static class UnionFind {
        //id is used to identify single element
        private int[] id;
        // size is number of sets. Initially size will be equal
        // to total number of elements
        private int[] size;
        // Count is number of elements
        private int count;
        //Constructor. length is equal to total number of elements
        public UnionFind(int length){
            id = new int[length];
            size = new int[length];
            for(int i = 0; i < length; i++){
                //marking id of all elements as 0 to len(length)
                id[i] = i;
                //initially size of each set is 1 (containing one element)
                size[i] = 1;
            }
            //number (count) of sets is length initially
            count = length;
        }
        //Find Root by Rank (along with compression)
        public int root(int i){
            //In Constructor we assigned i = id[i] to all elements
            //So when union merges the subset, id[position] = position for root will not change
            //lets say we use the example in union and from set (0, 1)
            //we have to find root of 1
            while (i != id[i]){
                //Path Compression is implemented here
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public void union(int p, int q){
            //Let's say we have elements 0, 1, 2, 3, 4
            //and we have to perform union of 1, 2
            //And Lets say we have already performed union(0,1) in prev step
            //now we have one set (0, 1) and lets say 0 is root
            //and we have to merger 1 and 2.
            //pi = root(p) ==> 0
            int pi = root(p);
            int qi = root(q);
            if(size[pi] < size[qi]){
                //if size of pi is less than size of qi
                //we update id of pi equal to qi
                id[pi] = qi;
                //size of qi is increased because qi is merged with pi
                size[qi] += size[pi];
            }else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
            //Decrease the count as two sets are merged and number of sets decreased by 1
            count--;
        }
    }
}
