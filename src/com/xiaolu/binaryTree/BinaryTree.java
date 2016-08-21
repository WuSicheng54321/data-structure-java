package com.xiaolu.binaryTree;

import org.jetbrains.annotations.Contract;

import java.nio.BufferUnderflowException;

/**
 * Created by Administrator on 2016/8/2.
 */
public class BinaryTree<T extends  Comparable<? super T>> {
    private int depth;
    private Node<T> root;
    //树中结点,包括数据域,指向左右结点的引用域
    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;
        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public T getRootData(){
        return root.data;
    }
    //使其根结点置空
    public BinaryTree(){
        root=null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }
    //查看二叉树是否包含某个结点
    @Contract("null, _ -> false")
    private boolean contains(T x, Node<T> node){
        if(x==null){
            return false;
        }
        int compareResult=x.compareTo(node.data);
        if(compareResult<0){
            return contains(x,node.left);
        }
        else if(compareResult>0){
            return contains(x,node.right);
        }
        else{
            return true;
        }
    }

    public T findMin(){
        if(isEmpty()){
            throw  new BufferUnderflowException();
        }
        return findMin(root).data;
    }
    @Contract("null -> null")
    private Node<T> findMin(Node<T> node){
        if(node==null){
            return null;
        }
        else if(node.left==null){
            return node;
        }
        return findMin(node.left);
    }

    public T findMax(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMax(root).data;
    }
    private Node<T> findMax(Node<T> node){
        if(node!=null){
            while (node.right!=null){
                node=node.right;
            }
        }
        return node;
    }

    public void insert(T x){
        root=insert(x,root);
    }
    //递归插入结点,像插入第一个结点一样插入其他结点
    //node的值永远都是根结点,也就是说所有的插入都是根结点开始插入
    @Contract("_, null -> !null")
    private Node<T> insert(T t, Node<T> node){
        if(node==null){
            return new Node<T>(t,null,null);//create a new node
        }
        int compareResult=t.compareTo(node.data);
        if(compareResult<0){
            node.left=insert(t,node.left);
        }
        else if(compareResult>0){
            node.right=insert(t,node.right);
        }
        else{
        }
        return node;//返回根结点
    }
    public void remove(T x){
        root=remove(x,root);
    }
    @Contract("_, null -> null")
    private Node<T> remove(T t, Node<T> node){
        if(node==null){
            return node;
        }
        int compareResult=t.compareTo(node.data);
        if(compareResult<0){
            node.left=remove(t,node.left);
        }
        else if(compareResult>0){
            node.right=remove(t,node.right);
        }
        else if(node.left!=null&&node.right!=null){
            node.data=findMin(node.right).data;//删除结点的右子树中的最小元素来替代该元素
            node.right=remove(node.data,node.right);//递归删除右子树的的那个结点
        }
        else{
            node=(node.left!=null)?node.left:node.right;
        }
        return node;
    }
    public void printTree(){
    }
    public void print(){
        printTree(root);
    }
    private void printTree(Node<T> node) {
        if(node==null){//终止的语句
            return;
        }
        printTree(node.left);//递归输出左边的结点,在这里起作用的是终止的语句以及输出语句
        System.out.print(" "+node.data);//输出数据
        printTree(node.right);//递归输出右边的结点,在这里起作用的是终止的语句以及输出语句
    }
    public void insertArray(T[] array){
        for(int i=0;i<array.length;i++){
            insert(array[i]);
        }
    }

}
