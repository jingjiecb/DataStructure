package LALGraph;

public class Edge implements Comparable{
    int from=-1;
    int dest;
    int cost;
    Edge link;

    Edge(int d,int c){
        dest=d;
        cost=c;
        link=null;
    }

    Edge(int d){
        this(d,1);
    }

    @Override
    public int compareTo(Object o) {
        int cost2=((Edge)o).cost;
        if (cost>cost2) return 1;
        else if (cost<cost2) return -1;
        else return 0;
    }

    public void addFrom(int f){
        from=f;
    }
}
