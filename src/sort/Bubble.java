package sort;

/**
 * 冒泡排序
 * 具有稳定性
 */

public class Bubble {
    public static void sort(Comparable[] a){
//        for(int i=0;i<a.length-1;i++){
//            for(int j=0;j<a.length-1-i;j++){
//                if(greater(a[j],a[j+1])){
//                    exec(a,j,j+1);
//                }
//            }
//        }
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(greater(a[j],a[j+1])){
                    exec(a,j,j+1);
                }
            }
        }
    }
    public static boolean greater(Comparable a,Comparable b){
            return a.compareTo(b)>0;
    }
    private static void  exec(Comparable a[],int b,int c){
       Comparable temp;
       temp=a[b];
       a[b]=a[c];
       a[c]=temp;
    }
}
