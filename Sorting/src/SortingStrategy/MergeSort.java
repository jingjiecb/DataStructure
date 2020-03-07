package SortingStrategy;


/*
 * 归并排序
 * O(nlog2n)
 * 稳定
 * 额外储存：
 * O(n) 一个临时序列用来储存
 * 如果是递归算法还需要O(log2n)的栈空间。
 *
 * 基本思路：把原本的序列分为两段，先对这两段进行归并排序，最后将两段有序的序列合并成一个完整的序列。
 *
 */
public class MergeSort implements SortingStrategy{

    @Override
    public Comparable[] sort(Comparable[] a) {
        Comparable[] tmpArray=new Comparable[a.length];
        mergeSort(a,tmpArray,0,a.length-1);
        return a;
    }

    private void mergeSort(Comparable[] a,Comparable[] tmpArray,int left,int right){
        if (left<right){//如果左右相同，说明要排序的序列只剩下一个数，不用排直接跳出。
            int center =(left+right)/2;
            mergeSort(a,tmpArray,left,center);
            mergeSort(a,tmpArray,center+1,right);
            merge(a,tmpArray,left,center+1,right);
        }
    }

    private void merge(Comparable[] a,Comparable[] tmpArray,int leftPos,int rightPos,int rightEnd){
        int leftEnd=rightPos-1;
        int tmpPos=leftPos;
        int numElements=rightEnd-leftPos+1;
        while (leftPos<=leftEnd && rightPos<=rightEnd){
            if (a[leftPos].compareTo(a[rightPos])<0){
                tmpArray[tmpPos++]=a[leftPos++];
            }
            else tmpArray[tmpPos++] = a[rightPos++];
        }
        while (leftPos<=leftEnd){
            tmpArray[tmpPos++]=a[leftPos++];
        }
        while (rightPos<=rightEnd){
            tmpArray[tmpPos++]=a[rightPos++];
        }

        for (int i=0;i<numElements;i++,rightEnd--){
            a[rightEnd]=tmpArray[rightEnd];
        }
    }
}
