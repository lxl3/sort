package test;

import sort.Insertion;
import sort.Merge;
import sort.Quick;
import sort.Shell;

import java.io.*;
import java.util.ArrayList;


public class TestCompare {
    public static void main(String[] args) throws IOException {
        //writerFile();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(TestCompare.class.getClassLoader().getResourceAsStream("./test.txt")));
        String line="";
        while((line=bufferedReader.readLine())!=null){
            list.add(Integer.parseInt(line));
        }
        Integer []a= new Integer[list.size()];
        list.toArray(a);
        //testShell(a);//30
        //testInsert(a);30230
        //testMerge(a);//80
        testQuick(a);
    }

    /**
     * 测试快速排序
     * @param a
     */
    public static void testQuick(Comparable [] a){
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("快速排序所花费的时间为"+(end-start)+"毫秒");
    }

    /**
     * 测试归并排序
     * @param a
     */
    public static void testMerge(Comparable[] a){
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("归并排序所花费的时间为"+(end-start)+"毫秒");
    }

    /**
     * 测试希尔排序
     * @param a
     */
    public static void testShell(Comparable[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序所花费的时间为"+(end-start)+"毫秒");

    }

    /**
     * 测试插入排序
     * @param a
     */
    public static void testInsert(Comparable[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("插入排序所花费的时间为"+(end-start)+"毫秒");

    }

    /**
     * 编写测试数据
     * @throws IOException
     */
    public static void writerFile() throws IOException {
        OutputStream outputStream = new FileOutputStream("./test.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        String content="";
        for(Integer i=1000000;i>=0;i--){
            content+=i.toString()+"\n";
        }
        bufferedOutputStream.write(content.getBytes(),0,content.getBytes().length);
    }
}
