package SingleLinkedList;

public class LinkedListItr {
    //Iterator
    //把手
    //迭代器

    ListNode current;

    //通过初始节点构造把手
    LinkedListItr(ListNode theNode){
        current=theNode;
    }

    //判断是否已经到列表结尾
    public boolean isPastEnd(){
        return current==null;
    }

    //返回当前元素的内容
    public Object retrieve(){
        return isPastEnd()? null : current.element;
    }

    //前进一个节点，把手向后拉一个节点
    public void advance(){
        if (!isPastEnd()){
            current=current.next;
        }
    }

    public void print(){
        if (isPastEnd() || this==null){
            System.out.println("Null");
        }
        else {
            System.out.println(retrieve());
        }
    }
}
