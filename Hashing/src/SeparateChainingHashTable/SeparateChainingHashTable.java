package SeparateChainingHashTable;

import QuadraticProbingHashtable.Hashable;
import SingleLinkedList.LinkedList;
import SingleLinkedList.LinkedListItr;


public class SeparateChainingHashTable {
    private LinkedList[] theLists;

    private static final int DEFAULT_TABLE_SIZE=101;

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size){
        theLists=new LinkedList[nextPrime(size)];
        makeEmpty();
    }

    public void insert(Hashable x){
        LinkedList whichList=theLists[x.hash(theLists.length)];
        LinkedListItr itr=whichList.find(x);
        if (itr.isPastEnd()){
            whichList.insert(x,whichList.zeroth());
        }
    }

    public void remove(Hashable x){
        theLists[x.hash(theLists.length)].remove(x);
    }

    public Hashable find(Hashable x){
        return (Hashable)(theLists[x.hash(theLists.length)].find(x).retrieve());
    }

    public void makeEmpty(){
        for (int i=0;i<theLists.length;i++){
            theLists[i]=new LinkedList();
        }
    }

    public static int hash(String key,int tableSize){
        return key.length()%tableSize;//这里实际上为了测试方便故意选了一个很有可能冲突的哈希函数。
    }


    private static int nextPrime(int n){
        while (!isPrime(n)){
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n){
        for (int i=0;i<=Math.sqrt(n);i++){
            if (n%i==0) return true;
        }
        return false;
    }

}
