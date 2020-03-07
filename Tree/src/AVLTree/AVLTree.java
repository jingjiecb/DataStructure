package AVLTree;

import Queue.QueueLi;
import Stack.StackLi;

public class AVLTree {
    AVLNode root;

    /*
     * 构造方法
     *
     */

    public AVLTree(){
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

    private static int height(AVLNode t){
        return t==null?-1:t.height;
    }

    private Comparable elementAt(AVLNode t){
        return t==null?null:t.element;
    }

    public Comparable findMin(){
        return elementAt(findMin(root));
    }

    private AVLNode findMin(AVLNode t){
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

    private AVLNode findMax(AVLNode t){
        if (t==null){
            return null;
        }
        else if (t.left==null){
            return t;
        }
        else return findMax(root);
    }






    /*
     * 插入方法
     * 删除方法
     *
     */
    private AVLNode insert(Comparable x,AVLNode t){
        if (t==null){
            t=new AVLNode(x);
        }

        else if (x.compareTo(t.element)<0){
            t.left=insert(x,t.left);
            if (height(t.left)-height(t.right)==2){
                if (x.compareTo(t.left.element)<0) t = rotateWithLeftChild(t);
                else t = doubleWithLeftChild(t);
            }
        }

        else if (x.compareTo(t.element)>0){
            t.right=insert(x,t.right);
            if (height(t.right)-height(t.left)==2){
                if (x.compareTo(t.right.element)>0) t=rotateWithRightChild(t);
                else t=doubleWithRightChild(t);
            }
        }

        else System.out.println("The element is already in the tree!");

        t.height=Math.max(height(t.left),height(t.right))+1;

        return t;
    }

    public void insert(Comparable x){
        root=insert(x,root);
    }



    private AVLNode remove(Comparable x,AVLNode t){
        if (t==null) return t;//子树为空，不可能删的掉任何元素。直接返回。

        if (x.compareTo(t.element)<0){
            t.left=remove(x,t.left);
            if (height(t.right)-height(t.left)==2){
                if (height(t.right.left)<=height(t.right.right)) t=rotateWithRightChild(t);
                else t=doubleWithRightChild(t);
            }
        }

        else if (x.compareTo(t.element)>0){
            t.right=remove(x,t.right);
            if (height(t.left)-height(t.right)==2){
                if (height(t.left.left)>=height(t.left.right)) t = rotateWithLeftChild(t);
                else t = doubleWithLeftChild(t);
            }
        }

        else if (t.left!=null && t.right!=null){
            t.element=findMin(t.right).element;//此处也可以是t.element=findMax(t.left).element;
            t.right=remove(t.element,t.right);
            if (height(t.left)-height(t.right)==2){
                if (height(t.left.left)>=height(t.left.right)) t = rotateWithLeftChild(t);
                else t = doubleWithLeftChild(t);
            }
        }

        else{
            if (t.left!=null){
                t=t.left;
            }
            else {
                t=t.right;
            }

        }

        if (t!=null) t.height=Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    public void remove(Comparable x){
        root=remove(x,root);
    }








    /*
     * 纠正平衡方法
     *
     */

    //课件中说的右旋，用于纠正左子树外侧高的情况
    private static AVLNode rotateWithLeftChild(AVLNode k2){
        AVLNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }

    //课件中说的右双旋，用于纠正左子树内侧高的情况
    private static AVLNode doubleWithLeftChild(AVLNode k3){
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    //课件中说的左旋，用于纠正右子树外侧高的情况
    private static AVLNode rotateWithRightChild(AVLNode k2){
        AVLNode k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.right),k2.height)+1;
        return k1;
    }

    //课件中说的左双旋，用于纠正右子树内侧高的情况
    private static AVLNode doubleWithRightChild(AVLNode k3){
        k3.right=rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
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
        AVLNode current;
        while (!queueLi.isEmpty()){
            current=(AVLNode) queueLi.dequeue();
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
        AVLNode current;
        while (!stackLi.isEmpty()){
            current=(AVLNode)stackLi.topAndPop();
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
        AVLNode current=root;
        while (true) {
            while (current != null) {//找到以current为树根的子树最左边的点
                stackLi.push(current);
                current = current.left;
            }

            if (!stackLi.isEmpty()) {
                current = (AVLNode) stackLi.topAndPop();
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
