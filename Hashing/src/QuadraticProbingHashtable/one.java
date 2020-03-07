package QuadraticProbingHashtable;

public class one implements Hashable {
    int key;
    Object content;

    public one(int k,Object x){
        key=k;
        content=x;
    }

    @Override
    public int hash(int tableSize) {
        return key%tableSize;
    }

    @Override
    public String toString() {
        return ""+key+" "+content.toString();
    }
}
