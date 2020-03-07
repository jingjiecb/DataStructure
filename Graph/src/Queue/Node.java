package Queue;

public class Node {

    Object element;
    Node next;

    public Node(Object x){
        this(x,null);
    }

    public Node(Object x,Node theNext) {
        element =x;
        next=theNext;
    }
}
