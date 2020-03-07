package Heaps;

import java.util.Scanner;

public class MinHeap {
    private int currentSize;
    private Comparable[] heap;
    private static final int DEFAULT_SIZE=100;

    public MinHeap(int size){
        heap=new Comparable[size+1];
        currentSize=0;
    }
    public MinHeap(){
        this(DEFAULT_SIZE);
    }

    public void makeEmpty(){
        currentSize=0;
    }

    public boolean isfull(){
        return currentSize+1==heap.length;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public void insert(Comparable x){
        if (isfull()) {
            System.out.println("MaxHeap is already full!");
            return;
        }

        int hole=++currentSize;
        for (;hole>1 && x.compareTo(heap[hole/2])<0;hole/=2){
            heap[hole]=heap[hole/2];
        }
        heap[hole]=x;
    }

    public Comparable deleteMin(){
        if (isEmpty()){
            System.out.println("MaxHeap is empty!");
            return null;
        }

        Comparable maxItem=findMin();
        heap[1]=heap[currentSize--];//把最后一个顶点提到根的位置
        percolateDown(1);//下捋

        return maxItem;
    }

    public Comparable findMin(){
        return heap[1];
    }

    private void percolateDown(int hole){
        int child;
        Comparable tmp=heap[hole];
        for (;hole*2<=currentSize;hole=child)
        {
            child=hole*2;
            if (child!=currentSize && heap[child+1].compareTo(heap[child])<0){//选一个子节点中比较大的那个，把这个大的给child。
                child++;
            }
            if (heap[child].compareTo(tmp)<0){//如果要下捋的值比他的两个子节点都大，那就符合结构了，跳出。否则，将他较大的那个子节点换上来。
                heap[hole]=heap[child];
            }
            else break;
        }

        heap[hole]=tmp;
    }

    public void initialize(Comparable[] x,int size){//注意！输入的数组0号位必须空出来，从1号位开始记有size个元素
        makeEmpty();
        heap=x;
        currentSize=size;

        //这里做的就是从最后一个父节点（非叶节点）开始以此对所有父节点做下捋
        for (int i=currentSize/2;i>=1;i--){
            Comparable tmp=heap[i];
            int c=2*i;
            while (c<=currentSize){
                if (c<currentSize && heap[c].compareTo(heap[c+1])>=0) c++;
                if (tmp.compareTo(heap[c])<=0) break;
                heap[c/2]=heap[c];
                c*=2;
            }
            heap[c/2]=tmp;
        }

    }

    public void initializeS(String str){
        Scanner scanner=new Scanner(str);
        int[] sour=new int[101];
        int length=0;
        while (scanner.hasNextInt()){
            sour[length]=scanner.nextInt();
            length++;
        }

        Comparable[] res=new Comparable[length+1];
        for (int i=0;i<length;i++){
            res[i+1]=sour[i];
        }

        initialize(res,length);
    }

    public void printnMin(int n){
        Comparable res=null;
        while (n>0){
            res=deleteMin();
            n--;
        }
        System.out.println(res);
    }
}