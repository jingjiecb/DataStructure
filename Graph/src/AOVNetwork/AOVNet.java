package AOVNetwork;

import java.util.Arrays;

public class AOVNet {
    AOVEdge[] vertices;
    int[] inDgrees;
    int[] topsort;
    int numV;
    int numE;

    AOVNet(int n){
        numV=n;
        vertices=new AOVEdge[numV];
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
    }

    public void insertEdge(int v1,int v2){
        AOVEdge edge1=new AOVEdge(v2);

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
                AOVEdge l=vertices[j];
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


}
