package com.xiaolu.sort;

import com.xiaolu.List.MyLinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/20.
 */
public class insertionTest {
    @Test
    public void test(){
        Integer[] integers=new Integer[]{9,7,8,6,5,4,3,2,1};
        System.out.print(Arrays.asList(integers));
        Insertion<Integer> insertion=new Insertion<>();
        insertion.sort(integers);
        System.out.print(Arrays.asList(integers));
    }

}