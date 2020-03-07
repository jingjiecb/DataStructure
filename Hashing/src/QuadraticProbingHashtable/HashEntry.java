package QuadraticProbingHashtable;

public class HashEntry {
    Hashable element;
    boolean isActive;

    public HashEntry(Hashable e){
        this(e,true);
    }
    public HashEntry(Hashable e,boolean i){
        element=e;
        isActive=i;
    }
}
