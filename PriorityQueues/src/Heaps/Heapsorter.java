package Heaps;

public class Heapsorter {


    //堆排序算法
    public static void heapsort(Comparable[] a){//通过建立最小堆，将原来的数组调整为从大到小的排序。如果要求从小到大排序，则需要建立最大堆。
        for (int i=a.length/2;i>=1;i--){
            precDown(a,i,a.length);
        }
        for (int i=a.length;i>1;i--){
            swapReferences(a,1,i);
            precDown(a,1,i-1);
        }
    }

    private static void swapReferences(Comparable[] a,int m,int n){
        Comparable tmp=a[m];
        a[m]=a[n];
        a[n]=tmp;
    }

    private static void precDown(Comparable[] a,int i,int n){//这里建立的是最小堆
        int child;
        Comparable tmp;

        for (tmp=a[i];leftChild(i)<n;i=child){
            child=leftChild(i);
            if (child!=n-1 && a[child].compareTo(a[child+1])<0){
                child++;
            }
            if (tmp.compareTo(a[child])<0){
                a[i]=a[child];
            }
            else break;
        }

        a[i]=tmp;
    }

    private static int leftChild(int i){
        return 2*i+1;
    }

}
