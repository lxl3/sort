package test;


import linear.TwowayLinklist;

public class TestTwowaylinklist {
    public static void main(String[] args) {
        TwowayLinklist<String> list = new TwowayLinklist<>();
        list.add("姚明");
        list.add("科比");
        list.add("奥迪");
        list.insert(1,"詹姆斯");//姚明 詹姆斯 科比 奥迪
        for(Object str :list){
            System.out.println(str);
        }
        System.out.println("---------------------------");
        System.out.println("第一个元素是"+list.getFirst());
        System.out.println("最后一个元素是"+list.getLast());
        System.out.println("_________________________");
        String ele = list.getItem(1);
        System.out.println(ele);
        String delete = list.remove(2);
        System.out.println(delete);
        int i = list.indexof("姚明");
        System.out.println(i);
        list.clear();
        System.out.println("删除后线性表的长度为"+list.getlength());

    }
}
