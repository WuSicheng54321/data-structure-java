package com.xiaolu.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyLinkedList<T extends Comparable<? super T>> implements Iterable<T>{

    private int size;
    private int modCount=0;//对链表操作的次数
    private Node<T> begin;
    private Node<T> end;

    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        clear();
    }

    public MyLinkedList(T[] t){
        clear();
        for(int i=0;i<t.length;i++){
            this.append(t[i]);
        }
    }

    public void clear(){
        begin=new Node<T>(null,null,null);
        end=new Node<T>(null,null,null);
        begin.next=end;
        end.prev=begin;
        size=0;
        modCount++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return (getSize()==0);
    }

    public boolean add(T x){
        add(getSize(),x);
        return true;
    }

    public boolean add(int idx,T x){
        addBefore(getNode(idx),x);
        return true;
    }

    public void append(T x){
        Node<T> p=new Node<>(x,end.prev,end);
        end.prev.next=p;
        end.prev=p;
        size++;
    }


    public T set(int idx,T newVal){
        Node<T> p=getNode(idx);
        T oldVal=p.data;
        p.data=newVal;
        return oldVal;
    }

    public T remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> p, T x){
        Node<T> newNode=new Node<T>(x,p.prev,p);
        newNode.prev.next=newNode;
        p.prev=newNode;
        size++;
        modCount++;
    }

    private T remove(Node<T> p){
        p.next.prev=p.prev;
        p.prev.next=p.next;
        size--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx){
        Node<T> p;
        if(idx<=0||idx>getSize()){
            throw  new IndexOutOfBoundsException();
        }
        if(idx<getSize()/2){
            p=begin.next;
            for(int i=1;i<idx;i++){
                p=p.next;
            }
        }
        else{
            p=end.prev;
            for(int i=getSize()-1;i>idx-1;i--){
                p=p.prev;
            }
        }
        return p;
    }
    public Node<T> sort(){
        Node<T> p=begin.next;
        Node<T> i;
        Node<T> j;
        for(i=p;i.next!=null;i=i.next){
            for(j=i.next;j.next!=null;j=j.next){
                T swap=i.data;
                i.data=j.data;
                j.data=swap;
            }
        }
        return p;
    }

    public void show(){
        Node<T> p=begin;
        while(p!=end.next){
            System.out.print(" "+p.data);
            p=p.next;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current= begin.next;
        private int expectModCount=modCount;
        private boolean okToRemove=false;


        @Override
        public boolean hasNext() {
            return current!=end;
        }

        @Override
        public T next() {
            if(modCount!=expectModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T nextItem=current.data;
            current=current.next;
            okToRemove=true;
            return nextItem;
        }

        @Override
        public void remove() {
            if(modCount!=expectModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove=false;
            expectModCount++;
        }
    }
}
