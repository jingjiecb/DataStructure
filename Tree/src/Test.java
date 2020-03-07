import AVLTree.AVLTree;
import BinarySearchTree.BinarySearchTree;
import LinkedBinaryTree.BinaryNode;
import LinkedBinaryTree.BinaryTree;
import ThreadTree.ThTree;

public class Test {
    public static void main(String[] args ){
        BinaryTree a=new BinaryTree(1);
        BinaryTree b=new BinaryTree(2);
        BinaryTree c=new BinaryTree();
        BinaryTree d=new BinaryTree();

        c.makeTree(3,a,b);
        d.makeTree(4,c,null);

        d.preOrder();
        d.inOrder();
        d.postOrder();
        d.LOprint();
        d.POprint();
        d.IOprint();
        d.PostPrint();

        System.out.println("-----------------------------");
        BinaryTree tree=new BinaryTree();
        tree.creatPI("4312","1324");
        tree.POprint();
        tree.IOprint();
        tree.PostPrint();
        System.out.println(tree.height());
        System.out.println(tree.size());

        System.out.println("-----------------------------");
        tree.creatIP("1324","1234");
        tree.POprint();
        tree.IOprint();
        tree.PostPrint();
        System.out.println(tree.height());
        System.out.println(tree.size());

        System.out.println("-----------------------------");
        ThTree thTree=new ThTree(tree);
        thTree.IO();
        thTree.inOrder();
        thTree.preOrder();
        thTree.postOrder();

        System.out.println("**********************************");
        BinarySearchTree stree=new BinarySearchTree();
        stree.insert(2);
        stree.insert(1);
        stree.insert(4);
        stree.insert(3);
        stree.POprint();
        stree.IOprint();
        stree.remove(2);
        stree.POprint();
        stree.IOprint();

        System.out.println("**********************************");
        AVLTree avlTree=new AVLTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(4);
        avlTree.insert(3);
        avlTree.POprint();
        avlTree.IOprint();
        avlTree.remove(5);
        avlTree.remove(6);
        System.out.println();
        avlTree.POprint();
        avlTree.IOprint();
    }
}
