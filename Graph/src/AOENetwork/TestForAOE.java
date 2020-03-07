package AOENetwork;

public class TestForAOE {
    public static void main(String[] args){
        AOENet net=new AOENet(9);
        net.insertEdge(0,1,6);
        net.insertEdge(0,2,4);
        net.insertEdge(0,3,5);
        net.insertEdge(1,4,1);
        net.insertEdge(2,4,1);
        net.insertEdge(3,5,2);
        net.insertEdge(4,6,9);
        net.insertEdge(4,7,7);
        net.insertEdge(5,7,4);
        net.insertEdge(4,8,2);
        net.insertEdge(7,8,4);

        System.out.println(1);

        net.topSort();
        net.printTop();

        net.criticalPath();
    }
}
