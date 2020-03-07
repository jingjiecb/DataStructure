package LALGraph;

public class Test {
    public static void main(String[] args){
        LALGraph<String> lalGraph=new LALGraph<String>();
        lalGraph.initialize();
        System.out.println(lalGraph.getNumVertices());
        System.out.println(lalGraph.getNumEdges());
        //System.out.println(lalGraph.firstNeighbor("home"));

        lalGraph.cDFSprint();
    }

}
