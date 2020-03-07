package DisjointSet;

public class DisjSets {
    private int[] s;


    public DisjSets(int numElements){
        s=new int[numElements+1];
        initialize();
    }

    public void initialize(){
        for (int i=0;i<s.length;i++){
            s[i]=-1;
        }
    }

    public void union(int root1,int root2){
        s[root2]=root1;
    }

    public int find(int x){
        if (s[x]<0){
            return x;
        }
        else return find(s[x]);
    }

    public void combine(int a,int b){
        int root1=find(a);
        int root2=find(b);
        union(root1,root2);
    }

}
