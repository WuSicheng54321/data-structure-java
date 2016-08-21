package com.xiaolu.list;


import java.util.Iterator;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyArrayListTest {
    @org.junit.Test
    public void add() throws Exception {
        MyArrayList<Integer> arrayList=new MyArrayList<>();
        arrayList.append(1);
        arrayList.append(2);
        arrayList.append(3);
        arrayList.append(4);
        arrayList.append(5);
        arrayList.append(6);
        arrayList.append(7);
        arrayList.append(8);
        arrayList.append(9);
        arrayList.append(10);
        arrayList.append(11);
        arrayList.append(12);
        arrayList.append(13);
        arrayList.append(14);
        arrayList.append(15);
        arrayList.show();
        arrayList.remove(1);
        arrayList.show();
        arrayList.getSize();
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}