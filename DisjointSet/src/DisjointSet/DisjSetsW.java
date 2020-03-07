package DisjointSet;


//improve the union measure to make find more efficient.
//每次合并时将节点少的根接在节点多的根上面
public class DisjSetsW {
    private int[] parent;
    private boolean[] root;


    public DisjSetsW(int numElements){
        parent=new int[numElements+1];
        root=new boolean[numElements+1];

        initialize();
    }

    public void initialize(){
        for (int e=1;e<parent.length;e++){
            parent[e]=1;
            root[e]=true;
        }
    }

    public int find(int e){
        while (!root[e]){
            e=parent[e];
        }
        return e;
    }

    public void union(int root1,int root2){
        if (parent[root1]<parent[root2]){
            parent[root2]=parent[root1]+parent[root2];
            parent[root1]=root2;
            root[root1]=false;
        }
        else {
            parent[root1] += parent[root2];
            parent[root2]=root1;
            root[root2]=false;
        }
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
        for (int i=1;i<parent.length;i++){
            if (root[i]){
                System.out.println("root: "+i);
            }
            else {
                System.out.println(i+" is not a root. It's root is "+find(i));
            }
        }
    }
}
