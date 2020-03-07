package Huffman;

public class Test {
    public static void main(String[] args){
        HuffmanAlphbet alphbet=new HuffmanAlphbet(6);
        /*
        alphbet.getletters("6 S 29 A 8 M 10 T 4 K 7 Q 15");
        alphbet.makeAlphbet();
        alphbet.pringAlphbet();
        System.out.println(alphbet.decode("100110010101110110100101"));


         */
/*
        for (int i=1;i<=26;i++){
            System.out.println((char)('A'-1+i));
        }
        for (int i=1;i<=26;i++){
            System.out.println((char)('a'-1+i));
        }

 */
        alphbet.buildFromText("Wikis have favoured plain-text editing, with fewer and simpler conventions than HTML, for indicating style and structure. Although limiting access to HTML and Cascading Style Sheets (CSS) of wikis limits user ability to alter the structure and formatting of wiki content, there are some benefits. Limited access to CSS promotes consistency in the look and feel, and having JavaScript disabled prevents a user from implementing code that may limit other users' access.");
        alphbet.pringAlphbet();
        System.out.println(alphbet.decode("1110100101111010110100101"));
    }
}
