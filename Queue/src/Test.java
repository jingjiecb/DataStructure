import javax.security.sasl.SaslClient;
import java.time.Year;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("1-数组队列 2-链表队列 3-杨辉三角 4-寻找路线:");
        int mode=scanner.nextInt();

        switch (mode){
            case 1:test1();break;
            case 2:test2();break;
            case 3:test3();break;
            case 4:test4();break;
            default:return;
        }
    }

    private static void test1(){
        Scanner scanner=new Scanner(System.in);
        QueueAr queueAr=new QueueAr();
        int op=1;
        while (op!=0){
            System.out.println("1-入队 2-出队 3-查看队列情况：");
            op=scanner.nextInt();

            switch (op){
                case 1:{
                    System.out.print("请输入元素：");
                    try{
                        queueAr.enqueue(scanner.next());
                    }catch (Overflow e){
                        System.out.println("队列已满，无法加入！");
                    }
                    break;
                }
                case 2:{
                    Object x=queueAr.dequeue();
                    if (x==null){
                        System.out.println("队列空！");
                    }
                    else {
                        System.out.println(x);
                    }
                    break;
                }
                case 3:{
                    queueAr.print();
                    break;
                }
                default:op=0;
            }
        }
    }

    private static void test2(){
        Scanner scanner=new Scanner(System.in);
        QueueLi queueLi=new QueueLi();
        int op=1;
        while (op!=0){
            System.out.println("1-入队 2-出队 3-查看队列情况：");
            op=scanner.nextInt();

            switch (op){
                case 1:{
                    System.out.print("请输入元素：");
                    queueLi.enqueue(scanner.next());
                    break;
                }
                case 2:{
                    Object x=queueLi.dequeue();
                    if (x==null){
                        System.out.println("队列空！");
                    }
                    else {
                        System.out.println(x);
                    }
                    break;
                }
                case 3:{
                    queueLi.print();
                    break;
                }
                default:op=0;
            }
        }
    }

    static void test3(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入层数：");
        int n=scanner.nextInt();
        yangHui(n);
    }

    private static void yangHui(int n){//每次输出完一行，队列里存有下一行的所有结果。所以输出的一行其实是上一行计算的结果
        QueueLi queueLi=new QueueLi();
        queueLi.enqueue(1);
        queueLi.enqueue(1);
        int lastnum;
        for (int i=1;i<=n;i++){
            lastnum=0;
            for (int j=1;j<=i+1;j++){
                int t=(int)queueLi.dequeue();
                System.out.print(t+" ");
                queueLi.enqueue(lastnum+t);
                lastnum=t;
            }
            queueLi.enqueue(1);
            System.out.println();
        }
    }

    private static void test4(){
        Map map=new Map();
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入地图大小：");
        int x,y;
        x=scanner.nextInt();
        y=scanner.nextInt();
        map.setMap(x,y);
        int op=1;
        while (op!=0){
            System.out.println("1-设置墙 2-设置开始位置 3-设置结束位置 4-生成路线：");
            op=scanner.nextInt();

            switch (op){
                case 1:{
                    map.setWall();
                    break;
                }
                case 2:{
                    System.out.println("请输入开始位置坐标：");
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    map.setStart(x,y);
                    break;
                }
                case 3:{
                    System.out.println("请输入结束位置坐标：");
                    x=scanner.nextInt();
                    y=scanner.nextInt();
                    map.setEnd(x,y);
                    break;
                }
                case 4:{
                    if (map.findPath()){
                        map.printPath();
                    }
                    else System.out.println("生成路线失败！");
                }
                default:op=0;
            }
        }

    }
}
