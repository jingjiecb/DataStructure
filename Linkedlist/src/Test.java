import CircularLinkedList.CircleItr;
import CircularLinkedList.CircleLinkedList;
import SingleLinkedList.LinkedList;
import SingleLinkedList.LinkedListItr;
import DoubleLinkedList.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        System.out.println("请选择模式\n1-单链表\n2-双向链表\n3-循环单链表\n其他-退出");
        Scanner scanner=new Scanner(System.in);
        int mode;
        if (scanner.hasNextInt()) mode=scanner.nextInt();
        else return;
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
                test3();
                break;
            }
            default:System.out.println("退出");
            return;
        }
    }

    private static void test1(){
        Scanner scanner=new Scanner(System.in);
        LinkedList list=new LinkedList();
        while (true){
            System.out.println("请选择操作\n1-插入\n2-删除\n3-查看当前链表状态\n其他-退出");
            int act;
            if (scanner.hasNextInt()) act=scanner.nextInt();
            else return;
            switch (act){
                case (1):{
                    if (list.isEmpty()){
                        System.out.print("请插入第一个元素：");
                        Object ele1=scanner.next();
                        list.insert(ele1,list.zeroth());
                    }
                    else {
                        System.out.print("请输入插入位置(head表示插在最前面)：");
                        Object ele_from=scanner.next();
                        LinkedListItr itr;
                        if (ele_from.equals("head")) {
                            itr=list.zeroth();
                        }
                        else {
                            itr=list.find(ele_from);
                        }
                        System.out.print("请输入元素：");
                        Object elen=scanner.next();
                        list.insert(elen,itr);
                    }
                    break;
                }
                case (2):{
                    System.out.print("请输入要删除的元素：");
                    Object elen=scanner.next();
                    list.remove(elen);
                    break;
                }
                case (3):{
                    LinkedList.printList(list);
                    break;
                }
                default:{
                    System.out.println("退出");
                    return;
                }
            }
        }
    }

    private static void test2(){
        Scanner scanner=new Scanner(System.in);
        DoubleLinkedList list=new DoubleLinkedList();
        while (true){
            System.out.println("请选择操作\n1-插入\n2-删除\n3-查看当前链表状态\n其他-退出");
            int act;
            if (scanner.hasNextInt()) act=scanner.nextInt();
            else return;
            switch (act){
                case (1):{
                    if (list.isEmpty()){
                        System.out.print("请插入第一个元素：");
                        Object ele1=scanner.next();
                        list.insertNext(ele1,list.zeroth());
                    }
                    else {
                        System.out.print("请输入插入位置(head表示插在最前面)：");
                        Object ele_from=scanner.next();
                        DoubleLinkedListItr itr;
                        if (ele_from.equals("head")) {
                            itr=list.zeroth();
                        }
                        else {
                            itr=list.find(ele_from);
                        }
                        System.out.print("请输入元素：");
                        Object elen=scanner.next();
                        list.insertNext(elen,itr);
                    }
                    break;
                }
                case (2):{
                    System.out.print("请输入要删除的元素：");
                    Object elen=scanner.next();
                    list.remove(elen);
                    break;
                }
                case (3):{
                    DoubleLinkedList.printList(list);
                    break;
                }
                default:{
                    System.out.println("退出");
                    return;
                }
            }
        }
    }

    private static void test3(){
        Scanner scanner=new Scanner(System.in);
        CircleLinkedList list=new CircleLinkedList();
        while (true){
            System.out.println("请选择操作\n1-插入\n2-删除\n3-查看当前链表状态\n其他-退出");
            int act;
            if (scanner.hasNextInt()) act=scanner.nextInt();
            else return;
            switch (act){
                case (1):{
                    if (list.isEmpty()){
                        System.out.print("请插入第一个元素：");
                        Object ele1=scanner.next();
                        list.insert(ele1,list.getHeadNode());
                    }
                    else {
                        System.out.print("请输入插入位置：");
                        Object ele_from=scanner.next();
                        CircleItr itr;
                        itr=list.find(ele_from);
                        System.out.print("请输入元素：");
                        Object elen=scanner.next();
                        list.insert(elen,itr);
                    }
                    break;
                }
                case (2):{
                    System.out.print("请输入要删除的元素：");
                    Object elen=scanner.next();
                    list.remove(elen);
                    break;
                }
                case (3):{
                    CircleLinkedList.printList(list);
                    break;
                }
                default:{
                    System.out.println("退出");
                    return;
                }
            }
        }
    }
}