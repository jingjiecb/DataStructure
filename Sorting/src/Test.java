import Elements.TestArray;
import SortingStrategy.*;

public class Test {
    public static void main(String[] args){
        Comparable[] input=TestArray.array1;

        Printer.p(input);

        MergeSort sorter=new MergeSort();

        Printer.p(sorter.sort(input));
    }
}