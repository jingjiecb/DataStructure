package SingleLinkedList;

class ListNode {
    //该类不能直接给外部人员操作！仅供内部使用！
    // 若想对节点操作，必须要通过把手（即迭代器Iterator）

    Object element;
    ListNode next;

    //构造方法1，只给元素，构造一个节点
    ListNode(Object theElement){
       this(theElement,null);
   }

   //构造方法2，通过元素和下一个节点的引用构造一个节点
   ListNode(Object theElement, ListNode n){
        element=theElement;
        next=n;
   }
}
