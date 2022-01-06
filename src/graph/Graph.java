package graph;

import linear.Queue;

public class Graph {
    private final int V;//记录顶点数量
    private int E;//记录边数量
    private Queue<Integer>[] adj;//邻接表
    public Graph(int v){
        this.E=0;
        this.V=v;
        this.adj=new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<>();
        }
    }
    //获取顶点个数
    public int getV(){
        return this.V;
    }
    //获取边的个数
    public int getE(){
        return this.E;
    }
    //向图中添加一条边v-w
    public void addedge(int v,int w){
        adj[v].push(w);
        adj[w].push(v);
        E++;
    }
    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
