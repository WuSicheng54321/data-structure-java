package com.xiaolu.binaryTree;

import org.junit.Test;

/**
 * Created by Administrator on 2016/8/14.
 */
public class AVLTreeTest {
    @Test
    public void display() throws Exception {
        AVLTree<Integer> avlTree=new AVLTree<>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.display();
    }

}