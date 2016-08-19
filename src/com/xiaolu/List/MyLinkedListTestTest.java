package com.xiaolu.List;

import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyLinkedListTestTest {
    @Test
    public void testLinkedList(){
        MyLinkedList<Integer> linkedList=new MyLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);
        linkedList.append(9);
        linkedList.append(10);
        linkedList.append(11);
        linkedList.append(12);
        linkedList.append(13);
        Iterator<Integer> iterator = linkedList.iterator();
        iterator.next();
        iterator.remove();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }





/*        linkedList.add(1,0);
        linkedList.remove(1);
        linkedList.set(7,0);
        System.out.println(linkedList.getSize());
        linkedList.show();*/
    }

}