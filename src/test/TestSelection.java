package test;

import sort.Selection;

import java.util.Arrays;

public class TestSelection {
    public static void main(String[] args) {
        Integer[] array={12,34,56,1,2,7,97,54,6};
        Selection.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
