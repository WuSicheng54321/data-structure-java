package com.xiaolu.sort;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/21.
 */
public class SortTest {
    Sort<Integer> sort=new Sort<>();
    final static Integer[] integers=new Integer[]{1,3,5,7,9,2,4,6,8};
    Sort<Double> doubleSort=new Sort<>();
    final static Double[] doubles=new Double[100000];
    public void init(){
      for(int i=0;i<doubles.length;i++){
          doubles[i]=Math.random()*100000;
      }
    }
    @Test
    public void insertion() throws Exception {
        /*sort.insertion_2(integers);
        System.out.print(Arrays.asList(integers));*/
        init();
        doubleSort.insertion(doubles);
        System.out.print(Arrays.asList(doubles));
}

    @Test
    public void selection() throws Exception {
        /*sort.selection(integers);
        System.out.print(Arrays.asList(integers));*/
        init();
        doubleSort.selection(doubles);
        System.out.print(Arrays.asList(doubles));
    }

    @Test
    public void shell() throws Exception{
        /*sort.shell(integers);
        System.out.print(Arrays.asList(integers));*/
        init();
        doubleSort.shell(doubles);
        System.out.print(Arrays.asList(doubles));
    }

}