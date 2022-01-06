package sort;

/**
 * 希尔排序 不稳定
 */
public class Shell {
    public static void sort(Comparable[] a){
        //确定增长量
        int h=1;
        while(h<a.length/2){
            h=h*2+1;
        }
        while (h>=1){
            //找到待插入的元素
            for(int i=h;i<a.length;i++){
                //将元素插入到有序数组中
                for(int j=i;j>=h;j-=h){
                    if(greater(a[j-h],a[j])){
                        exec(a,j-h,j);
                    }else{
                        break;
                    }
                }
            }
            h=h/2;
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
