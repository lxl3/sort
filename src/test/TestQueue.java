package test;

import linear.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.push("12");
        queue.push("13");
        queue.push("14");
        queue.push("15");
        for(Object que :queue){
            System.out.println(que);
        }
        System.out.println("出对前元素的个数为"+queue.getLength());
        System.out.println("_______________");
        String res = queue.pop();
        System.out.println("出队列的元素为"+res);
        System.out.println("出队后元素的个数为"+queue.getLength());
        for(Object obj : queue){
            System.out.println(obj);
        }

    }
}
