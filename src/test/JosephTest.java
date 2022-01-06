package test;

/**
 * 解决约瑟夫环问题
 */
public class JosephTest {
    public static void main(String[] args) {
        Node<Integer> first=null;
        Node<Integer> pre=null;
        //生成41个节点
        for(int i=1;i<=41;i++){
            //判断是否是第一个节点
            if(i==1){
                //如果是第一个节点
                first = new Node<>(i, null);
                pre=first;
                continue;
            }else{
                //如果不是第一个节点
                Node<Integer> newNode = new Node<>(i, null);
                pre.next=newNode;
                pre=newNode;
            }
            if(i==41){
                //如果是最后一个节点
                pre.next=first;
            }
        }
        //2,需要定义count模拟报数
        int count=0;
        //遍历循环链表
        Node<Integer> n=first;
        Node<Integer> before=null;
        while (n!=n.next){
            count++;
            //判断报的数是否为三
            if(count==3){
                //如果是3,则删除当前节点，打印节点信息，count置0，并且节点后移
                before.next=n.next;
                System.out.print(n.ele+",");
                count=0;
                n=n.next;
            }else{
                //如果不是3，节点后移
                before=n;
                n=n.next;
                continue;
            }
        }
        //打印最后一个元素
        System.out.println(n.ele);

    }


    private static class Node<T>{
        private Node next;
        private T ele;
        public Node(T ele, Node next){
            this.next=next;
            this.ele=ele;
        }
    }
}
