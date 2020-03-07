package AOENetwork;

import java.util.Arrays;

public class AOENet {
    AOEEdge[] vertices;
    int[] ve;
    int[] vl;
    int[] inDgrees;
    int[] topsort;
    int numV;
    int numE;

    AOENet(int n){
        numV=n;
        vertices=new AOEEdge[numV];
        inDgrees=new int[numV];
        topsort=new int[numV];
        makeEmpty();
    }

    public void makeEmpty(){
        for (int i=0;i<numV;i++){
            vertices[i]=null;
        }
        numE=0;
        Arrays.fill(inDgrees,0);
        Arrays.fill(topsort,-1);
        ve=new int[numV];
        vl=new int[numV];
    }

    public void insertEdge(int v1,int v2,int cost){
        AOEEdge edge1=new AOEEdge(v2,cost);

        if (vertices[v1]==null){
            vertices[v1]=edge1;
        }
        else {
            edge1.link=vertices[v1];
            vertices[v1]=edge1;
        }

        numE++;
        inDgrees[v2]++;
    }


    //********拓扑排序算法**********
    public void topSort(){
        int top=-1;
        int[] count=inDgrees.clone();

        for (int i=0;i<numV;i++){
            if (count[i]==0){
                count[i]=top;
                top=i;
            }
        }

        int counter=0;

        for (int i=0;i<numV;i++){
            if (top==-1){
                System.out.println("Network has a cycle.");
                return;
            }
            else {
                int j=top;
                top=count[top];//出栈一个入度为0的顶点

                topsort[counter]=j;
                counter++;//将顶点加入拓扑排序的结果中

                //删除这个节点及其所有的出边，同时对涉及到的其他顶点的入度进行调整
                AOEEdge l=vertices[j];
                while (l!=null){
                    int k=l.dest;
                    if (--count[k]==0){//调整过程中发现其他顶点入度变成0，那么入栈
                        count[k]=top;
                        top=k;
                    }
                    l=l.link;//查看下一条边
                }
            }
        }
    }

    public void printTop(){
        for (int i=0;i<numV;i++){
            System.out.print(topsort[i]+" <= ");
        }
        System.out.println();
        System.out.println("************************");
    }

    //********求解关键事件和关键路径*********
    public void criticalPath(){
        topSort();

        AOEEdge p;

        //求ve
        for (int i=0;i<numV;i++){
            int v=topsort[i];
            p=vertices[v];//按照拓扑排序的顶点顺序遍历所有边，并将边的另一端点ve更新
            while (p!=null){
                int k=p.dest;
                if (ve[v]+p.cost>ve[k]){
                    ve[k]=ve[v]+p.cost;
                }
                p=p.link;
            }
        }

        for (int i=0;i<numV;i++) vl[i]=ve[topsort[numV-1]];

        //求vl
        for (int i=numV-2;i>=0;i--){
            int v=topsort[i];
            p=vertices[v];//拓扑逆序对每个顶点进行遍历。找到顶点的所有出边，然后根据出边的情况更新vl。
            while (p!=null){
                int k=p.dest;
                if (vl[k]-p.cost<vl[v]){
                    vl[v]=vl[k]-p.cost;
                }
                p=p.link;
            }
        }

        //求每条边的e和l
        for (int i=0;i<numV;i++){
            int v=topsort[i];
            p=vertices[v];
            while (p!=null){
                int k=p.dest;
                p.ee=ve[v];
                p.el=vl[k]-p.cost;
                if (p.ee==p.el){
                    System.out.println(v+"-->"+k+"is a crucial activity.");
                }
                p=p.link;
            }
        }

    }
}
