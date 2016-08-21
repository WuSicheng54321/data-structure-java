package com.xiaolu.stack;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/30.
 */
public class MyLinkedStackTest {
    //基本入栈及出栈测试
    @Test
    public void push() throws Exception {
        MyLinkedStack<Integer> stack=new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.show();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }

    //平衡符号
    @Test
    public void testBracket(){
        System.out.print(bracket("[[[[[[{[]{}()}]]]]]]]]]]]]]]"));
    }

    public boolean bracket(String s){
        MyLinkedStack<Character> stack=new MyLinkedStack<>();
        System.out.print(Integer.getInteger("1"));
        char c[]=s.toCharArray();
        if(c[0]==')'||c[0]=='>'||c[0]==']'||c[0]=='}'){
            return false;
        }
        for(int i=0;i<c.length;i++){
            if(c[i]=='['){
                stack.push(c[i]);
            }
            if(c[i]=='<'){
                stack.push(c[i]);
            }
            if(c[i]=='('){
                stack.push(c[i]);
            }
            if(c[i]=='{'){
                stack.push(c[i]);
            }
            if(c[i]==']'){
                if(stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }
            if(c[i]==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }
            if(c[i]=='>'){
                if(stack.isEmpty()||stack.pop()!='<'){
                    return false;
                }
            }
            if(c[i]=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    //后缀表达式
    @Test
    public void calculate(){
        Scanner in=new Scanner(System.in);
        String[] input={"1","2","+","="};
        MyLinkedStack<Integer> stack=new MyLinkedStack<>();
/*        while(!in.equals("exit")){
            for(int i=0;i<10;i++){
                input[i]=in.nextLine();
            }
        }*/
        for(int i=0;i<3;i++){
            if(input[i].matches("\\d+")){
                stack.push(Integer.getInteger(input[i]));
            }
            if(input[i].equals("+")){
/*                Integer add1=stack.pop();
                Integer add2=stack.pop();
                Integer add=add1+add2;
                stack.push(add);*/
            }
            if(input[i].equals("-")){
                Integer sub=stack.pop()-stack.pop();
                stack.push(sub);
            }
            if(input[i].equals("*")){
                Integer mul=stack.pop()*stack.pop();
                stack.push(mul);
            }
            if(input[i].equals("/")){
                Integer spi=stack.pop()/stack.pop();
                stack.push(spi);
            }
            if (input[i].equals("=")){
                System.out.print(stack.pop());
            }
        }
    }

}