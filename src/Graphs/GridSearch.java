package Graphs;
import java.util.PriorityQueue;


class Tuple implements Comparable<Tuple> {

    int x;
    int y;
    int cost;

    Tuple(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override public int compareTo(Tuple o) {

        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class GridSearch {

    public static int getMinimumCost(int n, int[][] A) {

        int[][] dist = new int[n][n];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(n * n);

        pq.add(new Tuple(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {

            Tuple curr = pq.remove();

            for (int i = 0; i < 4; i++) {

                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (indexAllowed(rows, cols, n)) {
                    if (dist[rows][cols] > dist[curr.x][curr.y] + A[rows][cols]) {
                        if (dist[rows][cols] != Integer.MAX_VALUE) {
                            Tuple adj = new Tuple(rows, cols, dist[rows][cols]);
                            pq.remove(adj);
                        }

                        dist[rows][cols] = dist[curr.x][curr.y] + A[rows][cols];
                        pq.add(new Tuple(rows, cols, dist[rows][cols]));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }


    public static boolean indexAllowed (int i, int j, int n){
        return (i >= 0 && i<n && j>=0 && j<n);
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] A = { {0,2,0,1},{1,4,1,1},{20,7,1,2},{9,8,3,5}};

        int result = getMinimumCost(n, A);
        assert result == 11 : "The correct result is 11, but we get" + result;
        System.out.println("The result is: " + result);
    }
}
