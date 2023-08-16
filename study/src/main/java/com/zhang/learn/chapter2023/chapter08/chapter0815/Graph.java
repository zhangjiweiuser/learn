package com.zhang.learn.chapter2023.chapter08.chapter0815;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 步骤：
 * 1. 访问初始结点v，并标记结点v为已访问
 * 2。 查找结点v的第一个邻接结点w
 * 3. 如果w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续
 * 4. 如果w未被访问，对w进行深度优先遍历递归（即把w当作另外一个v，然后进行步骤123）
 * 5. 查找结点v的w邻接结点的下一个邻接结点，转到步骤3
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-15 16:01
 */
public class Graph {
    private List<String> vertexList; // 存放顶点集合
    private int[][] edges; // 存储图对应的邻接矩阵
    private int numOfEdges; // 表示边的数目

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        Graph graph = new Graph(n);
        String[] vertexList = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexList) {
            graph.insertVertex(vertex);
        }
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.show();

//        graph.dfs();
        graph.bfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    public void dfs(int i) {
        System.out.print(getValueByIndex(i) + "->");
        // 将该结点设置为已访问
        isVisited[i] = true;
        // 查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(w);
            }
            // 如果已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }
    }

    // 对一个结点，进行广度优先遍历的方法
    public void bfs(int i) {
        int u; // 表示队列对应的头结点下标
        int w; // 邻接结点w
        // 队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        // 将其标记为已访问
        isVisited[i] = true;
        // 将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            // 取出队列的头结点下标
            u = (int) queue.removeFirst();
            // 得到第一个邻接点下标
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    // 入队列
                    queue.addLast(w);
                }
                // 查找u所在行的，w的下一个邻接结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }
    }

    /**
     * @param i
     * @return 得到第一个邻接结点的下标，存在则返回下标，不存在返回-1
     */
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * @return 根据前一个邻接结点的下标，获取下一个邻接结点
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    // 返回结点的个数
    public int getNumberOfVertex() {
        return vertexList.size();
    }

    // 返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    // 返回结点i(下标) 对应的数据，0->A,1->B
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 返回v1到v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 显示
    public void show() {
        for (int[] val : edges) {
            System.out.println(Arrays.toString(val));
        }
    }

    // 插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1     表示点的下标，即第几个顶点，A-B,A->0,B->1
     * @param v2     第二哥顶点对应的下标
     * @param weight 是否连通
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
