package CircularLinkedList;

public class CircleItr {
    CircleNode current;

    CircleItr(CircleNode node){
        current=node;
    }

    public Object retrieve(){
        return current.element;
    }

    public void advance(){
        current=current.next;
    }

    public void print(){
        if (this!=null) {
            System.out.println(this.retrieve());
        }
    }

    public void change(Object x){
        if (this!=null && this.current!=null){
            current.element=x;
        }
    }
}
