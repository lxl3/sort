package linear;

import java.util.Iterator;

public class Linklist<T> implements Iterable {
    public Node node;
    public int N;
    private class LIterator implements Iterator{
        public Node n;
        public LIterator(){
            this.n=node;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.ele;
        }
    }
    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class Node{
        private Node next;
        private T ele;
        public Node(T ele,Node next){
            this.next=next;
            this.ele=ele;
        }
    }
    //初始化
    public Linklist(){
        node= new Node(null,null);
        this.N=0;
    }
    //清空链表
    public void clear(){
        node.next=null;
        this.N=0;
    }
    //获取链表的长度
    public int getNum(){
        return this.N;
    }
    //判断链表是否为空
    public boolean IsEmpty(){
        return this.N==0;
    }
    //获取指定位置的元素
    public T getNode(int i){
        Node h = node.next;
        for(int index=0;index<i;index++){
            h=h.next;
        }
        return h.ele;
    }
    //插入方法
    public void add(T n){
        Node h=node;
        while (h.next!=null){
            h=h.next;
        }
        Node node = new Node(n, null);
        h.next=node;
    }
    //向指定位置插入元素
    public void insert(int i,T t){
        Node pre=node;
        //找到前一个节点
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到当前节点
        Node cur=pre.next;
        //创建新节点
        Node node = new Node(t, cur);
        pre.next=node;

        this.N++;
    }
    //删除指定位置的元素,并返回
    public T remove(int i){
         Node pre=node;
        //找到当前节点的前一个节点
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到当前节点
        Node cur=pre.next;
        //找到当前节点的后一个节点
        Node h=cur.next;
        //让前一个节点只想当前节点的下一个节点
        pre.next=h;
        this.N--;
        return cur.ele;
    }
    //找到指定元素的索引
    public int getIndex(T t){
        Node pre=node;
        //找到当前元素
        for(int index=0;pre.next!=null;index++){
            pre=pre.next;
            if(pre.ele.equals(t)){
                return index;
            }
        }
        return -1;
    }
    //链表的反转
    public void reverse(){
        if(IsEmpty()){
            return;
        }
        reverse(node.next);
    }
    //反转当前节点
    public Node reverse(Node cur){
        //判断是否是最后一个元素
        if(cur.next==null){
            node.next=cur;
            return cur;
        }
        //递归翻转当前节点的下一个节点
        Node h = reverse(cur.next);
        //让返回的下一个节点指向当前元素
        h.next=cur;
        //将当前元素的下一个节点置空（最后一个人元素）
        cur.next=null;
        return cur;
    }


}
