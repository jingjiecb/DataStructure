package CircularLinkedList;

public class Josephus {

    public static void main(String[] args){
        CircleLinkedList people = getList(8);
        int step=3;
        //CircleLinkedList.printList(people);

        int last=0;
        CircleItr counter=people.getHeadNode();
        while (!people.isEmpty()){
            //CircleLinkedList.printList(people);
            run(step-1,counter);
            last=(int)counter.retrieve();
            counter.advance();
            people.remove(last);
        }
        System.out.println(last);
    }

    static CircleLinkedList getList(int n){
        int counter;
        CircleLinkedList list=new CircleLinkedList();
        for (counter=1;counter<=n;counter++){
            list.insert(counter);
            //CircleLinkedList.printList(list);
        }
        return list;
    }

    /*
    static CircleLinkedList getPeople(int n){
        CircleLinkedList list=new CircleLinkedList();
        CircleItr itr=list.getHeadNode();
        int counter;
        for (counter=1;counter<=n;counter++){
            list.insert(counter,itr);
        }
        return list;
    }

     */

    static void run(int n, CircleItr itr){
        while (n>0){
            itr.advance();
            n--;
        }
    }
}
