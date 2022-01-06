package priority;


public class Minprioripty<T extends Comparable<T>> {
    private T [] item;
    private int N;
    public Minprioripty(int capacity){
        this.item=(T[])new Comparable[capacity+1];
        this.N=0;
    }
    public boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }
    public void exec(int i,int j){
        T tmp= item[i];
        item[i]=item[j];
        item[j]=tmp;
    }
    public int size(){
        return this.N;
    }
    public boolean isEmpty(){
        return this.N==0;
    }
    public void insert(T t){
        item[++N]=t;
        swim(N);

    }
    public void swim(int k){
        while (k>1){
            if(less(k,k/2)){
                exec(k,k/2);
            }
            k=k/2;
        }
    }
    public T deleteMin(){
        T min=item[1];
        exec(1,N);
//        item[N]=null;
        N--;
        sink(1);
        return min;
    }
    public void sink(int k){
        while (2*k<=N){
            int min;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    min=2*k;
                }else{
                    min=2*k+1;
                }
            }else{
                min=2*k;
            }
            if(less(k,min)){
                break;
            }
            exec(k,min);
            k=min;
        }
    }

}
