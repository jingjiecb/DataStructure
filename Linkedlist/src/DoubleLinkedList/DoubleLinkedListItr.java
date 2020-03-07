package DoubleLinkedList;

public class DoubleLinkedListItr {
    ListNode current;

    DoubleLinkedListItr(ListNode node){
        current=node;
    }

    public boolean isOut(){
        return retrieve()==null;
    }

    public Object retrieve(){
        return current.element;
    }

    public void go(){
        current=current.next;
    }

    public void back(){
        current=current.pre;
    }

    public void print(){
        if (this==null || current==null){
            System.out.println("Null");
        }
        else {
            System.out.println(retrieve());
        }
    }
}
