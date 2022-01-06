package graph;



/**
 * 深度优先搜索
 */
public class DepthFirstSerch {
    public boolean[] market;//索引代表顶点，值表示当前顶点是否已经被搜索
    private int count;//计算有多少个顶点与顶点相通
    //检验深度优先对象，使用深度有限找出graph图中所有与s相邻的顶点
    public DepthFirstSerch(Graph graph,int s){
        this.market=new boolean[graph.getV()];
        this.count=0;
        dfs(graph,s);

    }
    //使用深度优先算法找出graph图中，所有与s相通的顶点
    private void dfs(Graph graph, int s) {
        market[s]=true;
        for (Object o : graph.adj(s)) {
            if(!market[(int) o]){
                dfs(graph, (Integer) o);
            }
        }
        count++;
    }
    //判断w顶点是否被搜索过
    public boolean maked(int w){
        //把w顶点标记为已搜索
        return market[w];
    }
    //得到数量
    public int getCount(){
        return count;
    }
}
