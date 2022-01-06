package test;

import tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer,String>tree=new BinaryTree<>();
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王二");
        tree.put(4,"麻子");
        String s = tree.get(1);
        System.out.println("key为1的元素为"+s);
        System.out.println("该数的节点个数为"+tree.getNum());
        tree.delete(1);
        tree.delete(2);
        tree.delete(3);
        tree.delete(4);
        System.out.println(tree.get(1));
        System.out.println("该树剩余的节点个数为"+tree.getNum());
        Integer min = tree.min();
        System.out.println("最小的键为"+min);
        Integer max = tree.max();
        System.out.println("最大的键为"+max);
    }
}
