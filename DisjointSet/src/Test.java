import DisjointSet.DisjSetsH;

public class Test {
    public static void main(String[] args){
        DisjSetsH disjSetsH=new DisjSetsH(10);
        disjSetsH.combine(1,7);
        disjSetsH.combine(7,8);
        disjSetsH.combine(8,9);
        disjSetsH.combine(2,5);
        disjSetsH.combine(10,5);
        disjSetsH.combine(4,3);
        disjSetsH.combine(6,3);

        disjSetsH.print();
        System.out.println(disjSetsH.isEqual(9,2));
    }
}
