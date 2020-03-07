package SortingStrategy;

/*
 * 堆排序
 * 想要从小到大排序，要建立最大堆
 * O(nlog2n)
 * 额外空间：O(1)
 * 不稳定
 *
 */
public class HeapSort implements SortingStrategy{

    @Override
    public Comparable[] sort(Comparable[] a) {
        for (int i=a.length/2;i>=0;i--){
            percDown(a,i,a.length);
        }

        for (int i=a.length-1;i>0;i--){
            swapReferences(a,0,i);//出堆，出堆元素放在最后，和后面的元素交换
            percDown(a,0,i);//然后把换上来的下捋。
        }

        return a;
    }

    private void swapReferences(Comparable[] a,int left,int right){
        Comparable tmp=a[left];
        a[left]=a[right];
        a[right]=tmp;
    }

    private void percDown(Comparable[] a,int i,int n){
        int child;
        Comparable tmp;
        for (tmp=a[i];leftChild(i)<n;i=child){
            child=leftChild(i);
            if (child!=n-1 && a[child].compareTo(a[child+1])<0) child++;//如果还有右子节点，选择左右子节点中比较大的那个
            if (tmp.compareTo(a[child])<0) a[i]=a[child];//如果根小于子节点中大的那个，就把子节点拔上来
            else break;//否则说明这就是正确位置了，不用再换了。
        }
        a[i]=tmp;
    }

    private int leftChild(int root){
        return (root+1)*2-1;
    }
}
