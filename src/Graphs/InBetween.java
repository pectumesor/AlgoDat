package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;

public class InBetween{

    public static int countInBetween(int n, ArrayList<ArrayList<Integer>> G, ArrayList<ArrayList<Integer>> Grev, int x, int y) {
        // TODO: Implement

        int res = 0;
        boolean[] reachX = new boolean[n];
        boolean[] reachY = new boolean[n];
        DFS(G,x,reachX);
        DFS(Grev,y,reachY);

        for (int i = 0; i<n;i++){
            if (reachX[i] == true && reachY[i] == true){
                res++;
            }
        }

        return res;
    }

    /*
    *  Iterative DFS
    * */

    public static void DFS(ArrayList<ArrayList<Integer>> g, int src, boolean[] visited){

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(src);

        while (!stack.isEmpty()){
            int w = stack.pop();
            visited[w] = true;

            for (int i = 0; i<g.get(w).size();i++){
                int x = g.get(w).get(i);
                if (visited[x] != true){
                    stack.push(x);
                }
            }
        }
    }


    public static void main(String[] args) {

        int nodes = 8;
        int edges = 10;
        int x = 7;
        int y = 6;
        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> Grev = new ArrayList<ArrayList<Integer>>();


        for (int i = 0; i < nodes; i++) {
            G.add(new ArrayList<Integer>());
            Grev.add(new ArrayList<Integer>());
        }

        //Insert Edges
        G.get(0).add(3); Grev.get(3).add(0);
        G.get(1).add(0); Grev.get(0).add(1);
        G.get(1).add(3); Grev.get(3).add(1);
        G.get(2).add(1); Grev.get(1).add(2);
        G.get(2).add(4); Grev.get(4).add(2);
        G.get(3).add(5); Grev.get(5).add(3);
        G.get(4).add(3); Grev.get(3).add(4);
        G.get(4).add(6); Grev.get(6).add(4);
        G.get(5).add(6); Grev.get(6).add(5);
        G.get(7).add(4); Grev.get(4).add(7);

        int res = countInBetween(nodes, G, Grev, x, y);
        assert res == 5: "The correct result is 5, but we got: " + res;
        System.out.println("The correct result is " + res);
    }


}
