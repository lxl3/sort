package linear;

import java.util.Iterator;

public class TwowayLinklist<T> implements Iterable {
    public Node first;//头节点
    public Node last;//尾节点
    public int N;

    private class SIterator implements Iterator{
        private Node n;
        public SIterator(){
            this.n=first;
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
    @Override
    public Iterator iterator() {
        return new SIterator();

    }

    private class Node{
        public T item;
        public Node pre;
        public Node next;
        public Node(Node pre,T item,Node next){
            this.pre=pre;
            this.item=item;
            this.next=next;
        }
    }
    public TwowayLinklist(){
        this.N=0;
        this.first=new Node(null,null,null);
        this.last=new Node(null,null,null);
    }
    public void clear(){
        this.first.next=null;
        this.first.pre=null;
        this.first.next=null;
        this.last=null;
        this.N=0;
    }
    public int getlength(){
        return this.N;
    }
    public boolean IsEmpty(){
        return this.N==0;
    }
    public T getFirst(){
        if(IsEmpty()){
            return null;
        }else{
            return first.next.item;
        }
    }
    public T getLast(){
        if(IsEmpty()){
            return null;
        }else {
            return last.item;
        }
    }
    //获取指定位置元素
    public T getItem(int i){
        Node node=first.next;
        for(int index=0;index<i;index++){
            node=node.next;
        }
        return node.item;
    }
    //添加元素
    public void add(T t){
        //判断是否为空
        if(IsEmpty()){
            //创建新节点
            Node newNode = new Node(first, t, null);
            //让新节点成为尾节点
            last=newNode;
            //让头节点指向新节点
            first.next=last;
        }else{
            Node oldnode=last;
            //创建新节点
            Node newNode = new Node(oldnode, t, null);
            //让尾节点指向新节点
            oldnode.next=newNode;
            //让新节点成为为节点
            last=newNode;
        }
        //元素个数加一
        this.N++;
    }
    //向指定位置插入元素
    public void insert(int i,T t){
        Node node=first;
        //找到前一个节点
        for(int index=0;index<i;index++){
            node=node.next;
        }
        //找到当前节点
        Node cur=node.next;
        //创建新节点
        Node newNode = new Node(node, t, cur);
        //让新节点的下一个元素指向当前节点
        newNode.next=cur;
        //让前一个节点的指向新节点
        node.next=newNode;
        this.N++;
    }
    //查找指定元素第一次出现的位置
    public int indexof(T t){
        Node node=first;
        for(int index=0;node.next!=null;index++){
            node=node.next;
            if(node.item.equals(t)){
                return index;
            }
        }
        return -1;
    }
    //删除指定位置的元素
    public T remove(int i){
        Node node=first;
        //找到前一个节点
        for(int index=0;index<i;index++){
            node=node.next;
        }
        //找到当前节点
        Node cur= node.next;
        //找到后一个节点
        Node h= cur.next;
        //让前一个节点指向后一节点
        node.next=h;
        h.pre=node;
        //长度-1
        this.N--;
        return cur.item;
    }
}
