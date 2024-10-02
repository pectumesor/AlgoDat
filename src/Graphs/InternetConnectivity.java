package Graphs;
import java.util.Arrays;
import java.util.ArrayList;
/*
*  Data Structure that represents connected components of a graph. Helps to greatly increase the runtime of
* Kruskal Algorithm to pick Edges with the lowest weight and merging connected components and to quickly skip adding an edge
* that could create a cycle in our graph.
* */
class UnionFind {
    int[] labels;
    int[] size;


    public UnionFind(int n){
        size = new int[n];
        create(n);
    }

    void create (int n){
        labels = new int [n];
        for (int i = 0 ; i<n;i++){
            labels[i] = i;
            size[i] = 1;
        }
    }

    int find (int x){
        int root = x;

        while(root !=labels[root]){
            root = labels[root];
        }

        while (x != root){
            int parent = labels[x];
            labels[x] = root;
            x = parent;
        }
        return root;
    }

    boolean connected(int x, int y){
        return find(x) == find(y);
    }

    int componentSize(int p){
        return size[find(p)];
    }

    void union (int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty){
            return;
        }
        if (size[rootx] < size[rooty]){
            size[rooty] += size[rootx];
            labels[rootx] = labels[rooty];
        } else {
            size[rootx] += size[rooty];
            labels[rooty] = labels[rootx];
        }
    }
}

/*
*  Helper Class to wrap our edges and being able to use Java in-built sorting algorithm, which is CompareTo method,
*  to compare elements.
* */
class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost){

        this.from = from;
        this.to = to;
        this.cost = cost;

    }
    @Override public int compareTo(Edge rhs) {
        if (this.cost < rhs.cost){
            return -1;
        } else if (this.cost > rhs.cost){
            return 1;
        } else {
            return 0;
        }
    }

}


public class InternetConnectivity {


    public static int getCost(int n, int m, int[] edge1, int[] edge2, int[] vertexCost, int[] edgeCost) {
        // TODO: implement

        int res  = 0;

        Edge[] edges = new Edge[m+n];
        ArrayList<Edge> kruskal = new ArrayList<>();


        for (int i = 0; i<m;i++){
            edges[i] =  new Edge(edge1[i],edge2[i],edgeCost[i]);
        }

        for (int i = 0; i<n;i++){
            edges[i+m] =  new Edge (i,n,vertexCost[i]);
        }

        Arrays.sort(edges);
        UnionFind pq = new UnionFind(n+1);

        for (int i = 0 ; i<edges.length;i++){
            if (!pq.connected(edges[i].from,edges[i].to)){
                pq.union(edges[i].from,edges[i].to);
                kruskal.add(edges[i]);
            }

        }

        for (int i = 0; i<kruskal.size();i++){
            res += kruskal.get(i).cost;
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 4;
        int m = 4;

        int[] vertexCost = {2,2,2,2};
        int[] edge1 = {0,1,2,3};
        int[] edge2 = {1,2,3,0};
        int[] edgeCost = {1,3,1,3};

        int minCost = getCost(n, m, edge1, edge2, edgeCost, vertexCost);

        assert minCost == 6 : "The MST cost should be 6, but it is " + minCost;
        System.out.println("The MST cost is " + minCost);
    }
}
