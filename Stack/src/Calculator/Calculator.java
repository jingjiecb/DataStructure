package Calculator;
import Stack.StackLi;

import java.util.Scanner;

public class Calculator {

    private StackLi stackLi;
    private String sourse;

    public Calculator(){
        stackLi=new StackLi();
    }

    public void clear(){
        stackLi.makeEmpty();
    }

    public double run(){
        Scanner scanner=new Scanner(sourse);
        String word;
        char type;
        double result;

        while (scanner.hasNext()){
            word=scanner.next();
            type=classify(word);
            //System.out.println(type);
            if (type=='#') break;
            else if (type=='x'){
                addOperand(Double.valueOf(word));
            }
            else {
                doOperator(type);
            }
        }

        if (stackLi.isEmpty()){
            System.out.println("ERROR! No Num In Stack!");
            return 0;
        }
        else {
            result=(double)stackLi.topAndPop();
            if (!stackLi.isEmpty()){
                System.out.println("ERROR! Stack Left!");
                return 0;
            }
            return result;
        }
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    private void addOperand(double value){
        stackLi.push(value);
    }

    private void doOperator(char op){
        double left;
        double right;

        switch (op){
            case '+': {
                try {
                    right = (double) stackLi.top();
                    stackLi.pop();
                    left = (double) stackLi.top();
                    stackLi.pop();
                    addOperand(left + right);
                } catch (Exception e) {
                    System.out.println("Losing Operand!");
                }
                break;
            }
            case '-':{
                try {
                    right = (double) stackLi.top();
                    stackLi.pop();
                    left = (double) stackLi.top();
                    stackLi.pop();
                    addOperand(left - right);
                } catch (Exception e) {
                    System.out.println("Losing Operand!");
                }
                break;
            }
            case '*':{
                try {
                    right = (double) stackLi.top();
                    stackLi.pop();
                    left = (double) stackLi.top();
                    stackLi.pop();
                    addOperand(left * right);
                } catch (Exception e) {
                    System.out.println("Losing Operand!");
                }
                break;
            }
            case '/':{
                try {
                    right = (double) stackLi.top();
                    stackLi.pop();
                    left = (double) stackLi.top();
                    stackLi.pop();
                    addOperand(left / right);
                } catch (Exception e) {
                    System.out.println("Losing Operand!");
                }
                break;
            }
            case '^':{
                try {
                    right = (double) stackLi.top();
                    stackLi.pop();
                    left = (double) stackLi.top();
                    stackLi.pop();
                    addOperand(Math.pow(left,right));
                } catch (Exception e) {
                    System.out.println("Losing Operand!");
                }
                break;
            }
            default:
                System.out.println("Losing Operator!");
        }
    }

    private char classify(String s){
        if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^")||s.equals("#")){
            return s.charAt(0);
        }
        else return 'x';
    }


}
