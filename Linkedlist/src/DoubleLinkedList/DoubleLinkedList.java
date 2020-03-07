package DoubleLinkedList;

public class DoubleLinkedList {
    ListNode head;
    ListNode end;

    public DoubleLinkedList(){
        head=new ListNode(null);
        end=new ListNode(null,head,null);
        head.next=end;
    }

    public boolean isEmpty(){
        return head.next.element==null;
    }

    public void makeEmpty(){
        head.next=end;
        end.pre=head;
    }

    public DoubleLinkedListItr zeroth(){
        return new DoubleLinkedListItr(head);
    }

    public DoubleLinkedListItr omiga(){
        return new DoubleLinkedListItr(end);
    }

    public DoubleLinkedListItr find(Object element){
        ListNode itr=head.next;
        while (itr.element!=null && !itr.element.equals(element)){
            itr=itr.next;
        }
        return new DoubleLinkedListItr(itr);
    }

    public void remove(Object x){
        DoubleLinkedListItr handle=find(x);
        if (handle!=null && handle.current!=null && handle.current.element!=null) {
            handle.current.pre.next = handle.current.next;
            handle.current.next.pre = handle.current.pre;
        }
    }

    public void insertNext(Object x,DoubleLinkedListItr handle){
        if (handle!=null && handle.current.next!=null){
            handle.current.next=new ListNode(x,handle.current,handle.current.next);
            handle.current.next.next.pre=handle.current.next;
            handle.go();
        }
    }

    public void insertPre(Object x,DoubleLinkedListItr handle){
        if (handle!=null && handle.current.pre!=null){
            handle.current.pre=new ListNode(x,handle.current.pre,handle.current);
            handle.current.pre.pre.next=handle.current.pre;
            handle.back();
        }
    }

    public static void printList(DoubleLinkedList theList){
        if (theList.isEmpty()){
            System.out.println("Empty!");
        }
        else {
            DoubleLinkedListItr itr=theList.zeroth();
            System.out.print("HEAD <==> ");
            itr.go();
            while (!itr.isOut()){
                System.out.print(itr.retrieve()+" <==> ");
                itr.go();
            }
            System.out.println("END");
        }
    }
}
