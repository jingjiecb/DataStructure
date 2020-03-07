package BinarySearchTree;

import Queue.QueueLi;
import Stack.StackLi;

public class BinarySearchTree {
    //二叉树的左子节点<根<右子节点
    private BinaryNode root;



    /*
     * 构造方法
     *
     */

    public BinarySearchTree(){
        root=null;
    }




    /*
     * 管理方法
     *
     */

    public void makeEmpty(){
        root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    private Comparable elementAt(BinaryNode t){
        return t==null?null:t.element;
    }




    /*
     * 匹配方法
     *
     */
    public Comparable find(Comparable x){
        return elementAt(find(x,root));
    }

    private BinaryNode find(Comparable x,BinaryNode t){
        if (t==null) return null;
        if (x.compareTo(t.element)<0){
            return find(x,t.left);
        }
        else if (x.compareTo(t.element)>0){
            return find(x,t.right);
        }
        else return t;//Match
    }

    public Comparable findMin(){
        return elementAt(findMin(root));
    }

    private BinaryNode findMin(BinaryNode t){
        if (t==null){
            return null;
        }
        else if (t.left==null){
            return t;
        }
        else return findMin(t.left);
    }

    public Comparable findMax(){
        return elementAt(findMax(root));
    }

    private BinaryNode findMax(BinaryNode t){
        if (t==null){
            return null;
        }
        else if (t.left==null){
            return t;
        }
        else return findMax(root);
    }





    /*
     * 重构方法：
     * 插入新节点
     * 删除节点
     *
     */
    private BinaryNode insert(Comparable x,BinaryNode t){
        if (t==null){
            t=new BinaryNode(x);
        }
        else if (x.compareTo(t.element)<0){
            t.left=insert(x,t.left);
        }
        else if (x.compareTo(t.element)>0){
            t.right=insert(x,t.right);
        }
        else {
            System.out.println("The element is already in the tree!");
        }
        return t;
    }

    public void insert(Comparable x){
        root=insert(x,root);
    }

    private BinaryNode remove(Comparable x,BinaryNode t){
        if (t==null) return t;//子树为空，不可能删的掉任何元素。直接返回。

        if (x.compareTo(t.element)<0){
            t.left=remove(x,t.left);
        }
        else if (x.compareTo(t.element)>0){
            t.right=remove(x,t.right);
        }
        else if (t.left!=null && t.right!=null){
            t.element=findMin(t.right).element;//此处也可以是t.element=findMax(t.left).element;
            t.right=remove(t.element,t.right);
        }
        else{
            t=(t.left!=null)?t.left:t.right;
        }
        return t;
    }

    public void remove(Comparable x){
        root=remove(x,root);
    }





    /*
     * 测试用的遍历代码
     */

    //LevelOrder Print without recursive call.
    public void LOprint(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        QueueLi queueLi=new QueueLi();
        queueLi.enqueue(root);
        BinaryNode current;
        while (!queueLi.isEmpty()){
            current=(BinaryNode) queueLi.dequeue();
            System.out.print(current.toString()+"  ");
            if (current.left!=null) queueLi.enqueue(current.left);
            if (current.right!=null) queueLi.enqueue(current.right);
        }
        System.out.println();
    }

    //PreOrder Print without recursive call.
    public void POprint(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        StackLi stackLi=new StackLi();
        stackLi.push(root);
        BinaryNode current;
        while (!stackLi.isEmpty()){
            current=(BinaryNode)stackLi.topAndPop();
            System.out.print(current.toString()+"  ");
            if (current.right!=null) stackLi.push(current.right);
            if (current.left!=null) stackLi.push(current.left);
        }
        System.out.println();
    }

    //InOrder Print without recursive call.
    public void IOprint(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        StackLi stackLi=new StackLi();
        BinaryNode current=root;
        while (true) {
            while (current != null) {//找到以current为树根的子树最左边的点
                stackLi.push(current);
                current = current.left;
            }

            if (!stackLi.isEmpty()) {
                current = (BinaryNode) stackLi.topAndPop();
                System.out.print(current.toString() + "  ");
                current = current.right;//访问这个顶点，然后处理这个顶点的右子树
            }

            else {
                System.out.println();
                return;
            }
        }
    }
}
