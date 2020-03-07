package Huffman;

public class HuffmanNode implements Comparable{
    int frenquence;
    HuffmanNode left,right;
    char ch;
    boolean isleaf;
    String code="";

    HuffmanNode(char c){
        frenquence=0;
        ch=c;
        isleaf=true;
    }

    HuffmanNode(char c,int f){
        frenquence=f;
        ch=c;
        isleaf=true;
    }

    HuffmanNode(HuffmanNode a,HuffmanNode b){
        left=a;right=b;
        isleaf=false;
        frenquence=a.frenquence+b.frenquence;
    }

    public void tranCode(){
        if (left!=null) left.code=code+"0";
        if (right!=null) right.code=code+"1";
    }

    @Override
    public int compareTo(Object o) {
        HuffmanNode b=(HuffmanNode) o;
        if (b.frenquence>frenquence) return -1;
        else if (b.frenquence<frenquence) return 1;
        else return 0;
    }
}
