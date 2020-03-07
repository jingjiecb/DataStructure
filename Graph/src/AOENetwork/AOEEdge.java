package AOENetwork;

public class AOEEdge {
    int dest;
    AOEEdge link;
    int cost;

    int ee;
    int el;

    AOEEdge(int v,int c){
        this(v,c,null);
    }

    AOEEdge(int v,int c,AOEEdge l){
        dest=v;
        link=l;
        ee=0;
        el=0;
        cost=c;
    }

}
