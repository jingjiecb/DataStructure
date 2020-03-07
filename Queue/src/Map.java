import java.util.Scanner;

public class Map {

    /*
    static int[][] map=new int[1][1];

    private Map(){}
    private static Map mapinstance=new Map();
    public static Map getMap() {
        if (map!=null){
            return mapinstance;
        }
        else{
            System.out.println("地图信息没有初始化！");
            return null;
        }
    }
     */

    int[][] map=null;

    Position start=null,end=null;

    final static Position[] offset=new Position[4];

    {
        offset[0]=new Position(0,1);
        offset[1]=new Position(1,0);
        offset[2]=new Position(0,-1);
        offset[3]=new Position(-1,0);
    }

    private  Position[] path;

    public void setMap(int rowlength,int collength){
        map=new int[rowlength+2][collength+2];
        int i;
        for (i=0;i<collength+1;i++){
            map[0][i]=map[rowlength+1][i]=-1;
        }
        for (i=0;i<rowlength+1;i++){
            map[i][0]=map[i][collength+1]=-1;
        }
    }

    public void setWall(){
        Scanner scanner=new Scanner(System.in);
        int x,y;
        printMap();
        while (true){
            System.out.println("请添加墙的位置,-1结束：");
            x=scanner.nextInt();
            if (x==-1) break;
            y=scanner.nextInt();
            map[x][y]=-1;
            printMap();
        }

    }

    public void printMap(){
        if (map==null){
            System.out.println("地图没有初始化！");
        }
        else {
            for (int i=1;i<=map.length-2;i++){
                for (int j=1;j<=map[0].length-2;j++){
                    System.out.printf("%2d   ",map[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println("----------------------------------");
    }

    public void setStart(int row,int col){
        map[row][col]=1;//-1标记表示起点
        start=new Position(row,col);
        printMap();
    }

    public void setEnd(int row,int col){
        map[row][col]=-2;//-2标记表示终点;
        end=new Position(row,col);
        printMap();
    }


    public boolean findPath(){
        if (start==null||map==null||end==null){
            System.out.println("地图信息不全！");
            return false;
        }

        int pathLen;
        Position here=start;
        Position nbr=new Position();
        QueueLi queueLi=new QueueLi();


        while (true){
            for (int i=0;i<4;i++){
                nbr.row=here.row+offset[i].row;
                nbr.col=here.col+offset[i].col;
                if (map[nbr.row][nbr.col]==0||map[nbr.row][nbr.col]==-2){
                    map[nbr.row][nbr.col]=map[here.row][here.col]+1;
                    //printMap();
                    if (nbr.row==end.row && nbr.col==end.col) {
                        //System.out.println(nbr.toString()+"get!");
                        break;
                    }
                    queueLi.enqueue(new Position(nbr.row,nbr.col));
                }
            }
            if (nbr.row==end.row && nbr.col==end.col) break;
            if (queueLi.isEmpty()) return false;
            here=(Position) queueLi.dequeue();
        }
        System.out.println("mark complete!");
        printMap();

        pathLen=map[end.row][end.col]-1;
        path=new Position[pathLen];

        here=new Position(end.row,end.col);
        //System.out.println(pathLen);

        for (int j=pathLen-1;j>=0;j--){
            //System.out.println(j);
            path[j]=new Position(here.row,here.col);
            for (int i=0;i<4;i++){
                nbr.row=here.row+offset[i].row;
                nbr.col=here.col+offset[i].col;
                if (map[nbr.row][nbr.col]==j+1)break;
            }
            here.row=nbr.row;
            here.col=nbr.col;
        }
        return true;
    }

    public void printPath(){
        System.out.print(start.toString());
        for (Position a:path){
            System.out.print("-->"+a.toString());
        }
    }
}
