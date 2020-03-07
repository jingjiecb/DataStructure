package Stack;

abstract public class Stack {

    abstract public boolean isFull();

    abstract public boolean isEmpty();

    abstract public void makeEmpty();

    abstract public void push(Object x);

    abstract public void pop() throws Underflow;

    abstract public Object top();

    abstract public Object topAndPop();
}