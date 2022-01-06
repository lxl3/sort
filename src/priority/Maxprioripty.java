package priority;


/**
 * 最大优先队列
 */
public class Maxprioripty <T extends Comparable<T>>{
    private  T[] item;
    private int N;
    public Maxprioripty(int capticity){
        this.item=(T[])new Comparable[capticity+1];
        this.N=0;
    }
    //判断是否为空
    public  boolean isEmpty(){
        return this.N==0;
    }
    //获取个数
    public int size(){
        return N;
    }
    //交换指定索引处的元素
    public  void exch(int i,int j){
        T tmp=item[i];
        item[i]=item[j];
        item[j]= tmp;
    }
    //比较大小
    public  boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }
    //插入一个元素
    public void insert(T t){
        item[++N]=t;
        //进行上浮算法
        swim(N);

    }
    //删除最大元素
    public T deleteMax(){
        T max=item[1];
        //交换位置
        exch(1,N);
        //删除最大值
        item[N]=null;
        N--;
        //采用下沉算法是堆重新有序
        sink(1);
        return max;

    }
    //上浮算法
    public void swim(int k){
        while (k>1){
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }
    }
    //下沉算法
    public void sink(int k){
        while (2*k<=N){
            int max;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    max=2*k+1;
                }else{
                    max=2*k;
                }
            }else{
                max=2*k;
            }
            if(!less(k,max)){
                break;
            }
            exch(k,max);
            k=max;
        }
    }


}
