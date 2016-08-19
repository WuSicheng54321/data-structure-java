package com.xiaolu.Queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyQueue_2Test {
    @Test
    public void add() throws Exception {
        MyQueue_2<Integer> queue_2=new MyQueue_2<>();
        queue_2.add(1);
        queue_2.add(2);
        queue_2.add(3);
        queue_2.add(4);
        queue_2.add(5);
        queue_2.add(6);
        queue_2.add(7);
        queue_2.add(8);
        queue_2.add(9);
        queue_2.add(10);
        queue_2.add(11);
        queue_2.add(12);
        queue_2.add(13);
        queue_2.add(14);
        queue_2.add(15);
        queue_2.out();
        queue_2.out();

        queue_2.show();
    }

}