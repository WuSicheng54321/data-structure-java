package com.xiaolu.queue;

import org.junit.Test;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MyArrayQueueTest {
    @Test
    public void add() throws Exception {
        MyArrayQueue<Integer> queue=new MyArrayQueue<>();
        queue.add(1);
        queue.out();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.out();
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.show();

    }

}