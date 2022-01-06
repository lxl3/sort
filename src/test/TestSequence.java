package test;

import linear.SequenceList;

public class TestSequence {
    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>(10);
        list.add("姚明");
        list.add("科比");
        list.add("奥迪");
        list.insert(1,"詹姆斯");//姚明 詹姆斯 科比 奥迪
        for(String str :list){
           System.out.println(str);
        }
        System.out.println("_________________________");
        String ele = list.getEle(1);
        System.out.println(ele);
        String delete = list.delete(2);
        System.out.println(delete);
        int i = list.getfirst("姚明");
        System.out.println(i);
        list.clear();
        System.out.println("删除后线性表的长度为"+list.get());
    }
}
