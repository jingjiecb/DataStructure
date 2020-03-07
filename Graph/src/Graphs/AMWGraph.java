package Graphs;

import LALGraph.Edge;

import java.util.ArrayList;
import java.util.Arrays;

//邻接矩阵表示图,有向图，有权重。
public class AMWGraph {

    private int[][] edges;
    private int numOfEdges;
    private int numV;
    private boolean di;
    private static final int INFINIT=2147483647;

    private int dist[];
    private int path[];
    private boolean s[];
    private int a[][];
    private int pathF[][];


    //初始化矩阵，一维数组，和边的数目
    //构造函数，输入顶点的个数
    public AMWGraph(int n){
        edges=new int[n][n];
        makeEmpty();
        //vertexList=new ArrayList(n);
        numV=edges.length;
        dist=new int[numV];
        path=new int[numV];
        s=new boolean[numV];
        numOfEdges=0;
        System.out.println("Graph constructed!");
    }

    public void setDi(boolean di) {
        this.di = di;
    }

    public void makeEmpty(){
        for (int i=0;i<edges.length;i++) Arrays.fill(edges[i],INFINIT);
        for (int i=0;i<edges.length;i++) edges[i][i]=0;
    }

    //得到节点的个数和边的个数
    public int getNumOfVertex(){
        return edges.length;
    }
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //得到边的权重
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //插入带权重的边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        if (!di) edges[v2][v1]=weight;
        numOfEdges++;
    }
    //删除边
    public void deleteEdge(int v1,int v2){
        edges[v1][v2]=INFINIT;
        if (!di) edges[v2][v1]=INFINIT;
        numOfEdges--;
    }

    //查询邻接算法
    public int getFirstNeighbor(int index){
        for (int j=0;j<edges.length;j++){
            if (edges[index][j]!=INFINIT){
                return j;
            }
        }
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<edges.length;j++){
            if (edges[v1][j]!=INFINIT){
                return j;
            }
        }
        return -1;
    }





    /*
     * 最短路径算法
     * Dijkstra算法
     * BellmanFord算法
     * Floyed算法
     *
     */
    public void dijkstra(int v){
        for (int i=0;i<numV;i++){
            dist[i]=edges[v][i];
            s[i]=false;
            if (i!=v && dist[i]<INFINIT) path[i]=v;
            else path[i]=-1;
        }

        s[v]=true;
        dist[v]=0;

        for (int i=0;i<numV-1;i++){

            int min=INFINIT;
            int u=v;
            for (int j=0;j<numV;j++){
                if (!s[j] && dist[j]<min){
                    u=j;
                    min=dist[j];
                }
            }//排序找到这个时候dist中最小的顶点。

            s[u]=true;//到这个顶点的最短路径找到了

            //更新一下表，如果从这个顶点绕路比原来的更短，那么把现在这个顶点作为path，距离更新为绕路的长度
            for (int w=0; w<numV;w++){
                if (!s[w] && edges[u][w]<INFINIT && dist[u]+edges[u][w]<dist[w]){
                    dist[w]=dist[u]+edges[u][w];
                    path[w]=u;
                }
            }
        }
    }

    public void bellmanFord(int v){
        for (int i=0;i<numV;i++){
            dist[i]=edges[v][i];
            if (i!=v && dist[i]<INFINIT) path[i]=v;
            else path[i]=-1;
        }

        for (int k=2;k<numV;k++){//一共只需要n-2次更新就可以把所有最短路径求出来
            for (int u=0;u<numV;u++){//考虑每一个顶点
                if (u!=v){
                    for (int i=0;i<numV;i++){//考虑从每一个其他顶点绕的情况
                        if (edges[i][u]!=0 && edges[i][u]<INFINIT && dist[u]>dist[i]+edges[i][u]){
                            dist[u] =dist[i]+edges[i][u];
                            path[u]=i;
                        }
                    }
                }
            }
        }
    }

    public void floyed(){
        a=new int[numV][numV];
        pathF=new int[numV][numV];

        for (int i=0;i<numV;i++){
            for (int j=0;j<numV;j++){
                a[i][j]=edges[i][j];
                if (i!=j && a[i][j]<INFINIT) pathF[i][j]=i;
                else pathF[i][j]=-1;
            }
        }//初始化

        for (int k=0;k<numV;k++){//进行n次迭代。每次表示从第k个顶点绕会不会路径变短
            for (int i=0;i<numV;i++){//遍历整张表格
                for (int j=0;j<numV;j++){//遍历整张表格
                    if (a[i][k]==INFINIT || a[k][j]==INFINIT) continue;
                    if (a[i][k]+a[k][j]<a[i][j]){//如果从k绕路变短了，那就更新
                        a[i][j]=a[i][k]+a[k][j];
                        pathF[i][j]=pathF[k][j];
                    }
                }
            }

            printA(a);
        }

        printA(pathF);
    }













    /*
     * 测试方法
     *
     */

    public void print(){
        printA(edges);
    }
    public void printPath(){
        printB(dist);
        printB(path);
    }
    private void printA(int[][] input){
        int i,j;
        int n=input.length;
        System.out.print("    ");
        for (i=0;i<n;i++){
            System.out.printf("%4d",i);
        }
        System.out.println();

        for (i=0;i<n;i++){
            System.out.printf("%4d",i);
            for (j=0;j<n;j++){
                if (input[i][j]!=INFINIT)  System.out.printf("%4d",input[i][j]);
                else System.out.printf("  --");
            }
            System.out.println();
        }

        System.out.println("*******************************");
    }
    private void printB(int[] input){
        for (int i=0;i<numV;i++){
            System.out.printf("%4d",i);
            System.out.printf("%4d\n",input[i]);
        }
        System.out.println("**********");
    }






    //面向用户设计的非必要方法
    /*
    private ArrayList vertexList;
    public void insertEdge(Object name1,Object name2,int weight){
        int v1=vertexList.indexOf(name1);
        int v2=vertexList.indexOf(name2);
        if (v1==-1||v2==-1){
            System.out.println("No such vertex!");
            return;
        }

        insertEdge(v1,v2,weight);
    }
    public Object getValueByIndex(int i){
        return vertexList.get(i);
    }
    //插入没有权重的边，默认权重为1
    public void insertEdge(int v1,int v2){
        edges[v1][v2]=1;
        numOfEdges++;
    }
    //插入节点
    public void insertVertex(Object vertex){
        vertexList.add(vertexList.size(),vertex);
    }

     */

}
