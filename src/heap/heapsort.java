package heap;


public class heapsort {
    public static boolean less(Comparable[] heap ,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    public static void exch(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public static void Creatheap(Comparable[] source,Comparable []target){
        System.arraycopy(source,0,target,1,source.length);
        for(int i=(target.length)/2;i>0;i--){
            sink(target,i,target.length-1);
        }
    }
    //排序
    public static void sort(Comparable []source){
        //构建堆
      Comparable[] target= new Comparable[source.length+1];
      //定义一个变量记录未排序的队中索引最大的值
      Creatheap(source,target);
      int N=target.length-1;
      //通过循环交换1所在位置和最大索引所在位置的值
      while (N!=1){
          //交换元素
          exch(target,1,N);
          //去除最大索引处的值，不让其继续参与交换
          N--;
          //将1位置处的元素做下沉操作
          sink(target,1,N);
      }
      //将排序好的元素复制到原数组中
        System.arraycopy(target,1,source,0,source.length);

    }
    //下沉算法
    public static void sink(Comparable []heap,int target,int range){
        while (2*target<=range){
            int max;
            //找到子节点中较大的值
            if(2*target+1<=range){
                if(less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }else{
                    max=2*target;
                }
            }else{
                //如果没有右子节点
                max=2*target;
            }//如果target比较大值还大，不用交换
            if(!less(heap,target,max)){
                break;
            }
            //和较大值交换位置
            exch(heap,target,max);

            target=max;
        }
    }
}
