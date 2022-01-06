package test;

import linear.Stack;

/**
 * 用栈解决括号匹配问题
 */
public class BracketMatchTest {
    public static void main(String[] args) {
        String str="((你在干嘛)()";
        System.out.println(Match(str) ? "括号匹配" :"括号不匹配");
    }



    /**
     * 判断是否匹配
     * @param str
     * @return
     */
  public static boolean Match(String str){
      Stack<String>stack= new Stack<String>();
      //循环遍历每一个字符，判断是不是（ 或者 ）
      for(int i=0;i<str.length();i++){
         String c=str.charAt(i)+"";
          if(c.equals("(")){
              //如果是左括号，入栈
              stack.push(c);
          }else if(c.equals(")")){
              //如果是右括号，从栈中去除一个元素，如果去除的元素为null，说明不匹配
              String pop = stack.pop();
              if(pop==null){
                  return false;
              }
          }
      }
      if(stack.getlength()==0){
          return true;
      }else{
          return false;
      }
  }

}
