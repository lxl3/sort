package test;

import linear.Queue;

/**
 * 用树解决折纸问题
 */
public class TestPaper {
    public static void main(String[] args) {
        Node<String> node = creatTree(2);
        print(node);

    }

    /**
     * 模拟折纸。产生树
     * @param N 折纸次数
     * @return
     */
    public static Node<String> creatTree(int N){
        Node<String> root=null;
        for(int i=0;i<N;i++){
            if(i==0){
                //第一次折纸
                root = new Node<>("down", null, null);
                continue;
            }else{
                //不是第一次折纸 创建一个辅助队列，通过层次遍历的思路，找到叶子节点，添加新节点
                Queue<Node> queue = new Queue<>();
                queue.push(root);
                while (!queue.IsEmpty()){
                    //弹出一个节点
                    Node n = queue.pop();
                    if(n.left!=null){
                        queue.push(n.left);
                    }
                    if(n.right!=null){
                        queue.push(n.right);
                    }
                    if(n.left==null && n.right==null){
                        //创建新节点
                        n.left=new Node<String>("down",null,null);
                        n.right=new Node<String>("up",null,null);
                    }
                }
//                new Queue<>()
            }
        }
        return root;
    }

    /**
     * 中序遍历节点
     * @param root
     */
    public static void print(Node<String> root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            print(root.left);
        }
        System.out.print(root.item+",");
        if(root.right!=null){
            print(root.right);
        }
    }
    private static class Node<T>{
         private T item;
         private Node left;
         private Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
