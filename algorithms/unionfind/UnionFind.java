/*
 * Basic Structure of Union Find.
 */
package com.pk.algorithms.unionfind;

/**
 *
 * @author parveenkumar
 */
public class UnionFind {
    private final int[] id;
    private final int[] size;
    private int count;
    
    public UnionFind(int length){
        id = new int[length];
        size = new int[length];
        for(int i = 0; i < length; i++){
            id[i] = i;
            size[i] = 1;
        }
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
