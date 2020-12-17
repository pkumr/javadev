/*
 * Basic Structure of Union Find.
 */
package com.pk.algorithms.unionfind;

/**
 *
 * @author parveenkumar
 */
public class UnionFind {
    //id array is used to make sets
    private final int[] id;
    //size array will have values
    private final int[] size;
    //count is number of sets.
    private int count;
    
    public UnionFind(int length){
        id = new int[length];
        size = new int[length];
        for(int i = 0; i < length; i++){
            //initially all value of id are marked 0,1,2,3,4.. length
            //each element is parent of its own initially
            id[i] = i;
            //intially all values of size will be 1.
            size[i] = 1;
        }
        //count is number of sets.
        count = length;
    }
    public int size(){
        return count;
    }
    public int findRoot(int i){
        while(i != id[i]){
            id[i] = id[id[i]];// path compression
            i = id[i];
        }
        return i;
    }
    public boolean isRootSame(int p, int q){
        return findRoot(p) == findRoot(q);
    }
    public void union(int p, int q){
        int pi = findRoot(p);
        int qi = findRoot(q);
        //Element has bigger value will become parent
        //if root value qi > root value pi
        //id of pi = qi (id is having parent value)
        if(size[pi] < size[qi]){
            id[pi] = qi;
            size[qi] += size[pi];
        }else{
            id[qi] = pi;
            size[pi] += size[qi];
        }
        count--;
    }
    
}
