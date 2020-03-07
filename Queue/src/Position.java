public class Position {
    int row;
    int col;

    public Position(int therow,int thecol){
        row=therow;
        col=thecol;
    }

    public Position(){
        this(0,0);
    }


    public String toString(){
        return "("+row+","+col+")";
    }

}
