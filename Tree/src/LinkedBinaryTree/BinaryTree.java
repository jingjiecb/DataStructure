package LinkedBinaryTree;

import Queue.QueueLi;
import Stack.StackLi;

public class BinaryTree {

    private BinaryNode root;
    //private BinaryTree leftCH;
    //private BinaryTree rightCH;




    /*
     *
     * 构造方法------------------------------------------------------
     * 无参数：得到空树。
     * Object参数：得到一棵只有根的树。树根内容设置为参数。
     *
     */
    public BinaryTree(){
        root=null;
    }

    public BinaryTree(Object data){
        root=new BinaryNode(data,null,null);
    }






    /*
     *
     * 管理方法：
     * 判断空；
     * 得到根；
     * 计算树高（树根处高度为1）；
     * 计算树中节点的总个数size，包括根节点和叶节点；
     *
     *
     */

    boolean isEmpty(){
        return root==null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    private int height(BinaryNode t){
        if (t==null) return 0;
        int hl=height(t.left);
        int hr=height(t.right);
        if (hl>hr) return ++hl;
        else return ++hr;
    }
    public int height(){//这里规定树根处的高度为1
        return height(root);
    }

    private int size(BinaryNode t){
        if (t==null) return 0;
        int sl=size(t.left);
        int sr=size(t.right);
        return sl+sr+1;
    }
    public int size(){
        return size(root);
    }










    /*
     *
     * 遍历方法：
     * 递归方法：包括先序遍历、中序遍历、后序遍历
     * 非递归方法：包括先序遍历、中序遍历、后序遍历、广度优先遍历
     *
     *
     */

    public void preOrder(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        preOrder(root);
        System.out.println();
    }

    public void inOrder(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        inOrder(root);
        System.out.println();
    }

    public void postOrder(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        postOrder(root);
        System.out.println();
    }

    private void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.toString()+"  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(BinaryNode node){
        if (node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.toString()+"  ");
        inOrder(node.right);
    }

    private void postOrder(BinaryNode node){
        if (node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.toString()+"  ");
    }

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
            if (current.hasLeft()) queueLi.enqueue(current.left);
            if (current.hasRight()) queueLi.enqueue(current.right);
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
            if (current.hasRight()) stackLi.push(current.right);
            if (current.hasLeft()) stackLi.push(current.left);
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

    //PostOrder Print without recursive call.
    public void PostPrint(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }

        StackLi stackLi=new StackLi();
        BinaryNode current=root;
        while (true){

            while (current!=null){
                stackLi.push(current);
                current=current.left;
            }

            current=(BinaryNode) stackLi.topAndPop();

            while (current.PostOrderOnce){
                System.out.print(current.toString()+"  ");
                current.resetPostOrderOnce();
                if (!stackLi.isEmpty()){
                    current=(BinaryNode) stackLi.topAndPop();
                }
                else {
                    System.out.println();
                    return;
                }
            }

            //找到一个没有从右子树返回的点，重新压回去然后处理他的右子树
            current.setPostOrderOnce();
            stackLi.push(current);
            current=current.right;
        }
    }








    /*
     * 重构方法：
     * 用两棵树作为左右子树，并重置根节点构造树。
     * 通过先序遍历和中序遍历重构树。
     * 通过中序遍历和后序遍历重构树。注意！已知先序遍历和后序遍历不能构造唯一的二叉树。
     *
     */

    public void makeTree(Object data, BinaryTree leftch, BinaryTree rightch){
        BinaryNode leftroot;
        BinaryNode rightroot;
        leftroot= leftch==null?null:leftch.root;
        rightroot= rightch==null?null:rightch.root;
        root=new BinaryNode(data,leftroot,rightroot);
        leftroot=rightroot=null;
    }

    public void creatPI(String pres,String ins){
        root=creat(pres,ins);
    }

    public void creatIP(String ins,String posts){
        root=creat2(ins,posts);
    }

    //根据先序遍历和中序遍历实现构造一棵唯一的二叉树
    private BinaryNode creat(String pres,String ins){
        int inpos;//InOrder String Position
        String prestemp,instemp;
        BinaryNode t;

        if (pres.length()==0) t=null;
        else {
            t=new BinaryNode();
            t.element=pres.charAt(0);
            inpos=0;

            while (ins.charAt(inpos)!=(char)t.element) inpos++;

            prestemp=pres.substring(1,inpos+1);
            instemp=ins.substring(0,inpos);
            t.left=creat(prestemp,instemp);

            prestemp=pres.substring(inpos+1);
            instemp=ins.substring(inpos+1);
            t.right=creat(prestemp,instemp);
        }
        return t;
    }

    //根据中序遍历和后序遍历实现构造一棵唯一的二叉树
    private BinaryNode creat2(String ins, String posts){
        int inpos;
        int len=posts.length();
        String instemp,poststemp;
        BinaryNode t;

        if (posts.length()==0) t=null;
        else {
            t=new BinaryNode();
            t.element=posts.charAt(len-1);
            inpos=len-1;

            while (ins.charAt(inpos)!=(char)t.element) inpos--;

            poststemp=posts.substring(inpos,len-1);
            instemp=ins.substring(inpos+1,len);
            t.right=creat2(instemp,poststemp);

            poststemp=posts.substring(0,inpos);
            instemp=ins.substring(0,inpos);
            t.left=creat2(instemp,poststemp);
        }
        return t;
    }
}
