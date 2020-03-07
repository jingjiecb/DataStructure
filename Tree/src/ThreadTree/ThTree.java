package ThreadTree;

import LinkedBinaryTree.BinaryNode;
import ThreadTree.ThNode;
import LinkedBinaryTree.BinaryTree;
import Stack.StackLi;

public class ThTree {
    ThNode root=null;
    ThNode current=null;


    /*
     * 构造方法
     *
     *
     *
     */
    public ThTree(ThNode t){
        root=t;
    }

    public ThTree(){ }

    public ThTree(BinaryTree t){
        root=creatIOTTree(t).root;
    }







    /*
     * 管理方法
     *
     */
    public boolean isEmpty(){
        return root==null;
    }
    public void thread(){
        if (First(root).rTh) return;//发现第一个节点已经被线索化了，说明这棵树已经线索化好了，直接返回。
        createIOTTree(root);
    }









    /*
     * 静态方法：
     * 依据二叉树构造未经线索化的线索树。
     * 依据二叉树构造线索树。
     *
     */
    public static ThTree copyTree(BinaryTree t){
        //ThTree res=new ThTree();
        //res.root=copyNode(t.getRoot());
        //return res;
        return new ThTree(copyNode(t.getRoot()));
    }

    private static ThNode copyNode(BinaryNode node){
        if (node==null) return null;
        ThNode res=new ThNode();
        res.element=node.reverse();
        res.leftchild=copyNode(node.getLeft());
        res.rightchild=copyNode(node.getRight());
        return res;
    }

    public static ThTree creatIOTTree(BinaryTree t){
        return createIOTTree(copyTree(t));
    }

    public static ThTree createIOTTree(ThTree rawTree){
        createIOTTree(rawTree.root);
        return rawTree;
    }

    private static void createIOTTree(ThNode t){
        StackLi stackLi=new StackLi();
        ThNode p=t;
        ThNode pre=null;

        while (true){

            while (p!=null){
                stackLi.push(p);
                //System.out.println(stackLi.isEmpty());
                p=p.leftchild;
            }

            if (!stackLi.isEmpty()){
                p=(ThNode) stackLi.topAndPop();
                if (pre!=null){
                    if (pre.rightchild==null){
                        pre.rightchild=p;
                        pre.setrTh();
                    }
                    if (p.leftchild==null){
                        p.leftchild=pre;
                        p.setlTh();
                    }
                }
                pre=p;
                p=p.rightchild;
            }
            else return;
        }
    }



    /*
     * 遍历方法
     * 线索中序遍历
     *
     */

    private ThNode First(ThNode subroot){
        while (subroot.leftchild!=null && !subroot.lTh) subroot=subroot.leftchild;//找到最左边的节点
        return subroot;
    }

    private ThNode Next(ThNode now){
        if (now==null) return null;
        ThNode right=now.rightchild;//如果是线索，就直接过去
        if (right!=null && !now.rTh) return First(right);//如果说了现在不是线索，说明拿到的是右子树，去找右子树最左边的节点。
        return right;
    }

    public void IO(){
        for (current=First(root);current!=null;current=Next(current)){//从根开始，一直next
            System.out.print(current.toString()+"  ");
        }
        System.out.println();
    }





    /*
     * 照抄二叉树的遍历方法
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

    private void preOrder(ThNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.toString()+"  ");
        preOrder(node.lTh?null:node.leftchild);
        preOrder(node.rTh?null:node.rightchild);
    }

    private void inOrder(ThNode node){
        if (node==null){
            return;
        }
        inOrder(node.lTh?null:node.leftchild);
        System.out.print(node.toString()+"  ");
        inOrder(node.rTh?null:node.rightchild);
    }

    private void postOrder(ThNode node){
        if (node==null){
            return;
        }
        postOrder(node.lTh?null:node.leftchild);
        postOrder(node.rTh?null:node.rightchild);
        System.out.print(node.toString()+"  ");
    }
}
