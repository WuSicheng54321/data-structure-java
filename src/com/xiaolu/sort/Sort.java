package com.xiaolu.sort;

import com.xiaolu.list.MyLinkedList;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Sort<T extends Comparable<? super T>> {

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(Comparable[] a){
        System.out.println(Arrays.asList(a));
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    //插入排序,由后面无序的向前面有序的插入,这根本不是插入排序
/*    public T[] insertion(T[] t){
        int i;
        int j;
        for(i=0;i<t.length;i++){
            for(j=i+1;j<t.length;j++){
                if(t[i].compareTo(t[j])<0){
                    T swap=t[i];
                    t[i]=t[j];
                    t[j]=swap;
                }
            }
        }
        return t;
    }*/
    public T[] insertion(T[] t){
        int N=t.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(t[j],t[j-1]);j--){//j和j-1比较,如果j<j-1的,那么就交换
                exch(t,j,j-1);//交换数组t中j和j-1的元素
            }
        }
        return t;
    }
    public T[] insertion_2(T[] t){
        int N=t.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0;j--){
                if(t[j].compareTo(t[j-1])<0){
                    T swap=t[j];
                    t[j]=t[j-1];
                    t[j-1]=swap;
                }
            }
        }
        return t;
    }
    //选择排序,选择最小的元素放到前面进行排序
/*    public T[] selection(T[] t){
        int i;
        int j;
        int k;
        for(i=0;i<t.length;i++){
            T min=t[i];
            k=i;
            for(j=i+1;j<t.length;j++){
                if(min.compareTo(t[j])<0){
                    min=t[j];
                    k=j;
                }
            }
            T swap=t[i];
            t[i]=min;
            t[k]=swap;
        }
        return t;
    }*/
    public T[] selection(T[] t){
        int N=t.length;
        for(int i=0;i<N;i++){
           int min=i;
            for(int j=i+1;j<N;j++){
                if(less(t[j],t[min])){
                    exch(t,i,min);
                }
            }
        }
        return t;
    }
    //希尔排序
    public void shell(Comparable[] a){
        int N=a.length;
        int h=1;
        while(h<N/3){//找到最大的间隔
            h=3*h+1;
        }
        //当h大于等于1的时候
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){//还是交换,但是交换的跨度增大
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }
    }







    public T[] changeToArray(MyLinkedList<T> myLinkedList){
        T[] t= (T[]) new Comparable[myLinkedList.getSize()];
        int i=0;
        while(myLinkedList.iterator().hasNext()){
            t[i++]=myLinkedList.iterator().next();
        }
       return t;
    }
}
