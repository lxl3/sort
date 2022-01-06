package sort;
/**
 * 归并排序 稳定
 */


public class Merge {
    //定义辅助数组
    private static Comparable [] assit;
    /**
     * 对数组a中的元素排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //为辅助数组初始化
        assit = new Comparable[a.length];
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    /**
     * 对数组中从lo到hi的元素排序
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a,int lo,int hi){
            if(hi<=lo){
                return;
            }
            int mid=lo+(hi-lo)/2;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);

    }

    /**
     * 将数组中lo到mid mid+1到hi这两组进行归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针
        int p=lo;
        int p1=lo;
        int p2=mid+1;
        //遍历，移动指针p1和p2，比较对应索引处值的大小。找出小的那个，放到辅助数组对应的位置
        while(p1<=mid && p2<=hi){
            if(less(a[p1],a[p2])){
                assit[p++]=a[p1++];
            }else{
                assit[p++]=a[p2++];
            }
        }
        //遍历，如果p1的指针没有走完，将剩余的元素放到辅助数组队对应的位置
        while(p1<=mid){
            assit[p++]=a[p1++];
        }
        //遍历，如果p2的指针没有走完，将剩余的元素放到辅助数组队对应的位置
        while(p2<=hi){
            assit[p++]=a[p2++];
        }
        //将辅助数组中的元素拷贝到元数组中
        for(int index=lo;index<=hi;index++){
            a[index]=assit[index];
//            System.out.println(assit[index]);
        }

    }
    /**
     * 判断大小
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    /**
     * 交换数据
     * @param a
     * @param i
     * @param j
     */
    public static void exec(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
