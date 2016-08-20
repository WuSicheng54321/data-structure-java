package com.xiaolu.priorityQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/20.
 */
public class LeftistHeapTest {
    @Test
    public void test(){
        LeftistHeap<Integer> leftistHeap=new LeftistHeap<>();
        leftistHeap.insert(1);
        leftistHeap.insert(2);
        leftistHeap.insert(3);
        leftistHeap.insert(4);
        leftistHeap.insert(5);
        leftistHeap.insert(6);
        leftistHeap.insert(7);
        leftistHeap.insert(8);
        leftistHeap.insert(9);
        leftistHeap.display();
        leftistHeap.deleteMin();
        System.out.print("\n");
        leftistHeap.display();
    }

}