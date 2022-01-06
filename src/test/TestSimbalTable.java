package test;

import Simbal.SimbalTable;

public class TestSimbalTable {
    public static void main(String[] args) {
        SimbalTable<Integer,String> tab=new SimbalTable<>();
        tab.add(1,"虚竹");
        tab.add(2,"段誉");
        tab.add(3,"乔峰");
        tab.add(4,"三丰");
        System.out.println("插入后元素的个数是"+tab.getLenth());
        String value = tab.getValue(3);
        System.out.println("3位置的元素值为"+value);
        tab.add(3,"慕容复");
        System.out.println("修改后，3号元素的值为"+tab.getValue(3));
        tab.delete(4);
        System.out.println("删除后，元素的个数是"+tab.getLenth());
    }
}
