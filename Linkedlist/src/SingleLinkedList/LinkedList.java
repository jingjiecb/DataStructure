package SingleLinkedList;

public class LinkedList {

    private ListNode header;

    //构造函数，创建一个头即代表着创建了一个链表
    public LinkedList(){
        header=new ListNode(null);
    }

    //检查表是否为空
    public boolean isEmpty(){
        return header.next==null;
    }

    //清空链表
    public void makeEmpty(){
        header.next=null;
    }

    //得到一个0处的把手
    public LinkedListItr zeroth(){
        return new LinkedListItr(header);
    }

    //得到一个1处的把手，可以拉出第一个值来
    public LinkedListItr first(){
        return new LinkedListItr(header.next);
    }

    //查找元素，返回一个在这个元素处的把手
    public LinkedListItr find(Object x){
        ListNode itr=header.next;
        while (itr!=null&&!itr.element.equals(x)){
            itr=itr.next;
        }
        return new LinkedListItr(itr);
    }

    //删除元素
    public void remove(Object x){
        LinkedListItr p = findPrevious(x);

        if (p.current.next!=null){
            p.current.next=p.current.next.next;
        }

    }

    //找前一个元素，返回一个把手
    public LinkedListItr findPrevious(Object x){
        ListNode itr=header;
        while (itr.next!=null&&!itr.next.element.equals(x)){
            itr=itr.next;
        }
        return new LinkedListItr(itr);
    }

    //在某个把手的下一个点插入一个新元素，而且把手拉向新节点
    public void insert(Object x,LinkedListItr p){
        if (p!=null && p.current!=null){
            p.current.next=new ListNode(x,p.current.next);
            p.advance();
        }
    }

    //静态方法，可以用来打印一个列表的结构
    public static void printList(LinkedList theList){
        if (theList.isEmpty()){
            System.out.println("Empty list!");
        }
        else {
            LinkedListItr itr=theList.first();
            System.out.print("HEAD --> ");
            while (!itr.isPastEnd()){
                System.out.print(itr.retrieve()+" --> ");
                itr.advance();
            }
            System.out.println("END;");
        }
    }
}
