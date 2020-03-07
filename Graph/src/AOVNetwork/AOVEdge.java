package AOVNetwork;

public class AOVEdge {
    int dest;
    AOVEdge link;

    AOVEdge(int v){
        this(v,null);
    }

    AOVEdge(int v,AOVEdge l){
        dest=v;
        link=l;
    }
}
