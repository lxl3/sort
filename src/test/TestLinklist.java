package test;

import linear.Linklist;


public class TestLinklist {
    public static void main(String[] args) {
        Linklist<String> list = new Linklist();
        list.add("姚明");
        list.add("科比");
        list.add("奥迪");
        list.insert(1,"詹姆斯");//姚明   詹姆斯 科比 奥迪
        for(Object str :list){
           System.out.println(str);
        }
        System.out.println("_________________________");
        String ele = list.getNode(1);
        System.out.println(ele);
        String delete = list.remove(2);
        System.out.println(delete);
        int i = list.getIndex("科比");
        System.out.println(i);
        list.clear();
        System.out.println("删除后线性表的长度为"+list.getNum());
    }
}
