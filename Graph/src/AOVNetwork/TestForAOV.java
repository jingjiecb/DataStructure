package AOVNetwork;

public class TestForAOV {
    public static void main(String[] args){
        AOVNet net=new AOVNet(5);
        net.insertEdge(0,1);
        net.insertEdge(0,3);
        net.insertEdge(0,2);
        net.insertEdge(2,3);
        net.insertEdge(1,4);
        net.insertEdge(3,4);
        net.insertEdge(4,3);

        net.topSort();
        net.printTop();
    }
}
