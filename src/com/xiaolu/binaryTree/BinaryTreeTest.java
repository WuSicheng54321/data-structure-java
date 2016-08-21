package com.xiaolu.binaryTree;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/8/12.
 */
public class BinaryTreeTest {
    final Logger LOGGER= LoggerFactory.getLogger(BinaryTreeTest.class);
    @Test
    public void insert() throws Exception {
        BinaryTree<Integer> integerBinaryTree=new BinaryTree<>();
        integerBinaryTree.insert(1);
        integerBinaryTree.insert(1);
        integerBinaryTree.insert(3);
        integerBinaryTree.insert(4);
        integerBinaryTree.insert(5);
        integerBinaryTree.insert(6);
        LOGGER.info(integerBinaryTree.getRootData().toString());
        integerBinaryTree.print();
    }
}