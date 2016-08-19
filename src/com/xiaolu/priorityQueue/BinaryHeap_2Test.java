package com.xiaolu.priorityQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/18.
 */
public class BinaryHeap_2Test {
    @Test
    public void display(){
//        BinaryHeap_2<Integer> binaryHeap2=new BinaryHeap_2<>();
        BinaryHeap_2<Integer> binaryHeap_2=new BinaryHeap_2<>(new Integer[]{1,2,3,4,5,6,7,8,9});
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();
        binaryHeap_2.removeMax();

/*        binaryHeap2.insert(1);
        binaryHeap2.insert(2);
        binaryHeap2.insert(3);
        binaryHeap2.insert(4);
        binaryHeap2.insert(5);
        binaryHeap2.insert(6);
        binaryHeap2.insert(7);
        binaryHeap2.insert(8);
        binaryHeap2.removeMax();

        binaryHeap2.insert(9);
        binaryHeap2.insert(10);
        binaryHeap2.insert(11);
        binaryHeap2.insert(12);
        binaryHeap2.insert(13);
        binaryHeap2.insert(14);*/
        binaryHeap_2.display();
    }


}