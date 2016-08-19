package com.xiaolu.Hash;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/16.
 */
public class SeparateChainingHashTable<T> {
    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public SeparateChainingHashTable(int size){
        theLists=new LinkedList[nextPrime(size)];
        for(int i=0;i<theLists.length;i++){
            theLists[i]=new LinkedList<T>();
        }
    }
    public void insert(T t){
        List<T> list=theLists[myhash(t)];
        if(!list.contains(t)){
            list.add(t);
            if(++currentSize>theLists.length){
                rehash();
            }
        }
    }
    public void remove(T t){

    }
    public boolean contains(T t){
        List<T> list=theLists[myhash(t)];

        return list.contains(t);
    }
    public void makeEmpty(){
        for(int i=0;i<theLists.length;i++){
            theLists[i].clear();
        }
    }
    private static final int DEFAULT_TABLE_SIZE=101;
    private List<T>[] theLists;
    private int currentSize;
    private void rehash(){

    }
    private int myhash(T t){
        int hashVal=t.hashCode();
        hashVal%=theLists.length;
        if(hashVal<0){
            hashVal+=theLists.length;
        }
        return hashVal;
    }
    private static int nextPrime(int n){
        return 0;
    }
    private static boolean isPrime(int n){
        return false;
    }
}
