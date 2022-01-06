package sort;

/**
 * 插入排序
 * 具有稳定性
 */
public class Insertion {
//    public static void sort(Comparable[] a){
//        for(int i=1;i<a.length;i++){
//            for(int j=i;j>0;j--){
//                if(greater(a[j-1],a[j])){
//                    exec(a,j-1,j);
//                }else{
//                    break;
//                }
//            }
//
//        }
//
//    }
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(greater(a[j-1],a[j])){
                    exec(a,j-1,j);
                }else{
                    break;
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
