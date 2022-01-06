package tree;


import linear.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int N = 0;

    //    public BinaryTree(){
//        this.root=new Node(null,null,null,null);
//        this.N=0;
//    }
    private class Node {
        private Node left;
        private Node right;
        private Key key;
        private Value value;

        public Node(Node left, Node right, Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //向树中添加元素key value
    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        //如果x节点为空
        if (x == null) {
            N++;
            return new Node(null, null, key, value);
        }
        //如果x节点不为空，判断当前节点和key的大小
        int i = x.key.compareTo(key);
//        System.out.println(i);
        if (i < 0) {
            //如果i>0 继续找x节点的右子树
            x.right = put(x.right, key, value);
        } else if (i > 0) {
            //如果i<0 继续找x节点的左子树
            x.left = put(x.left, key, value);
        } else {
            //如果相等就替换
            x.value = value;
        }
        return x;
    }

    //找到指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        while (x != null) {
            int i = key.compareTo(root.key);
            if (i < 0) {
                //继续往右找
                return get(x.right, key);
            } else if (i > 0) {
                return get(x.left, key);
            } else {
                return x.value;
            }
        }
        return null;

    }

    //删除树中key对应的value
    public void delete(Key key) {
      delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int i = key.compareTo(x.key);
        if (i > 0) {
            x.right = delete(x.right, key);
        } else if (i < 0) {
            x.left = delete(x.left, key);
        } else {
            //节点数量-1
            N--;
            //找到真正要删除的节点 x节点 执行真正的删除动作
            if (x.left == null) {
                //如果此节点没有左子树
                return x.right;
            }
            if (x.right == null) {
                //如果此节点没有右子树
                return x.left;
            }
            //找到此节点右子树中最小的节点作为当前节点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //删除右子树中的最小节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                }
                n = n.left;
            }
            //让最小节点的左子树成为当前节点的左子树
            minNode.left = x.left;
            //让最小节点的右子树成为当前节点的右子树
            minNode.right = x.right;
            //让当前节点的前一个节点的左子树指向此节点
            x = minNode;
        }
        return x;
    }

    public int getNum() {
        return this.N;
    }
    //查找整个树中最小的键
    public Key min() {
        return min(root).key;
    }
    //查找指定节点最小的键
    public Node min(Node x) {
        if (x.left != null) {
            return  min(x.left);
        } else {
            return x;
        }
    }
    //查找最大的键
    public Key max(){
        return max(root).key;
    }
    //查找指定节点最大的键
    public Node max(Node x){
        if(x.right!=null){
            return max(x.right);
        }else{
            return x;
        }
    }
    //整个树中所有的键
    public Queue<Key> pre(){
       Queue<Key> keys=new Queue<>();
       pre(root,keys);
       return keys;

    }
    //获取指定节点的键
    private void pre(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        keys.push(x.key);
        if(x.left!=null){
            pre(x.left,keys);
        }
        if(x.right!=null){
            pre(x.right,keys);
        }
    }
    public Queue<Key> mid(){
        Queue<Key> keys=new Queue<>();
        mid(root,keys);
        return keys;

    }
    public void mid(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        if(x.left!=null){
            mid(x.left,keys);
        }
        keys.push(x.key);
        if(x.right!=null){
            mid(x.right,keys);
        }
    }
    public Queue<Key> head(){
        Queue<Key> keys=new Queue<>();
        head(root,keys);
        return keys;

    }
    public void head(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }

        if(x.left!=null){
            head(x.left,keys);
        }
        if(x.right!=null){
            head(x.right,keys);
        }
        keys.push(x.key);
    }
    /**
     * 层序遍历
     */
    public Queue<Key> layer(){
        //创建两个队列，一个存放节点，一个存放key
        Queue<Node> nodes=new Queue<>();
        Queue<Key> keys=new Queue<>();
        //先将根节点放入队列中
        nodes.push(root);
        while(!nodes.IsEmpty()){
            //如果节点不为空，弹出当前节点，并将其key存入队列
            Node n = nodes.pop();
            keys.push(n.key);
            //判断当前节点是否还有左子树
            if(n.left!=null){
                //如果有将当前节点存入节点队列
                nodes.push(n.left);
            }
            //判断当前节点是否还有右子树
            if(n.right!=null){
                nodes.push(n.right);
            }
        }
        return keys;
    }
    public int maxdepth(){
        return maxdepth(root);
    }
    private  int maxdepth(Node n){
        int leftdepth=0;
        int rightdepth=0;
        if(n==null){
            return 0;
        }
        if(n.left!=null){
           leftdepth= maxdepth(n.left);
        }
        if (n.right!=null){
           rightdepth= maxdepth(n.right);
        }
        return leftdepth>rightdepth ? leftdepth+1 : rightdepth+1;
    }
}
