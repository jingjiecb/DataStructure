package SeparateChainingHashTable;

public class Employee implements Hashablee {
    private String name;
    private double salary;
    private int seniority;

    public int hash(int tablesize){
        return SeparateChainingHashTable.hash(name,tablesize);
    }
    public boolean equals(Object rhs){
        return name.equals(((Employee)rhs).name);
    }
}
