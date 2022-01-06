package linear;

import java.util.Iterator;

public class SequenceList <T> implements Iterable<T>{
    private int N;//记录元素个数
    private T [] eles;
    public SequenceList(int length){
        this.eles= (T[])new Object[length];
        this.N=0;
    }
    //将一个线性表置为空表
    public void clear(){
        this.N=0;
    }
    //判断当前线性表是否为空表
    public boolean isEmpty(){
        if(this.N==0){
            return true;
        }else{
            return false;
        }
    }
    //获取线性表元素的个数
    public int get(){
        return this.N;
    }
    //获取线性表的长度
    public int getLength(){
        return eles.length;
    }
    //获取指定位置的元素
    public T getEle(int index){
        return eles[index];
    }
    //向线性表中插入元素
    public void add(T t){
        if(N==eles.length){
            resize(eles.length*2);
        }
        eles[N++]=t;
    }
    //向线性表指定位置插入元素
    public void insert(int i,T t){
        if(N==eles.length){
            resize(eles.length*2);
        }
//        先将index索引及其后面的元素后移
//           for(int index=i+1;index<=N;index++){
//               eles[index]=eles[index-1];
//           }
        for(int index=N;index>i;index--){
            eles[index]=eles[index-1];
        }
        eles[i]=t;
        this.N++;
    }
    //删除指定索引处的元素 并将其返回
    public T delete(int index){
        T current=eles[index];
        for(int i=index;i<N-1;i++){
            eles[index]=eles[index+1];
        }
        this.N--;
        if(eles.length<=N/4){
            resize(eles.length/2);
        }
        return current;
    }
    //查找T元素第一次出现的位置
    public int getfirst(T t){
        for(int i=0;i<N;i++){
            if(t.equals(eles[i])){
                return i;
            }
        }
        return -1;
    }
    public void resize(int newSize){
        //定义临时数组
        T [] temp=eles;
        //初始化临时数组
        eles=(T[])new Object[newSize];
        //拷贝原数组
        for(int i=0;i<N;i++){
            eles[i]=temp[i];
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new SIterotor();
    }

    private class SIterotor implements Iterator{
        private int cusor;
        SIterotor(){
            this.cusor=0;
        }

        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

}
