import Calculator.*;
import Stack.StackAr;
import Stack.StackLi;

import java.util.Scanner;

public class Test {
    private static void test1(){
        Scanner scanner=new Scanner(System.in);
        int op=1;
        StackLi stackLi=new StackLi();

        while (op!=0) {
            System.out.print("1-入栈 2-出栈并打印出栈元素：");
            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
            } else {
                op = 0;
            }
            switch (op){
                case (1):{
                    System.out.print("请输入入栈元素：");
                    stackLi.push(scanner.next());
                    break;
                }
                case (2):{
                    System.out.println(stackLi.topAndPop());
                    break;
                }
                default:return;
            }
        }
    }

    private static void test2(){
        Scanner scanner=new Scanner(System.in);
        int op=1;
        StackAr stackAr=new StackAr();

        while (op!=0){
            System.out.print("1-入栈 2-出栈并打印出栈元素 3-打印所有元素：");
            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
            } else {
                op = 0;
            }
            switch (op){
                case (1):{
                    System.out.print("请输入入栈元素：");
                    try {
                        stackAr.push(scanner.next());
                    }
                    catch (Exception e){
                        System.out.println("Stack.Overflow!");
                        return;
                    }
                    break;
                }
                case (2):{
                    System.out.println(stackAr.topAndPop());
                    break;
                }
                case (3):{
                    stackAr.print();
                    break;
                }
                default:return;
            }
        }
    }

    private static void matchParenthesis(String sourse){
        StackAr stackAr=new StackAr(100);
        int j,length=sourse.length();

        for (int i=1;i<=length;i++){
            if (sourse.charAt(i-1)=='(') {
                try{
                    stackAr.push(i);
                }
                catch (Exception e){
                    System.out.println("Stack.Overflow!");
                    return;
                }
            }
            else if (sourse.charAt(i-1)==')'){
                try {
                    j=(int)stackAr.top();
                    stackAr.pop();
                    System.out.println(j+" "+i);
                }
                catch (Exception e){
                    System.out.println(i+"有多余的)");
                }
            }
        }

        while (!stackAr.isEmpty()){
            j=(int)stackAr.topAndPop();
            System.out.println(j+"有多余的(");
        }
    }

    private static double calculate(String sourse){
        Calculator calculator=new Calculator();
        calculator.setSourse(sourse);
        double result=calculator.run();
        return result;
    }

    private static String infixToPostfix(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入中缀表达式，用空格隔开元素：");
        String source=scanner.nextLine();
        System.out.println("后缀表达式是：");
        String result=Transformer.tansToPostfix(source);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int mode=0;
        System.out.print("1-链表实现的栈 2-数组实现的栈 3-左右括号匹配 4-后缀表达式计算 5-中缀化后缀 6-中缀表达式计算：");
        if (scanner.hasNextInt()){
            mode=scanner.nextInt();
        }

        switch (mode){
            case (1):{
                test1();
                break;
            }
            case (2):{
                test2();
                break;
            }
            case (3):{
                System.out.print("请输入表达式：");
                scanner.nextLine();
                String str=scanner.nextLine();
                matchParenthesis(str);
                break;
            }
            case 4:{
                System.out.println("请输入后缀表达式，元素间用空格隔开：");
                String sourse=scanner.nextLine();
                System.out.println("结果是："+calculate(sourse));
                break;
            }
            case 5:{
                infixToPostfix();
                break;
            }
            case 6:{
                System.out.println(calculate(infixToPostfix()));break;
            }
            default:return;
        }
    }
}
