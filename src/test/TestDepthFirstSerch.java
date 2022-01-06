package test;

import graph.DepthFirstSerch;
import graph.Graph;

public class TestDepthFirstSerch {
    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addedge(0,5);
        graph.addedge(0,1);
        graph.addedge(0,2);
        graph.addedge(0,6);
        graph.addedge(5,3);
        graph.addedge(5,4);
        graph.addedge(3,4);
        graph.addedge(4,6);

        graph.addedge(7,8);

        graph.addedge(9,11);
        graph.addedge(9,10);
        graph.addedge(9,12);
        graph.addedge(11,12);

        DepthFirstSerch serch = new DepthFirstSerch(graph, 0);
        int count = serch.getCount();
        System.out.println("与顶点0相通的点的个数有"+count+"个");
        boolean maked1 = serch.maked(5);
        System.out.println("顶点5与0是否相通"+maked1);
        boolean maked = serch.maked(7);
        System.out.println("顶点7是否与0相通"+maked);
    }
}
