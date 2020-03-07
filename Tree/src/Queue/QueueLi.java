package Queue;

public class QueueLi {

    private Node front;
    private Node back;

    public QueueLi(){
        front=new Node(null);
        back=front;
    }

    public boolean isEmpty(){
        return front.next==null;
    }

    public boolean isFull(){
        return false;
    }

    public void makeEmpty(){
        front.next=null;
        back=front;
    }

    public void enqueue(Object x){
        back.next=new Node(x);
        //System.out.println(back.element);
        back=back.next;
        //System.out.println(back.element);
    }

    public Object dequeue(){
        if (isEmpty()) return null;
        Object out=front.next.element;
        front.next=front.next.next;
        if (isEmpty()) back=front;
        return out;
    }

    public void print(){
        if (isEmpty()) System.out.println("队列空！");
        else {
            Node current=front.next;
            System.out.print("head  ");
            while (current!=null){
                System.out.print(current.element+"  ");
                current=current.next;
            }
            System.out.println();
        }

    }
}
