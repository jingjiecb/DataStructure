package DoubleLinkedList;

public class Test_DoubleLinkedList {
    public static void main(String[] args){
        DoubleLinkedList list=new DoubleLinkedList();
        DoubleLinkedListItr itr=list.zeroth();

        int counter;
        for (counter=1;counter<10;counter++) {
            list.insertNext(counter, itr);
        }
        DoubleLinkedList.printList(list);

        itr=list.find(4);
        list.insertNext(99,itr);
        DoubleLinkedList.printList(list);

        list.remove(6);
        DoubleLinkedList.printList(list);
    }
}
