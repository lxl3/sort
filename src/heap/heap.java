package heap;

public class heap<T extends Comparable<T>> {
    private T[] item;
    private int N;
    public heap(int capcity){
        this.N=0;
        this.item=(T[])new Comparable[capcity+1];
    }
    public boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }
    public void exec(int i,int j){
        T temp= item[i];
        item[i]=item[j];
        item[j]=temp;
    }
    public int size(){
        return this.N;
    }
    public void insert(T k){
        item[++N]=k;
        swim(N);

    }
    public void swim(int k){
        while (k>1){
            //判断当前元素和父元素的大小
            if(less(k/2,k)){
                //如果父元素比他小，交换位置
                exec(k/2,k);
            }
            k=k/2;
        }
    }
    //删除堆中最大的元素，并返回其值
    public T delete(){
        T max = item[1];
        //交换最大值和最大索引处的值
        exec(1,N);
        //删除最大值
        item[N]=null;
        //个数-1
        N--;
        //采用下沉算法让数组重新有序
        sink(1);
        return max;
    }
    public void  sink(int k){
        while (2*k<=N){
            int max;//记录最大索引
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
           return;
       }
       exec(k,max);
       k=max;
       }

    }
}
