package test;

import sort.Student;

public class test {
    public static void main(String[] args) {
        Student stu1 = new Student("小红", 24);
        Student stu2 = new Student("李磊", 23);
        Comparable sort = sort(stu1, stu2);
        System.out.println(sort);

    }
    public static Comparable sort(Comparable c1,Comparable c2){
        int i = c1.compareTo(c2);
        if(i>=0){
            return c1;
        }else{
            return c2;
        }
    }
}
