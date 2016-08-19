package com.xiaolu.Stack;

import com.xiaolu.List.MyArrayList;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyArrayStack<T>{
    private MyArrayList<T> stack=new MyArrayList<T>();
    private T bottom;
    private T top;

    public MyArrayStack() {
        clear();
    }

    public boolean isEmpty(){
        return top.equals(bottom);
    }

    public T pop(){
        T p=stack.getItem(stack.getSize());
        stack.remove(stack.getSize());
        top=stack.getItem(stack.getSize());
        return p;
    }

    public void push(T t){
        stack.append(t);
        top=stack.getItem(stack.getSize());
    }

    public void clear(){
        T t=(T)new Object();
        stack.append(t);
        bottom=t;
        top=bottom;
    }

    public int getSize(){
        return stack.getSize()-1;
    }

}
