package test;

import linear.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for(Object s : stack){
            System.out.println(s);
        }
        String result = stack.pop();
        System.out.println("弹出的元素是"+result);
        System.out.println("栈中剩余的元素个数为"+stack.getlength());
    }
}
