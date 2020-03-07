package LALGraph;

public class Vertex<E> {
    E data;
    Edge adj;

    Vertex(E v){
        data=v;
    }
}
