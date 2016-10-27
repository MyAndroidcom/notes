package com.ch08tree;

/**
 * Created by xhp on 2016/10/20.
 */
public class Tree {
    //根节点
    public Node root;

    //插入节点
    public void insert(long value, String sValue) {
        //封装节点
        Node newNode = new Node(value, sValue);
        //引用当前节点
        Node current = root;
        //父节点
        Node parent;
        //第一次插入root为空
        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                //父节点指向当前节点
                parent = current;
                if (current.data > value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /*
    * 查找节点
    * */
    public Node find(long value) {
        //从根节点开始
        Node current = root;
        //循环
        while (current.data != value) {
            //进行比较
            if (current.data > value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /*
    * 前序遍历
    * */
    public void frontOrder(Node localNode) {
        if (localNode != null) {
            //访问根节点
            System.out.println(localNode.data + "," + localNode.sData);
            //遍历左子树
            frontOrder(localNode.leftChild);
            //右子树
            frontOrder(localNode.rightChild);
        }
    }
        /*
        * 中序遍历
        * */

    public void inOrder(Node localNode) {
        if (localNode != null) {
            //中序遍历左子树
            inOrder(localNode.leftChild);
            //访问根节点
            System.out.println(localNode.data + ", " + localNode.sData);
            //中旬遍历右子树
            inOrder(localNode.rightChild);
        }

    }

    /*
           * 后序遍历
           * */
    public void afterOrder(Node localNode) {
        if (localNode != null){
        //后序遍历
            afterOrder(localNode.leftChild);
            afterOrder(localNode.rightChild);
            System.out.println(localNode.data+","+localNode.sData);
    }
    }


    /**
     * 删除节点
     */
    public boolean delete(long value) {
        //引用当前节点，从根节点开始
        Node current = root;

        //应用当前节点的父节点
        Node parent = root;
        //是否为左节点
        boolean isLeftChild = true;

        while(current.data != value) {
            parent = current;
            //进行比较，比较查找值和当前节点的大小
            if(current.data > value) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            //如果查找不到
            if(current == null) {
                return false;
            }
        }

        //删除叶子节点，也就是该节点没有子节点
        if(current.leftChild == null && current.rightChild == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(current.rightChild == null) {
            if(current == root) {
                root = current.leftChild;
            }else if(isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if(current.leftChild == null) {
            if(current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.leftChild = successor;
            } else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }

        return true;


    }

    public Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rightChild;

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
