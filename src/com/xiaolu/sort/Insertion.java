package com.xiaolu.sort;

import com.xiaolu.List.MyLinkedList;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Insertion<T extends Comparable<? super T>> {
    public T[] sort(T[] t){
        int i;
        int j;
        for(i=0;i<t.length;i++){
            for(j=i+1;j<t.length;j++){
                if(t[i].compareTo(t[j])>0){
                    T swap=t[i];
                    t[i]=t[j];
                    t[j]=swap;
                }
            }
        }
        return t;
    }
    public T[] changeToArray(MyLinkedList<T> myLinkedList){
        T[] t= (T[]) new Comparable[myLinkedList.getSize()];
        int i=0;
        while(myLinkedList.iterator().hasNext()){
            t[i++]=myLinkedList.iterator().next();
        }
       return t;
    }
}
