package com.xiaolu.stack;

import org.junit.Test;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyArrayStackTest {
    @Test
    public void pop() throws Exception {
        MyArrayStack<Integer> stack=new MyArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.print(stack.getSize());
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
    }

    @Test
    public void push() throws Exception {

    }

}