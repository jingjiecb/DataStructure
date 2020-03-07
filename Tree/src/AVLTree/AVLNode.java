package AVLTree;

public class AVLNode {
    Comparable element;
    AVLNode left,right;
    int height;

    public AVLNode(Comparable theElement){
        this(theElement,null,null);
    }
    public AVLNode(Comparable theElement,AVLNode lt,AVLNode rt){
        element=theElement;left=lt;right=rt;height=0;//叶节点高度为0
    }
    public String toString(){
        return element.toString();
    }
}
