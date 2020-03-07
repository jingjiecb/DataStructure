package DisjointSet;

public class DisjSetsH {
    private int[] s;


    public DisjSetsH(int numElements){
        s=new int[numElements+1];
        initialize();
    }

    public void initialize(){
        for (int i=0;i<s.length;i++){
            s[i]=-1;
        }
    }

    public void union(int root1,int root2){
        if (s[root2]<s[root1]){
            s[root1]=root2;
        }
        else {
            if (s[root1]==s[root2]){
                s[root1]--;
            }
            s[root2]=root1;
        }
    }

    public int find(int x){
        if (s[x]<0){
            return x;
        }
        else return find(s[x]);
    }

    public void combine(int a, int b){
        int root1=find(a);
        int root2=find(b);
        union(root1,root2);
    }

    public boolean isEqual(int a, int b){
        int root1=find(a);
        int root2=find(b);
        return root1==root2;
    }

    public void print(){
        for (int i=1;i<s.length;i++){
            if (s[i]<0){
                System.out.println("root: "+i);
            }
            else {
                int j=i;
                while (s[j]>0){
                    System.out.print(j+"-->");
                    j=s[j];
                }
                System.out.println(j);

            }
        }
    }
}
