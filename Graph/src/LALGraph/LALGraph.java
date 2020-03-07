package LALGraph;

import DisjointSet.DisjSets;
import Heaps.MinHeap;
import Queue.QueueLi;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Scanner;

public class LALGraph<E> {
    private Vertex[] nodeTable;
    private int numVertices;
    private int numEdges;
    private int maxNumOfVer;
    private static final int DEFAULT_SIZE=10;
    private static final int INFINIT=2147483647;

    //构造函数
    public LALGraph(int maxNum){
        numEdges=0;
        numVertices=0;
        maxNumOfVer=maxNum;
        nodeTable=(Vertex<E>[]) Array.newInstance(Vertex.class,maxNum);
    }
    public LALGraph(){
        this(DEFAULT_SIZE);
    }



    /*
     * 管理方法
     */
    //清空
    public void makeEmpty(){
        makeEmpty(DEFAULT_SIZE);
    }
    public void makeEmpty(int size){
        numEdges=0;
        numVertices=0;
        maxNumOfVer=size;
        nodeTable=(Vertex<E>[]) Array.newInstance(Vertex.class,maxNumOfVer);
    }
    //get
    public int getNumEdges() {
        return numEdges;
    }
    public int getNumVertices(){
        return numVertices;
    }

    //顶点内容和顶点索引转化的方法
    //******重要方法****** 相当于抽象同构函数。是用户表达和抽象管理的接口
    public int getVertexPos(E vertex){
        for (int i=0;i<numVertices;i++){
            if (nodeTable[i].data.equals(vertex)) return i;
        }
        return -1;
    }
    public E getContent(int v){
        if (v>=0 && v<numVertices){
            return (E)nodeTable[v].data;
        }
        else return null;
    }

    //判断v1和v2是否邻接（有向）
    private boolean isADJ(int v1,int v2){
        int current=getFirstNeighbor(v1);
        while (current!=-1){
            if (current==v2) return true;
            current=getNextNeighbor(v1,current);
        }
        return false;
    }

    //获得两个顶点之间的权重。如果边不存在就返回最大int数。
    private int cost(int v1, int v2){
        if (v1!=-1){
            Edge p=nodeTable[v1].adj;
            while (p!=null){
                if (p.dest==v2) return p.cost;
                p=p.link;
            }
        }
        return INFINIT;
    }



    /*
     * 获得邻接顶点的方法
     * ******重要方法******
     */

