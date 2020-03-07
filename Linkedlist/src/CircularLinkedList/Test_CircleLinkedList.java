package CircularLinkedList;

public class Test_CircleLinkedList {
    public static void main(String[] args){
        CircleLinkedList list=new CircleLinkedList();
        CircleItr itr=list.getHeadNode();

        int counter;
        for (counter=1;counter<10;counter++) {
            list.insert(counter, itr);
        }
        CircleLinkedList.printList(list);

        itr=list.find(4);
        list.insert(99,itr);
        CircleLinkedList.printList(list);

        itr=list.find(8);
        itr.change(66);
        CircleLinkedList.printList(list);

        itr=list.getPre(1);
        itr.advance();
        itr.print();

        list.remove(1);
        CircleLinkedList.printList(list);

        itr=list.getHeadNode();
        itr.retrieve();
    }
}
