import Heaps.MaxHeap;
import Heaps.MinHeap;

public class Test {
    public static void main(String[] args){
        MaxHeap maxHeap=new MaxHeap();
        maxHeap.initializeS("14 20 10 2 15 21");
        //for (int i=1;i<7;i++)System.out.println(maxHeap.deleteMax());

        MinHeap minHeap=new MinHeap();
        minHeap.initializeS("14 20 10 2 15 21");
        minHeap.printnMin(2);
    }
}
