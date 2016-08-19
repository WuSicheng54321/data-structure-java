package com.xiaolu.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyArrayList<T> implements Iterable<T> {
    private final static int INIT_SIZE=10;
    private int size;//已经使用了的长度
    private int length=INIT_SIZE;
    private T[] item;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        size=0;
        ensureCapacity(INIT_SIZE);
    }

    public int getSize(){
        return size;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public void trimToSize(){
        ensureCapacity(getSize());
    }

    public T getItem(int key){
        if(key<0||key>size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return item[key-1];
    }

    public T setItem(int idx,T newVal){
        if(idx<0||idx>size){
            throw  new ArrayIndexOutOfBoundsException();
        }
        T old=item[idx];
        item[idx]=newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity<size){
            return;
        }
        T[] old=item;
        item=(T[])new Object[newCapacity];
        for(int i=0;i<size;i++) {
            item[i] = old[i];
        }
        length=newCapacity;
    }

    public void add(int idx,T newVal){
        if(item.length==size){
            ensureCapacity(size*2+1);
        }
        for(int i=size;i>idx;i--){
            item[i]=item[i-1];
        }
        item[idx]=newVal;
        size++;
    }

    public T remove(int idx){
        if(idx<0||idx>getSize()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T removeItem=item[idx-1];
        for(int i=idx-1;i<getSize();i++){
            item[i]=item[i+1];
        }
        size--;
        return removeItem;
    }

    public void show(){
/*        for(T t:item){
            System.out.print("第"+t+"个元素的值为："+t+"\n");
        }*/
        System.out.println(Arrays.asList(item));
    }

    public void append(T newVal){
        if(item.length==size){
            ensureCapacity(size*2+1);
        }
        item[getSize()]=newVal;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int current=0;

        @Override
        public boolean hasNext() {
            return current<getSize();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw  new NoSuchElementException();
            }
            return item[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
