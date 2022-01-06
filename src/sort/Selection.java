package sort;

/**
 * 选择排序 不稳定
 */
public class Selection {
//    public static void sort(Comparable[] a){
//        for(int i=0;i<a.length-1;i++){
//            int minIndex=i;
//            for(int j=i+1;j<a.length;j++){
//                if(greater(a[minIndex],a[j])){
//                    minIndex=j;
//                }
//            }
//            exec(a,i,minIndex);
//        }
//    }
    public static void sort(Comparable[] a){
        for(int i=0;i<a.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            exec(a,i,minIndex);
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
