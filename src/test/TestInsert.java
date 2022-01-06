package test;

import sort.Insertion;

import java.util.Arrays;

public class TestInsert {
    public static void main(String[] args) {
        Integer[] array={123,3543,657,23,12,87,4};
        Insertion.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
