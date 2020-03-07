package SingleLinkedList;

public class Test_SingleLinkedList {
    public static void main(String[] args){
        LinkedList list=new LinkedList();
        LinkedListItr itr=list.zeroth();

        int counter;
        for (counter=1;counter<10;counter++) {
            list.insert(counter, itr);
        }

        LinkedList.printList(list);

        itr=list.find(4);
        list.insert(99,itr);

        LinkedList.printList(list);
    }
}
