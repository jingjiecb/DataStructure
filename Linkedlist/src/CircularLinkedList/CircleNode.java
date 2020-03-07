package CircularLinkedList;

class CircleNode {
    Object element;
    CircleNode next;

    CircleNode(Object theElement, CircleNode theNode){
        element=theElement;
        next=theNode;
    }

    CircleNode(Object theElemnt){
        this(theElemnt,null);
    }
}
