package com.xiaolu.priorityQueue;

import java.nio.BufferUnderflowException;

/**
 * Created by Administrator on 2016/8/18.
 */
public class BinaryHeap<T extends Comparable<? super T>>  {
    private static final int DEFAULT_CAPACITY=10;
    private int currentSize;
    private T[] array;
    public BinaryHeap(){

    }
    public BinaryHeap(int capacity){

    }
    public BinaryHeap(T[] items){
        currentSize=items.length;
        array=(T[])new Comparable[(currentSize+2)*11/10];
        int i=1;
        for(T item:items){
            array[i++]=item;
        }
        buildHeap();
    }
    /**
     * 任意元素i,其左儿子在2i处,右儿子在2i+1处,父亲在i/2处
     */
    public void insert(T t){
        if(currentSize==array.length-1){
            enlargeArray(array.length*2+1);
        }
        int hole=++currentSize;//创建了新的结点,这个结点就在要插入的位置上面
        //比较t和上面的结点,做上滤的操作
        for(;hole>1&&t.compareTo(array[hole/2])<0;hole/=2){
            array[hole]=array[hole/2];
        }
        array[hole]=t;
    }
    public T findMin(){
        return array[1];
    }
    public T deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        T t=findMin();
        array[1]=array[currentSize--];
        percolateDown(1);
        return t;
/*        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        T t=findMin();
        array[1]=array[currentSize--];
        int hole=1;
        while(array[hole].compareTo(array[2*hole])>0||array[hole].compareTo(array[2*hole+1])>0){
            if (array[2*hole].compareTo(array[2*hole+1])<0){
                T swap=array[hole];
                array[2*hole]=array[hole];
                array[hole]=swap;
                hole=2*hole;
            }
            else{
                T swap=array[hole];
                array[2*hole+1]=array[hole];
                array[hole]=swap;
                hole=2*hole+1;
            }
        }
        return */
    }
    public boolean isEmpty(){
        return currentSize==0;
    }
    public void makeEmpty(){

    }
    private void percolateDown(int hole){
        int child;
        T temp=array[hole];
        for(;hole*2<=currentSize;hole=child){
            child=hole*2;
            if(child!=currentSize&&array[child+1].compareTo(array[child])<0){
                child++;
            }
            if(array[child].compareTo(temp)<0){
                array[hole]=array[child];
            }
            else{
                break;
            }
        }
        array[hole]=temp;
    }
    private void buildHeap(){
        for(int i=currentSize/2;i>0;i--){
            percolateDown(i);
        }
    }
    private void enlargeArray(int newSize){
        T[] old=array;
        array=(T[])new Object[newSize];
        for(int i=0;i<old.length;i++){
            array[i]=old[i];
        }
    }
}
