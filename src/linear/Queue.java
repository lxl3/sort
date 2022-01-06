package linear;

import java.util.Iterator;

public class Queue<T> implements Iterable{
    private Node head;
    private Node last;
    private int N;



    private class Node{
        private Node next;
        private T item;
        public Node(Node next,T item){
            this.next=next;
            this.item=item;
        }
    }
    public Queue(){
        this.head=new Node(null,null);
        this.last=null;
        this.N=0;
    }
    public boolean IsEmpty(){
        return N==0;
    }
    public int getLength(){
        return N;
    }
    public void push(T t){
        //判断尾节点是否为空
        if(last==null){
            //如果为空，创建新节点即为为节点
          last= new Node(null,t);
          head.next=last;
        }else{
            //临时节点
            Node oldNode=last;
            //创建新节点
            last=new Node(null,t);
            oldNode.next=last;
        }
        this.N++;
    }
    public T pop(){
        if(IsEmpty()){
            return null;
        }
        Node oldfirst=head.next;
        head.next=oldfirst.next;
        N--;
        //如果删完了让last为null
        if(IsEmpty()){
            last=null;
        }
        return oldfirst.item;
    }
    @Override
    public Iterator iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node node;
        public SIterator(){
            this.node=head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public Object next() {
            node=node.next;
            return node.item;
        }
    }
}
