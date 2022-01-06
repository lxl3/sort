package test;

import sort.Shell;

import java.util.Arrays;

public class TestShell {
    public static void main(String[] args) {
        Integer array[]={123,1212,45,3,56,7,8,3,21,1,12,54,56};
        Shell.sort(array);
        System.out.println(Arrays.toString(array));


    }
}
