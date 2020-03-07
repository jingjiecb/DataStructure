package ThreadTree;

public class ThNode {
    Object element;
    ThNode leftchild;
    ThNode rightchild;
    boolean lTh=false;//leftThread;
    boolean rTh=false;//rightThread;

    public ThNode(){
        this(null,null,null);
    }
    public ThNode(Object ele){
        this(ele,null,null);
    }
    public ThNode(Object ele,ThNode leftCh,ThNode rightCh){
        element=ele;
        leftchild=leftCh;
        rightchild=rightCh;
    }
    public void setlTh(){
        lTh=true;
    }
    public void setrTh(){
        rTh=true;
    }
    public void resetlTh(){
        lTh=false;
    }
    public void resetrTh(){
        rTh=false;
    }

    public String toString(){
        return ""+element;
    }
}
