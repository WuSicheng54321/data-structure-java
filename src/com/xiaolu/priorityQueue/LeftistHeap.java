package com.xiaolu.priorityQueue;

import java.nio.BufferUnderflowException;

/**
 * Created by Administrator on 2016/8/20.
 */
public class LeftistHeap<T extends Comparable<? super T>> {
    private static class Node<T>{
        T element;
        Node<T> left;
        Node<T> right;
        int npl;
        Node(T element){
            this(element,null,null);
        }
        Node(T element,Node<T> left,Node<T> right){
            this.element=element;
            this.left=left;
            this.right=right;
            npl=0;
        }
    }
    private Node<T> root;

    public LeftistHeap() {
    }
    public void merge(LeftistHeap<T> rhs){
        if(this==rhs){
            return;
        }
        root=merge(root,rhs.root);
        rhs.root=null;
    }
    public void insert(T key){
        root=merge(new Node<T>(key),root);
    }
    public T findMin(){
        return root.element;
    }
    public T deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        T minItem=root.element;
        root=merge(root.left,root.right);
        return minItem;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void makeEmpty(){
        root=null;
    }
    public void display(){
        display(root);
    }
    private void display(Node<T> node){
        if(node==null){
            return;
        }
        System.out.print(" "+node.element);
        display(node.left);
        display(node.right);
    }
    private Node<T> merge(Node<T> h1,Node<T> h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        if(h1.element.compareTo(h2.element)<0){
            return mergel(h1, h2);
        }
        else{
            return mergel(h2,h1);
        }
    }
    private Node<T> mergel(Node<T> h1,Node<T> h2){
        if(h1.left==null){
            h1.left=h2;
        }
        else{
            h1.right=merge(h1.right,h2);
            if(h1.left.npl<h1.right.npl){
                swapChildren(h1);
            }
            h1.npl=h1.right.npl+1;
        }
        return h1;
    }
    private void swapChildren(Node<T> t){
        Node<T> swap=t.right;
        t.right=t.left;
        t.left=swap;
    }
}
