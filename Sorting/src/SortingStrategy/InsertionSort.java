package SortingStrategy;

/* 基本插入排序
 * 稳定
 * 复杂度：
 * 平均 O(n)
 * 辅助储存 O(1)
 */
public class InsertionSort implements SortingStrategy {
    @Override
    public Comparable[] sort(Comparable[] a) {
        int j;
        for (int i=0;i<a.length;i++){
            Comparable tmp=a[i];
            for (j=i;j>0 && tmp.compareTo(a[j-1])<0;j--){
                a[j]=a[j-1];
            }
            a[j]=tmp;
        }
        return a;
    }

}
