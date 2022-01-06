package test;

import Simbal.OrderSimbalTable;


public class TestOrderSimbal {
    public static void main(String[] args) {
        OrderSimbalTable<Integer,String> tab=new OrderSimbalTable<>();
        tab.add(1,"张三");
        tab.add(2,"李四");
        tab.add(4,"赵六");
        tab.add(7,"阿斯兰的");

        tab.add(3,"小明");

    }
}
