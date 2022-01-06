package test;

import linear.Linklist;


public class TestLinklist2 {
    public static void main(String[] args) {
        Linklist<String> list = new Linklist();
        list.add("姚明");
        list.add("科比");
        list.add("奥迪");
        list.insert(1,"詹姆斯");//姚明   詹姆斯 科比 奥迪
        for(Object str :list){
           System.out.println(str);
        }
        System.out.println("____________________________");
        list.reverse();
        for(Object str :list){
            System.out.println(str);
        }

    }
}
