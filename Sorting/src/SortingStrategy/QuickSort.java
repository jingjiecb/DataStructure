package SortingStrategy;

/*
 * 快速排序
 * 不稳定
 * O(nlog2n)  每一轮n，要log2n轮
 * 额外空间 O(1)
 *
 */
public class QuickSort implements SortingStrategy{

    @Override
    public Comparable[] sort(Comparable[] a) {
        quicksort(a,0,a.length-1);
        return a;
    }

    private void quicksort(Comparable[] a,int left,int right){
        if (left+2<=right) {
            Comparable pivot = median3(a, left, right);
            int i = left, j = right - 1;
            while (true) {//一开始j指向pivot，所以从i先开始移动
                while (a[++i].compareTo(pivot) < 0) ;
                while (a[--j].compareTo(pivot) > 0) ;
                if (i < j) swapReferences(a, i, j);
                else break;
            }
            swapReferences(a, i, right - 1);
            quicksort(a, left, i - 1);
            quicksort(a, i + 1, right);
        }
        else {
            if (a[left].compareTo(a[right])>0) swapReferences(a,left,right);
        }
    }

    private Comparable median3(Comparable[] a,int left,int right){
        int center=(left+right)/2;

        //先将左中右三个元素排好序
        if (a[center].compareTo(a[left])<0){
            swapReferences(a,left,center);
        }
        if (a[right].compareTo(a[left])<0){
            swapReferences(a,left,right);
        }
        if (a[right].compareTo(a[center])<0){
            swapReferences(a,center,right);
        }

        swapReferences(a,center,right-1);//最后将pivot放在倒数第二个位置，这样实际上只需要排从第二个到倒数第三个这么多就够了
        return a[right-1];
    }

    private void swapReferences(Comparable[] a,int left,int right){
        Comparable tmp=a[left];
        a[left]=a[right];
        a[right]=tmp;
    }
}
