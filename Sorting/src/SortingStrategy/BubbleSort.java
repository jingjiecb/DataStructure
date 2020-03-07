package SortingStrategy;
/*
 * 冒泡排序
 * O(n^2)
 * 稳定
 * 额外空间 O(1)
 *
 */
public class BubbleSort implements SortingStrategy {
    @Override
    public Comparable[] sort(Comparable[] a) {
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-1-i;j++){
                if (a[j].compareTo(a[j+1])>0){//冒泡排序要大量的交换
                    Comparable tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        return a;
    }
}
