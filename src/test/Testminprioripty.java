package test;

import priority.Minprioripty;

public class Testminprioripty {
    public static void main(String[] args) {
        Minprioripty<String> queue = new Minprioripty<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("J");
        queue.insert("H");
//        System.out.println(queue.size());
        while (!queue.isEmpty()){
            String min = queue.deleteMin();
            System.out.print(min+" ");
        }
    }
}
