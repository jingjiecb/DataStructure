package CircularLinkedList;

public class CircleLinkedList {
    CircleNode head;

    public CircleLinkedList(){
        head=null;
    }

    public CircleLinkedList(Object x){
        head=new CircleNode(x);
        head.next=head;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void makeEmpty(){
        head=null;
    }

    public CircleItr getHeadNode(){
        return new CircleItr(head);
    }

    public CircleItr find(Object x){
        if (!isEmpty()){
            CircleNode itr=head;
            if (head.element.equals(x)){
                return getHeadNode();
            }
            else {
                itr=itr.next;
                while (!itr.equals(head) && !itr.element.equals(x)){
                    itr=itr.next;
                }
                return new CircleItr(itr);
            }
        }
        else return null;
    }

    public CircleItr getPre(Object x){
        if (!isEmpty()){
            CircleNode itr=head;
            if (head.next.element.equals(x)){
                return getHeadNode();
            }
            else {
                itr=itr.next;
                while (!itr.equals(head) && !itr.next.element.equals(x)){
                    itr=itr.next;
                }
                return new CircleItr(itr);
            }
        }
        else return null;
    }

    public void remove(Object x){
        CircleItr p=getPre(x);
        boolean isHead=false;
        if (p!=null) {
            if (p.current.next.equals(head)){
                isHead=true;
            }
            p.current.next = p.current.next.next;
            if (isHead){
                if (head.equals(head.next)){
                    this.makeEmpty();
                    return;
                }
                head=p.current.next;
            }
        }
    }

    public void insert(Object x,CircleItr handle){//java的参数引用传递。在函数中对实例进行操作可以保留，但是如果对引用重新赋值则不可保留。
        if (this.isEmpty()){
            head=new CircleNode(x);
            head.next=head;
            handle.current=head;
        }
        else {
            handle.current.next=new CircleNode(x,handle.current.next);
            handle.advance();
        }
    }

    public void insert(Object x){
        if (this.isEmpty()){
            head=new CircleNode(x);
            head.next=head;
        }
        else {
            CircleItr handle=new CircleItr(this.head);
            while (!handle.current.next.equals(this.head)){
                //handle.print();
                handle.advance();
                //handle.print();
            }
            //handle.print();
            handle.current.next=new CircleNode(x,handle.current.next);
        }
    }

    public static void printList(CircleLinkedList list){
        if (list.isEmpty()){
            System.out.println("Empty!");
        }
        else {
            CircleItr itr=list.getHeadNode();
            System.out.print(itr.retrieve()+" --> ");
            itr.advance();
            while (!itr.current.equals(list.head)){
                System.out.print(itr.retrieve()+" --> ");
                itr.advance();
            }
            System.out.println();
        }
    }
}
