package com.xiaolu.Queue;

import com.xiaolu.List.MyArrayList;

/**
 * Created by Administrator on 2016/8/13.
 * 队尾入队,队头出队
 */
public class MyQueue_2<T> {
    private MyArrayList<T> queue=new MyArrayList<T>();
    private int front;
    private int back;
    private int size;

    public MyQueue_2() {
        clear();
    }

    private void clear(){
        front=back=0;
        size=0;
    }

    public void add(T newVal){
        if(size==queue.getLength()){
            queue.ensureCapacity(size*2+1);
        }
        queue.add(back,newVal);
        back++;
        size++;
    }

    public T out(){
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T t=queue.getItem(1);
        queue.remove(1);
        back--;
        size--;
        return t;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public void show(){
        queue.show();
    }
}
