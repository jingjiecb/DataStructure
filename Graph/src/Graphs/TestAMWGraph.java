package Graphs;

public class TestAMWGraph {
    public static void main(String[] args){
        //int n=4;
        //int e=4;
        //String labels[]={"V1","V2","V3","V4"};
        AMWGraph graph=new AMWGraph(4);
        graph.setDi(true);

        /*
        for (String label:labels){
            graph.insertVertex(label);
        }

         */

        /*
        graph.insertEdge(0,1,2);// V1-2->V2
        graph.insertEdge(0,2,5);// V1-5->V3
        graph.insertEdge(2,3,8);// V3-8->V4
        graph.insertEdge(3,0,7);// V4-7->V1

         */

        //graph.insertEdge("V1","V2",8);
        //System.out.println(graph.getWeight(0,1));

        /*
        graph.print();
        graph.insertEdge(0,1,10);
        graph.insertEdge(0,3,30);
        graph.insertEdge(0,4,100);
        graph.insertEdge(1,2,50);
        graph.insertEdge(2,4,10);
        graph.insertEdge(3,2,20);
        graph.insertEdge(3,4,60);
        graph.print();

        graph.dijkstra(0);
        graph.printPath();

         */

        /*
        graph.insertEdge(0,1,6);
        graph.insertEdge(0,2,5);
        graph.insertEdge(0,3,5);
        graph.insertEdge(1,4,-1);
        graph.insertEdge(2,1,-2);
        graph.insertEdge(2,4,1);
        graph.insertEdge(3,2,-2);
        graph.insertEdge(3,5,-1);
        graph.insertEdge(4,6,3);
        graph.insertEdge(5,6,3);
        graph.print();

        graph.bellmanFord(0);
        graph.printPath();

         */

        graph.insertEdge(0,2,5);
        graph.insertEdge(1,0,5);
        graph.insertEdge(2,1,5);
        graph.insertEdge(2,3,7);
        graph.insertEdge(3,1,10);
        graph.insertEdge(1,3,20);

        graph.print();
        graph.floyed();
    }
}
