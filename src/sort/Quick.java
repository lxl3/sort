package sort;

/**
 * 快速排序 不稳定
 */
public class Quick {
    /**
     * 对数组排序
     * @param a
     */
    public static void sort(Comparable [] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);

    }

    /**
     * 对数组中从lo,到hi位置的元素排序
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable [] a ,int lo, int hi){
        //安全性检验
        if(lo>=hi){
            return;
        }
        //找到临界位置
        int partition = partition(a, lo, hi);
        //将左边的数据排序
        sort(a,0,partition-1);
        //将右边的数据排序
        sort(a,partition+1,hi);

    }

    /**
     * 将数组中索引lo到hi处元素分组，并返回分组后临界处的索引值
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable []a,int lo,int hi){
        //确定分界值
        Comparable key=a[lo];
        //定义两个指针
        int left=lo;
        int right=hi+1;
        //切分
        while(true){
            //从右往左找比分界值小的元素
            while (less(key,a[--right])) {
                //如果没找到退出循环
                if (right == lo) {
                    break;
                }
            }
            //从左往右找比分界值大的元素
            while (less(a[++left],key)){
                //如果没找到，退出循环
                if(left==hi){
                    break;
                }
            }
            //判断left>=right，如果是，结束循环
            if(left>=right){
                break;
            }else{
                exec(a,left,right);
            }
        }
        //交换分界值
        exec(a,lo,right);
        return right;
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
