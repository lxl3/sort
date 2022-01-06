package linear;

import java.util.Iterator;

public class Stack<T>implements Iterable {
    private Node head;//头节点
    private  int N;//元素个数

    private class Node{
        private T item;
        private Node next;
        public Node(T item,Node next){
            this.next=next;
            this.item=item;
        }
    }
    public Stack(){
        this.N=0;
        this.head=new Node(null,null);
    }
    public  boolean IsEmpty(){
        return N==0;
    }
    public  int getlength(){
        return this.N;
    }
    public void push(T t){
        //找到首节点的下一个节点
        Node oldNode=head.next;
        //创建新节点
        Node newNode= new Node(t,null);
        //让老节点指向新节点
        head.next=newNode;
        //让新节点指向前一个节点
        newNode.next=oldNode;
        this.N++;

    }
    public T pop(){
        if(IsEmpty()){
            return null;
        }
        Node oldNode=head.next;
        if(oldNode==null){
            return null;
        }
        head.next=oldNode.next;
        this.N--;
        return oldNode.item;
    }
    @Override
    public Iterator iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node n;
        SIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
