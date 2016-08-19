package com.xiaolu.BinaryTree;

/**
 * Created by Administrator on 2016/8/13.
 */
public class AVLTree<T extends Comparable<? super T>>{
    private AVLNode<T> root;
    public AVLTree(){
        root=null;
    }

    private int depth(AVLNode<T> avlNode){
        return avlNode==null?-1:avlNode.depth;
    }

    public void insert(T t){
        root=insert(t,root);
    }

    private AVLNode<T> insert(T t,AVLNode<T> avlNode){
        if(avlNode==null){
            return new AVLNode<T>(t,null,null);//如果是空的话,就直接插入
        }
        int compareResult=compare(t,avlNode.data);
        if(compareResult<0){
            avlNode.left=insert(t,avlNode);//和二叉搜索树的插入一致,递归调用插入函数
            //不符合AVL的原则
            if(depth(avlNode.left)-depth(avlNode.right)==2){
                /*比较某结点的左子树结点数据,
                    avlNode表示为危机结点,
                    如果t小于危机结点的左子树的数据结点,
                    那么他插入到左子树,形成LL要进行LL旋转*/
                if(compare(t,avlNode.left.data)<0){
                    avlNode=rotateWithLeftChild(avlNode);//LL旋转
                }
                else{
                    avlNode=doubleWithLeftChild(avlNode);//LR双旋
                }
            }
        }
        else if(compareResult>0){
            avlNode.right=insert(t,avlNode.right);
            if(depth(avlNode.right)-depth(avlNode.left)==2){
                if(compare(t,avlNode.right.data)>0){
                    avlNode=rotateWithRightChild(avlNode);
                }
                else{
                    avlNode=doubleWithRightChild(avlNode);
                }
            }
        }
        else{}
        avlNode.depth=Math.max(depth(avlNode.right),depth(avlNode.left))+1;
        return avlNode;
    }

    /**
     * k2是危机结点,其平衡因子为-2,k1是k2的左子树结点,其平衡因子为-1
     * k1的右子树`在k2的左子树
     * k2挂在k1的右子树
     * k2的深度是左右子树的最大值深度加一
     * k1的深度是k1的左子树(本来有的),k2的深度(后来挂上的)加一
     * 返回k1表示k1是最后的根结点
     */
    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2){
        AVLNode<T> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.depth=Math.max(depth(k2.left),depth(k2.right))+1;
        k1.depth=Math.max(depth(k1.left),k2.depth)+1;
        return k1;
    }
    /**
     * k3是危机结点
     * 先对k3的左子树结点进行右旋
     * 对k3进行左旋
     */
    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3){
        k3.left=rotateWithRightChild(k3.left);//右旋后左旋
        return rotateWithLeftChild(k3);
    }

    //not checking
    private AVLNode<T> rotateWithRightChild(AVLNode<T> k2){
        AVLNode<T> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.depth=Math.max(depth(k2.left),depth(k2.right))+1;
        k1.depth=Math.max(depth(k1.right),k2.depth)+1;
        return k1;
    }

    //RL
    private AVLNode<T> doubleWithRightChild(AVLNode<T> k3){
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private int compare(T t1,T t2){
        if(t1.compareTo(t2)>0){
            return 1;
        }
        else if(t1.compareTo(t2)<0){
            return -1;
        }
        return 0;
    }

    public void display(){
        display(root);
    }

    private void display(AVLNode<T> avlNode){
        if(avlNode==null){
            return;
        }
        display(avlNode.left);
        System.out.print(avlNode.data);
        display(avlNode.right);
    }

    private static class AVLNode<T>{
        T data;
        AVLNode<T> left;
        AVLNode<T> right;
        int depth;//表示一个结点的深度

        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int depth) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.depth =0;
        }

        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


}
