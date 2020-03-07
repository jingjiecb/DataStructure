package SortingStrategy;
/*
 * 直接选择排序
 * O(n^2)
 * 不稳定
 * 辅助储存 O(1)
 *
 */
public class SelectSort implements SortingStrategy{
    @Override
    public Comparable[] sort(Comparable[] a) {
        for (int i=0;i<a.length-1;i++){

            //找到i后面的数中最小数的下标
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if (a[j].compareTo(a[min])<0) min=j;
            }

            //把最小的数换到当前位置。
            Comparable tmp=a[i];
            a[i]=a[min];
            a[min]=tmp;
        }
        return a;
    }
}
