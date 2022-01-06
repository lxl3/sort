package Simbal;

public class SimbalTable<Key,Value> {
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
    public SimbalTable(){
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
        //判断是否存在key
        Node n=head;
        while (n.next!=null){
            n=n.next;
           if(key.equals(n.key)){
               //存在,修改该值
               n.value=value;
               return;
           }
        }
        //不存在，添加新键
        Node newNode = new Node(key, value, null);
//        Node oldfirst=head.next;
        newNode.next=head.next;
        head.next=newNode;
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
