package QuadraticProbingHashtable;

public class QPHashtable {
    protected HashEntry[] array;
    private int currentSize;
    private static final int DEFAULT_TABLE_SIZE=11;


    public QPHashtable(int size){
        allocateArray(size);
        makeEmpty();
    }
    public QPHashtable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public void makeEmpty(){
        currentSize=0;
        for (int i=0;i<array.length;i++){
            array[i]=null;
        }
    }

    private void allocateArray(int arraySize){
        array=new HashEntry[arraySize];
    }
    private boolean isActive(int pos){
        return array[pos]!=null&&array[pos].isActive;
    }



    /*
     * 查找算法
     */
    public Hashable find(Hashable x){
        int currentPos = findPos(x);
        return isActive(currentPos)?array[currentPos].element:null;
    }
    private int findPos(Hashable x){
        int collisionNum=0;
        int currentPos=x.hash(array.length);
        while (array[currentPos]!=null && !array[currentPos].element.equals(x)){
            currentPos += 2* ++collisionNum -1;//取得下一个完全平方数偏移量。
            while (currentPos>=array.length)currentPos -= array.length;
            //currentPos=currentPos%array.length;
        }
        return currentPos;
    }

    //插入和删除
    public void insert(Hashable x){
        int currentPos=findPos(x);
        if (isActive(currentPos)) return;
        array[currentPos]=new HashEntry(x,true);
        if (++currentSize>array.length/2){
            rehash();
        }
    }
    public final void remove(Hashable x){
        int currentPos=findPos(x);
        array[currentPos].isActive=false;
    }

    private void rehash(){
        HashEntry[] oldArray=array;
        allocateArray(nextPrime(2*oldArray.length));
        currentSize=0;

        for (int i=0;i<oldArray.length;i++){
            if (oldArray[i]!=null && oldArray[i].isActive){
                insert(oldArray[i].element);
            }
        }
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

    public void printKeys(){
        for (int i=0;i<array.length;i++){
            if (array[i]!=null && array[i].isActive){
                System.out.println(array[i].element.toString());
            }
        }
    }
}
