package test;

import sort.Bubble;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args) {
        Integer [] array={11,3,56,98,5,3,4,2,1};
        Bubble.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
