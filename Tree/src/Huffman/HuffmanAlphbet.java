package Huffman;

import java.util.Scanner;

public class HuffmanAlphbet {
    HuffmanNode root;
    HuffmanNode[] letters;

    public HuffmanAlphbet(int n){
        letters=new HuffmanNode[n+1];
    }
    public void makeEmpty(int n){
        root=null;
        letters=new HuffmanNode[n+1];
    }




    public void getletters(String src){
        Scanner scanner=new Scanner(src);
        //System.out.print("请输入字母数：");
        int n=scanner.nextInt();
        makeEmpty(n);
        for (int i=1;i<letters.length;i++){
            //System.out.print("请输入第"+i+"个字母：");
            char ch=scanner.next().charAt(0);
            //System.out.print("请输入第"+i+"个字母的频率：");
            int f=scanner.nextInt();
            letters[i]=new HuffmanNode(ch,f);
        }
    }




    public void makeAlphbet(){
        MinHeap heap=new MinHeap();
        heap.initialize(letters,letters.length-1);
        HuffmanNode nowroot=(HuffmanNode) heap.deleteMin();
        while (!heap.isEmpty()){
            heap.insert(nowroot);
            HuffmanNode tmp1=(HuffmanNode) heap.deleteMin();
            HuffmanNode tmp2=(HuffmanNode) heap.deleteMin();
            HuffmanNode add=new HuffmanNode(tmp1,tmp2);
            heap.insert(add);
            nowroot=(HuffmanNode) heap.deleteMin();
        }
        root=nowroot;

        root.code="";
        preOrderCode(root);
    }
    private void preOrderCode(HuffmanNode p){
        if (p==null) return;
        p.tranCode();
        preOrderCode(p.left);
        preOrderCode(p.right);
    }




    public void pringAlphbet(){
        preOrderPrint(root);
    }
    private void preOrderPrint(HuffmanNode p){
        if (p==null) return;

        if (p.isleaf){
            System.out.println(p.ch+" ------ "+p.frenquence+" ----- "+p.code);
        }
        preOrderPrint(p.left);
        preOrderPrint(p.right);
    }




    public String decode(String codeStr){
        int total=codeStr.length();
        StringBuilder builder=new StringBuilder();
        HuffmanNode current=root;
        for (int i=0;i<total;i++){
            switch (codeStr.charAt(i)){
                case '1':current=current.right;break;
                case '0':current=current.left;break;
            }
            if (current.isleaf){
                builder.append(current.ch);
                current=root;
            }
        }
        return builder.toString();
    }

    public void buildFromText(String str){
        makeEmpty(52);
        for (int i=1;i<=26;i++){
            letters[i]=new HuffmanNode((char)('A'-1+i));
        }
        for (int i=1;i<=26;i++){
            letters[i+26]=new HuffmanNode((char)('a'-1+i));
        }

        char current;
        for (int i=0;i<str.length();i++){
            current=str.charAt(i);
            if (current<='Z' && current>='A'){
                letters[current-'A'+1].frenquence++;
            }
            else if (current<='z' && current>='a'){
                letters[current-'a'+27].frenquence++;
            }
            else continue;
        }

        makeAlphbet();
    }

}
