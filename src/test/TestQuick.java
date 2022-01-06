package test;

import sort.Quick;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args) {
        Integer [] array={123,354,56,67,87,9,67,87,1,3};
        Quick.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
