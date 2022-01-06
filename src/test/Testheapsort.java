package test;

import heap.heapsort;

public class Testheapsort {
    public static void main(String[] args) {
     String arr[]= {"A","C","Z","B","M","N","T"};
        heapsort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }

    }
}
