package DoubleLinkedList;

class ListNode {
    Object element;
    ListNode pre;
    ListNode next;

    ListNode(Object element,ListNode pre,ListNode next){
        this.element=element;
        this.pre=pre;
        this.next=next;
    }

    ListNode(Object element){
        this(element,null,null);
    }

}
