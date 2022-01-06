package test;


import priority.Maxprioripty;

public class Testmaxpriority {
    public static void main(String[] args) {
        Maxprioripty<String> queue = new Maxprioripty<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        while (!queue.isEmpty()){
            String max = queue.deleteMax();
            System.out.print(max+" ");

        }
    }

}
