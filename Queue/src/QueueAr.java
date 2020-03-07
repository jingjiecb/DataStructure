public class QueueAr {

    private Object[] theArray;

    private int front;

    private int back;

    private int currentSize;

    static final int DEFAULT_CAPACITY=10;


    public QueueAr(){
        this(DEFAULT_CAPACITY);
    }

    public QueueAr(int capacity){
        theArray=new Object[capacity];
        makeEmpty();
    }

    public void makeEmpty(){
        currentSize=0;
        front=0;
        back=-1;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public boolean isFull(){
        return currentSize==theArray.length;
    }

    public void enqueue(Object x)throws Overflow{
        if (isFull()){
            throw new Overflow();
        }
        else {
            back=(back+1)%theArray.length;
            theArray[back]=x;
            currentSize++;
        }
    }

    public Object dequeue(){
        if (isEmpty()){
            return null;
        }
        else {
            currentSize--;
            Object fromtItem=theArray[front];
            theArray[front]=null;
            front=(front+1)%theArray.length;
            return fromtItem;
        }
    }

    public void print(){
        for (int i=0;i<theArray.length;i++){
            System.out.print(theArray[i]+"  ");
        }
        System.out.println();
    }
}