    public int getFirstNeighbor(int v1){
        if(v1!=-1){
            Edge p=nodeTable[v1].adj;
            if (p!=null) return p.dest;
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        if (v1!=-1){
            Edge p=nodeTable[v1].adj;
            while (p!=null){
                if (p.dest==v2 && p.link!=null){
                    return p.link.dest;
                }
                else p=p.link;
            }
        }
        return -1;
    }

    public E firstNeighbor(E v1){
        int v=getVertexPos(v1);
        int res=getFirstNeighbor(v);
        if (res==-1){
            System.out.println("No neighbor!");
            return null;
        }
        else return (E)nodeTable[res].data;
    }

    public E nextNeighbor(E v1,E v2){
        int ver=getVertexPos(v1);
        int after=getVertexPos(v2);
        int res=getNextNeighbor(ver,after);
        if (res==-1){
            System.out.println("No next neighbor!");
            return null;
        }
        else return (E)nodeTable[res].data;
    }




    /*
     * 重构方法
     *
     */
    //控制台初始化方法
    public void initialize(){
        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入顶点数：");
        maxNumOfVer=scanner.nextInt();
        makeEmpty(maxNumOfVer);

        scanner.nextLine();
        for (int i=0;i<maxNumOfVer;i++){
            System.out.print("请输入第"+(i+1)+"个顶点的名字：");
            String name=scanner.nextLine();
            insertVertex((E)name);
        }

        System.out.print("请输入边数：");
        int totalEdges=scanner.nextInt();

        for (int i=0;i<totalEdges;i++){
            scanner.nextLine();
            System.out.print("请输入第"+(i+1)+"条边的起点：");
            String from=scanner.nextLine();
            System.out.print("请输入第"+(i+1)+"条边的终点：");
            String to=scanner.nextLine();
            System.out.print("请输入第"+(i+1)+"条边的权重：");
            int cost=scanner.nextInt();

            int v1=getVertexPos((E)from);
            int v2=getVertexPos((E)to);
            if (v1==-1 || v2==-1){
                System.out.println("输入顶点有误！请重新输入！");
                i--;
                continue;
            }
            else {
                insertEdge(v1,v2,cost);
            }
        }
    }

    //******重要函数****** 插入顶点方法
    public boolean insertVertex(E v){
        if (numVertices>=maxNumOfVer) return false;
        Vertex<E> vex=new Vertex<E>(v);
        nodeTable[numVertices++]=vex;
        return true;
    }

    //******重要方法****** 插入边方法
    private boolean insertEdge(int v1, int v2, int cost){
        if (v1<0 || v2<0 || v1>=numVertices || v2>=numVertices){
            return false;
        }

        if (isADJ(v1,v2)) return false;

        Edge edge1=new Edge(v2,cost);

        if (nodeTable[v1].adj==null){
            nodeTable[v1].adj=edge1;
        }
        else {
            edge1.link=nodeTable[v1].adj;
            nodeTable[v1].adj=edge1;
        }

        numEdges++;
        return true;
    }

    //删除边的方法
    private boolean removeEdge(int v1,int v2){
        if (v1<0 || v2<0 || v1>=numVertices || v2>=numVertices){
            return false;
        }

        Edge current=nodeTable[v1].adj;

        if (current==null) return false;

        while (current.link!=null){
            if (current.link.dest==v2){
                current.link=current.link.link;
                numEdges--;
                return true;
            }
        }
        return false;
    }

    //面向用户的插入边方法
    public boolean insertEdge(E from,E to,int cost){
        int v1=getVertexPos((E)from);
        int v2=getVertexPos((E)to);
        if (v1==-1 || v2==-1){
            System.out.println("Error:Vertices not found!");
            return false;
        }
        else {
            insertEdge(v1,v2,cost);
        }
        return true;
    }

    //将现在的图对边进行对称闭包，得到无向图
    public void nonDirect(){
        for (int v=0;v<numVertices;v++){
            int w=getFirstNeighbor(v);
            while (w!=-1){
                if (!isADJ(w,v)){
                    insertEdge(w,v,cost(v,w));
                }
                w=getNextNeighbor(v,w);
            }
        }
    }

    //对无向图有向化，去掉多余的边
    public void direct(){
        for (int v=0;v<numVertices;v++){
            int w=getFirstNeighbor(v);
            while (w!=-1){
                if (isADJ(w,v)) removeEdge(w,v);
                w=getNextNeighbor(v,w);
            }
        }
    }

    //去掉所有的边
    public void deEdge(){
        for (int i=0;i<numVertices;i++){
            nodeTable[i].adj=null;
        }
        numEdges=0;
    }








    /*
     * 遍历方法：遍历顶点
     * 深度优先遍历，广度优先遍历
     * ******重要方法******
     */

    //深度优先遍历算法和递归子算法，不考虑非联通图
    public void DFSprint(){
        boolean[] visited=new boolean[numVertices];
        for (int i=0;i<numVertices;i++) visited[i]=false;

        DFSp(0,visited);
        componentOver();
    }
    private void DFSp(int v, boolean[] visited){
        System.out.print(getContent(v)+"  ");
        visited[v]=true;

        int w=getFirstNeighbor(v);
        while (w!=-1){
            if (!visited[w]) DFSp(w,visited);
            w=getNextNeighbor(v,w);
        }
    }

    //考虑非联通图的情况
    public void cDFSprint(){
        boolean[] visited=new boolean[numVertices];
        for (int i=0;i<numVertices;i++) visited[i]=false;

        for (int i=0;i<numVertices;i++){
            if (!visited[i]){
                DFSp(i,visited);
                componentOver();
            }
        }
    }

    //广度优先算法
    private void BFSp(int v){
        boolean[] visited=new boolean[numVertices];
        for (int i=0;i<numVertices;i++) visited[i]=false;

        for (int i=0;i<numVertices;i++) {//这两行在考虑非联通图的情况下加上
            if (!visited[i]) {//这两行在考虑非联通图的情况下加上

                Pvisit(v, visited);

                QueueLi queueLi = new QueueLi();
                queueLi.enqueue(v);

                while (!queueLi.isEmpty()) {
                    v = (int) queueLi.dequeue();

                    int w = getFirstNeighbor(v);
                    while (w != -1) {
                        if (!visited[w]) {
                            Pvisit(w, visited);
                            queueLi.enqueue(w);
                        }
                        w = getNextNeighbor(v, w);
                    }

                }

                componentOver();

            }//if
        }//for
    }
    //以打印顶点内容的方式来访问顶点，辅助方法
    private void Pvisit(int v,boolean[] visited){
        System.out.print(getContent(v)+"  ");
        visited[v]=true;
    }

    private void componentOver(){
        System.out.println();
    }





    /*
     * ****** 重要方法 ******
     * 最小生成树算法
     * Kruskal算法
     * 变成一棵最小生成树
     * 条件：无向图；如果是有向图则自动当做无向图处理
     * **********************
     *
     */
    public void kruskalSpanningTree(){
        int edgesAccpted=0;
        DisjSets s;
        MinHeap h;
        int u,v;
        int uroot,vroot;
        Edge e;

        h=readGraphIntoMinHeap();
        s=new DisjSets(numVertices);

        edgesAccpted=0;
        while (edgesAccpted<numVertices-1){
            e=(Edge)h.deleteMin();
            u=e.from;
            v=e.dest;
            uroot=s.find(u);
            vroot=s.find(v);
            if (uroot!=vroot){
                edgesAccpted++;
                s.union(uroot,vroot);
                insertEdge(u,v,e.cost);
            }
        }

        nonDirect();
    }
    //将原来的所有边建堆，然后去除所有边。
    private MinHeap readGraphIntoMinHeap(){
        direct();

        Edge[] Edges=new Edge[numEdges+1];
        int counter=1;

        Edge current;
        for (int i=0;i<numVertices;i++){
            current=nodeTable[i].adj;
            while (current!=null){
                current.addFrom(i);
                Edges[counter]=current;
                counter++;
                current=current.link;
            }
        }

        MinHeap heap=new MinHeap();
        heap.initialize(Edges,numEdges);

        deEdge();

        return heap;
    }




    /*
     * ****** 重要方法 ******
     * 最小生成树算法
     * Prim算法
     * 变成一棵最小生成树
     * 条件：必须是无向图，如果是有向图则先无向图化
     * **********************
     *
     */
    public void primSpanningTree(){
        nonDirect();//无向图化

        //定义两个数组
        int totalEdge=numVertices-1;
        int[] lowcost=new int[numVertices];
        int[] nearvex=new int[numVertices];

        //初始化，从0号顶点开始
        for (int i=1;i<numVertices;i++){
            lowcost[i]=cost(0,i);
            nearvex[i]=0;
        }
        nearvex[0]=-1;


        Edge[] edges=new Edge[totalEdge];
        int counter=0;

        for (int i=1;i<numVertices;i++){
            int min=INFINIT;
            int v=0;

            for (int j=1;j<numVertices;j++){
                if (nearvex[j]!=-1 && lowcost[j]<min){
                    v=j;
                    min=lowcost[j];
                }
            }//到这里找到了此时lowcost里最小的数和节点。v中记录了这个节点

            if (v!=0){
                //将这条边挑出来放入数组
                Edge e=new Edge(v,lowcost[v]);
                e.addFrom(nearvex[v]);
                edges[counter]=e;
                counter++;

                //设置为已经查找过
                nearvex[v]=-1;

                //更新两个数组
                for (int j=1;j<numVertices;j++){
                    int newcost=cost(v,j);
                    if (nearvex[j]!=-1 && newcost<lowcost[j]){
                        lowcost[j]=newcost;
                        nearvex[j]=v;
                    }
                }//for
            }//if
        }//for

        deEdge();

        for (int i=0;i<totalEdge;i++){
            insertEdge(edges[i].from,edges[i].dest,edges[i].cost);
        }

        nonDirect();

    }


}
