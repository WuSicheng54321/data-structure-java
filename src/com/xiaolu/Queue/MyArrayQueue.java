package com.xiaolu.Queue;

import com.xiaolu.List.MyArrayList;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MyArrayQueue<T> {
    private T[] queue=(T[])new Object[10];
    private int front;
    private int back;
    private int size;

    public MyArrayQueue(){
        clear();
    }

    private void clear(){
        front=back=0;
        size=0;
    }

    public void add(T t){
        if(size==10){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(back<10){
            queue[back]=t;
            back++;
            size++;
            return;
        }
       else{
            back=back-10;
            queue[back]=t;
            back++;
            size++;
            return;
        }
    }

    public T out(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(front<10){
            T t=queue[front];
            queue[front]=null;
            front++;
            size--;
            return t;
       }
       else{
           front=front-10;
           T t=queue[front];
           queue[front]=null;
           front++;
           size--;
           return t;
       }
    }

    public int getSize(){
        return size;
    }

    public void show(){
        System.out.print(Arrays.toString(queue));
     }
}
