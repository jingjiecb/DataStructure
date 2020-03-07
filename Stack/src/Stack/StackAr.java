package Stack;

public class StackAr {

    final static int DEFSULT_CAPACITY=10;

    int topOfStack;
    Object[] theArray;

    public StackAr(){
        this(StackAr.DEFSULT_CAPACITY);
    }

    public StackAr(int capacity){
        theArray=new Object[capacity];
        topOfStack=-1;
    }

    public boolean isEmpty(){
        return topOfStack==-1;
    }

    public boolean isFull(){
        return topOfStack==theArray.length-1;
    }

    public void push(Object x) throws Overflow {
        if (isFull()){
            throw new Overflow();
        }
        theArray[++topOfStack]=x;
    }

    public Object top(){
        if (isEmpty()){
            return null;
        }
        return theArray[topOfStack];
    }

    public void pop()throws Underflow{
        if (isEmpty()){
            throw new Underflow();
        }
        theArray[topOfStack--]=null;
    }

    public Object topAndPop(){
        if (isEmpty()){
            return null;
        }
        Object topItem=top();
        theArray[topOfStack--]=null;
        return topItem;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Empty!");
        }
        else {
            for (Object x : theArray) {
                if (x == null) break;
                System.out.print(x + "  ");
            }
            System.out.println();
        }
    }
}
