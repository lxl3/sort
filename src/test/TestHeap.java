package test;

import heap.heap;

public class TestHeap {
    public static void main(String[] args) {
       heap<Integer> heaps = new heap<Integer>(10);
       heaps.insert(10);
       heaps.insert(8);
       heaps.insert(4);
       heaps.insert(11);
       heaps.insert(3);
       heaps.insert(7);
       Integer res=null;
       while ((res=heaps.delete())!=null){
           System.out.println(res+",");
       }
       

    }
}
