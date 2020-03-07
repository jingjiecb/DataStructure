package Calculator;

import Stack.StackLi;

import java.util.Scanner;

public class Transformer {

    public static String tansToPostfix(String source){
        StackLi stackLi=new StackLi();
        stackLi.push("#");
        Scanner scanner=new Scanner(source);
        String currentStr;
        StringBuilder result=new StringBuilder(1024);
        String topOfStack;


        while (scanner.hasNext()){
            currentStr=scanner.next();
            if (currentStr.equals("#")){
                break;
            }

            if (isdigit(currentStr)){
                result.append(""+currentStr+" ");
            }
            else if (currentStr.equals(")")){
                for (topOfStack=(String)stackLi.topAndPop();
                     !topOfStack.equals("(");
                     topOfStack=(String)stackLi.topAndPop()){
                    result.append(topOfStack+" ");
                }
            }
            else {
                for (topOfStack=(String)stackLi.topAndPop();
                     inStackPriority(topOfStack)>outStackPriority(currentStr);
                     topOfStack=(String)stackLi.topAndPop()){
                    result.append(topOfStack+" ");
                }
                stackLi.push(topOfStack);
                stackLi.push(currentStr);
            }
        }

        while (!stackLi.isEmpty()){
            topOfStack=(String)stackLi.topAndPop();
            result.append(topOfStack+" ");
        }

        return result.toString();
    }

    private static Boolean isdigit(String s){
        if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^")||s.equals("#")||s.equals("(")||s.equals(")")){
            return false;
        }
        else return true;
    }

    private static int inStackPriority(String s){
        char Op=s.charAt(0);
        switch (Op){
            case '#':return -1;
            case '(':return 0;
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
            case '^':return 3;
            default: System.out.println("Word Error!");return 0;
        }
    }

    private static int outStackPriority(String s){
        char Op=s.charAt(0);
        switch (Op){
            case '#':return -1;
            case '(':return 9;
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
            case '^':return 3;
            default: System.out.println("Word Error!");return 0;
        }
    }

}
