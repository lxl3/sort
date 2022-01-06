package Simbal;

/**
 * 有序符号表
 * @param <Key>
 * @param <Value>
 */
public class OrderSimbalTable<Key extends Comparable<Key>, Value>{
    private Node head;
    private int N;


    private class Node{
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    public OrderSimbalTable(){
        this.head=new Node(null,null,null);
        this.N=0;
    }
    //获取字符表中元素的个数
    public int getLenth(){
        return this.N;
    }
    //判断是否为空
    public boolean IsEmpty(){
        return this.N==0;
    }
    //插入元素
    public void add(Key key,Value value){
        Node cur=head.next;
        Node pre=head;
        while (cur!=null &&(cur.key.compareTo(key))<0){
            //变化当前节点和前一个节点
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null && cur.key.compareTo(key)==0){
            cur.value=value;
            return;
        }
        Node newNode=new Node(key,value,cur);
        pre.next=newNode;
        this.N++;
    }

    //删除键为key的value
    public void delete(Key key){
        Node n=head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                this.N--;
                return ;
            }
            n=n.next;
        }
    }
    //从符号表中获取key对应的值
    public Value getValue(Key key){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                return n.value;
            }
        }
        return null;

    }
}
