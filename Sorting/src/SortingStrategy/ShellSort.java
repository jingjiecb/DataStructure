package SortingStrategy;

/* 希尔排序
 * 不稳定
 * O(n^1.3)
 * 辅助储存 O(1)
 */
public class ShellSort implements SortingStrategy {
    @Override
    public Comparable[] sort(Comparable[] a) {
        for (int gap=a.length/2;gap>0;gap/=2){
            for (int i=gap;i<a.length;i++){//从每个组的第二个数开始。这里i的取值依次是：第一组的第二个数，二组2，……，一组3,二组3，……，…………，一组n，二组n，……n组n
                Comparable tmp=a[i];
                int j=i;

                for (;j>=gap && tmp.compareTo(a[j-gap])<0;j-=gap){
                    a[j]=a[j-gap];
                }

                a[j]=tmp;
            }
        }
        return a;
    }

}
