package LinearProbingHashTable;

public class HashTable {
    int[] keyt;
    Object[] ht;
    int D;
    boolean[] empty;

    //构造方法，输入散列表的大小，构造一个对象数组，以及记录每个位置是否有空的布尔数组。
    public HashTable(int divisor){
        D=divisor;
        keyt=new int[D];
        ht=new Object[D];
        empty=new boolean[D];
        for (int i=0;i<D;i++){
            empty[i]=true;
        }
    }

    int hSearch(int k){
        int i=Hash(k);
        int j=i;
        do {
            if (empty[j]||keyt[j]==k)return j;
            j=(j+1)%D;
        }while (j!=i);
        return j;
    }

    public Object Search(int k){
        int b=hSearch(k);
        if (empty[b]||Hash(keyt[b])!=k) return null;
        Object content=ht[b];
        return content;
    }

    public boolean Insert(Object x,int key){
        int b=hSearch(key);
        if (empty[b]){
            empty[b]=false;
            ht[b]=x;
            keyt[b]=key;
            return true;
        }
        if (keyt[b]==key){
            System.out.println("The element is already in the Hashtable!");
            return true;
        }
        System.out.println("The table is already full!");
        return false;
    }

    private int Hash(int k){
        return k%D;
    }

    public void printK(){
        for(int i=0;i<D;i++){
            System.out.printf("%4d",i);
        }
        System.out.println();
        for (int i=0;i<D;i++){
            System.out.printf("%4d",keyt[i]);
        }
        System.out.println();
        for (int i=0;i<D;i++){
            System.out.printf("%4b",empty[i]);
        }
    }
}
