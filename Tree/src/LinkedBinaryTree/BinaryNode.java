package LinkedBinaryTree;

public class BinaryNode {
    Object element=null;
    BinaryNode left;
    BinaryNode right;

    boolean PostOrderOnce=false;

    public void resetPostOrderOnce(){
        PostOrderOnce=false;
    }
    public void setPostOrderOnce(){
        PostOrderOnce=true;
    }

    public BinaryNode(){
        left=null;
        right=null;
    }

    public BinaryNode(Object e,BinaryNode l,BinaryNode r){
        element=e;
        left=l;
        right=r;
    }

    public BinaryNode(Object e){
        this(e,null,null);
    }

    public Object reverse(){
        return element;
    }

    public boolean hasLeft(){
        return !(left==null);
    }

    public boolean hasRight(){
        return !(right==null);
    }

    @Override
    public String toString() {
        return element.toString();
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }
}
