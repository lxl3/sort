package test;


import linear.SequenceList;

public class TestSequence2 {
    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList<>(3);
        list.add("两岸三地");
        list.add("asd");
        list.add("asdsa");
        list.add("dasdsa");
        System.out.println(list.getLength());
        System.out.println(list.get());

    }
}
