package test;

import sort.Merge;

import java.util.Arrays;

public class Testmerge {
    public static void main(String[] args) {
        Integer [] array={12,234,546,675,234,2,23435,546,547,22,34,1};
        Merge.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
