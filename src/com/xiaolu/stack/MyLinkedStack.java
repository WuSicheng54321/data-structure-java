package com.xiaolu.stack;

import com.xiaolu.list.MyArrayList;

/**
 * Created by Administrator on 2016/7/30.
 */
public class MyLinkedStack<T> {
    MyArrayList<T> stack=new MyArrayList<T>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(T t){
        stack.append(t);
    }

    public T pop(){
        T p=stack.getItem(stack.getSize());
        stack.remove(stack.getSize());
        return p;
    }

    public  void show(){
        stack.show();
    }

}
