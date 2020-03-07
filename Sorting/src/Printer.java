public class Printer {
    public static void p(Comparable[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i].toString()+"  ");
        }
        System.out.println();
    }
}
