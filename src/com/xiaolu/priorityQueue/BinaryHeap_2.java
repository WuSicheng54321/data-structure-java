package com.xiaolu.priorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/18.
 *最大堆,上面的大,下面的小
 *
 */
public class BinaryHeap_2<T extends Comparable<? super T>> {
    final Logger LOGGER= LoggerFactory.getLogger(BinaryHeap_2.class);
    private int size;
    private T[] array;
    final static int DEFALT_NUM=10;
    public BinaryHeap_2() {
        init();
    }
    public BinaryHeap_2(T[] array){
        init();
        for(T t:array){
            this.insert(t);
        }
    }
    public void insert(T key){
        if(size==array.length){
            ensureCapation(size*2+1);
        }
        if(contain(key)){
            LOGGER.info("this key "+key+" is in the BinaryHeap");
            return;
        }
        array[size]=key;
        size++;
        int hole=size-1;
        //hole下面,(hole-1)/2上面,那么就进行交换
        while(array[hole].compareTo(array[(hole-1)/2])>0){
            T swap=array[hole];
            array[hole]=array[(hole-1)/2];
            array[(hole-1)/2]=swap;
            hole=(hole-1)/2;
        }
    }
    public T removeMax(){
        try {
            T key = array[0];
            array[0] = array[size - 1];
            array[size - 1] = null;
            size--;
            int hole = 0;
            while ((array[(hole + 1) * 2] != null && array[(hole + 1) * 2 - 1] != null) && (array[hole].compareTo(array[(hole + 1) * 2]) < 0 || array[hole].compareTo(array[(hole + 1) * 2 - 1]) < 0)) {
                if (array[(hole + 1) * 2].compareTo(array[(hole + 1) * 2 - 1]) > 0) {
                    T swap = array[hole];
                    array[hole] = array[(hole + 1) * 2];
                    array[(hole + 1) * 2] = swap;
                    hole = (hole + 1) * 2;
                } else {
                    T swap = array[hole];
                    array[hole] = array[(hole + 1) * 2 - 1];
                    array[(hole + 1) * 2 - 1] = swap;
                    hole = (hole + 1) * 2 - 1;
                }
            }
            return key;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("remove err,because the Binary Tree is null");
        }
    }
    public boolean contain(T key){
        for(int i=0;i<size;i++){
            if(key.compareTo(array[i])==0){
                return true;
            }
        }
        return false;
    }
    private void init(){
        ensureCapation(DEFALT_NUM);
        size=0;
    }
    private void ensureCapation(int length){
        if(array==null){
            array= (T []) new Comparable[DEFALT_NUM];
            return;
        }
        if(length<array.length){
            return;
        }
        T[] old=array;
        array= (T[]) new Comparable[length];
        for(int i=0;i<old.length;i++){
            array[i]=old[i];
        }
    }
    public void display(){
        System.out.print(Arrays.asList(array));
    }
}
