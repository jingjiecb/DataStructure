import LinearProbingHashTable.HashTable;
import QuadraticProbingHashtable.QPHashtable;
import QuadraticProbingHashtable.one;

public class Test {
    public static void main(String[] args){
        HashTable table=new HashTable(11);
        table.Insert(4,4);
        table.Insert(5,5);
        table.Insert(11,11);
        table.Insert(15,15);
        table.printK();
        table.Insert(15,15);

        QPHashtable hashtable=new QPHashtable(10);
        String str1="content in key 1";
        hashtable.insert(new one(1,str1));
        hashtable.printKeys();
    }
}
