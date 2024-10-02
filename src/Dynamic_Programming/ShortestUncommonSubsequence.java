package Dynamic_Programming;

public class ShortestUncommonSubsequence {
    public static int ShortestUncommonSubsequence(int n, int m, char[] A, char B[]) {
        int[][] DP = new int[n+1][m+1];
        // TODO: implement

        int max = 1000;

        int check = 0;

        for (int i = 1; i<=n;i++){
            DP[i][0] = 1;
        }

        for (int i = 0; i<=m;i++){
            DP[0][i] = max;
        }

        for (int i = 1; i<=n;i++){
            for (int j = 1; j<=m;j++){

                char ch = A[i-1];
                int k;

                for (k = j-1; k>=0;k--){
                    if (B[k] == ch){
                        break;
                    }
                }

                if (k == -1){
                    DP[i][j] = 1;
                } else {
                    DP[i][j] = Math.min(DP[i-1][j],DP[i-1][k] +1);
                }
            }
        }
        return DP[n][m];
    }

    public static void main(String[] args) {

        char[] A = {'E', 'E', 'T', 'T', 'T'};
        char[] B = {'T', 'E', 'T', 'T', 'E'};
        System.out.println(ShortestUncommonSubsequence(A.length, B.length, A, B));
    }
}
