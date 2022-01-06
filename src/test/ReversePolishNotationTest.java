package test;

import java.util.Stack;

/**
 * 用栈的思想解决逆波兰表达式
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 12+3*5+9/3
        //逆波兰表达式 12，3，5 ，*，9，3，/，+
        String [] str2={"12","3","5","*","9","3","/","+","+"};//30
        String [] str={"3","17","15","-","*","18","6","/","+"};//9
        int resverpolish = Resverpolish(str2);
        System.out.println(resverpolish);


    }
    public static int Resverpolish(String[] str){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<str.length;i++){
            //如果是运算符，弹出两个元素做运算
            switch (str[i]){
                case "+":
                    Integer op1 = Integer.valueOf(stack.pop());
                    Integer op2 = Integer.valueOf(stack.pop());
                    Integer result=op1+op2;
                    String s = result.toString(result);
                    stack.push(s);
                    break;
                case "-":
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    result=op2-op1;
                    s = result.toString(result);
                    stack.push(s);
                    break;
                case "*":
                     op1 = Integer.valueOf(stack.pop());
                     op2 = Integer.valueOf(stack.pop());
                    result=op1*op2;
                     s = result.toString(result);
                    stack.push(s);
                    break;
                case "/":
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    result=op2/op1;
                     s = result.toString(result);
                    stack.push(s);
                    break;
                default:
                    //如果是数字，入栈
                    stack.push(str[i]);
                    break;
            }

        }
        Integer res = Integer.valueOf(stack.pop());
        return  res;

    }
}
