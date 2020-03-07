package Stack;

public class StackLi  {

    ListNode topOfStack;

    public StackLi(){
        topOfStack=null;
    }

    //永远不满
    public boolean isFull(){
        return false;
    }

    //判断是否为空栈
    public boolean isEmpty(){
        return topOfStack==null;
    }

    //栈清空，栈重启
    public void makeEmpty(){
        topOfStack=null;
    }

    //压栈
    public void push(Object x){
        topOfStack=new ListNode(x,topOfStack);
    }

    //查看栈顶元素
    public Object top(){
        if (isEmpty()){
            return null;
        }
        return topOfStack.element;
    }

    //出栈，抛异常
    public void pop() {
        if (isEmpty()){
            return;
        }
        topOfStack=topOfStack.next;
    }

    //前两个函数的融合，但不会抛异常
    public Object topAndPop(){
        if (isEmpty()){
            return null;
        }
        Object topItem=topOfStack.element;
        topOfStack=topOfStack.next;
        return topItem;
    }

}
