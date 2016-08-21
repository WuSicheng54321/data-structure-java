package com.xiaolu.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/21.
 */
public class SortTest {
    Sort<Integer> sort=new Sort<>();
    final static Integer[] integers=new Integer[]{1,3,5,7,9,2,4,6,8};
    @Test
    public void insertion() throws Exception {
        sort.insertion(integers);
        System.out.print(Arrays.asList(integers));
    }

    @Test
    public void selection() throws Exception {
        sort.selection(integers);
        System.out.print(Arrays.asList(integers));
    }

}