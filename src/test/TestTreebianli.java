package test;

import linear.Queue;
import tree.BinaryTree;


public class TestTreebianli {
    public static void main(String[] args) {
      BinaryTree tree= new BinaryTree<Integer,String>();
      tree.put(2,"小明");
      tree.put(1,"李磊");
      tree.put(3,"陈哦");
      tree.put(4,"李四");
//      tree.put(5,"李四");
//      tree.put(6,"李四");
//      tree.put(8,"李四");

    Queue pre = tree.pre();
        System.out.println("先序遍历结果为");
    for(Object obj:pre){
        System.out.print(obj+",");
    }
        System.out.println();
        Queue mid = tree.mid();
        System.out.println("中序遍历结果为");
    for(Object obj: mid){
        System.out.print(obj+",");
    }
        System.out.println();
        Queue head = tree.head();
        System.out.println("后续遍历结果为");
    for (Object obj : head){
        System.out.print(obj+",");
    }
        System.out.println();
        System.out.println("层序遍历的结果为");
        Queue layer = tree.layer();
        for(Object obj : layer){
            System.out.print(obj+",");
        }
        System.out.println();
        int maxdepth = tree.maxdepth();
        System.out.println("该树的最大深度为"+maxdepth);

    }
}
