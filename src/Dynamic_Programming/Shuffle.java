package Dynamic_Programming;

public class Shuffle {

    public static boolean Shuffle(int n, int m, char[] A, char[] B, char[] C)
    {
        //The input arrays A, B and C are indexed from 1 instead of 0 in the code.

        boolean[][] DP=new boolean[n+1][m+1];

        // Base Case

        DP[0][0] = true;
        for (int i = 1; i<=n;i++){
            if (A[i] == C[i]){
                DP[i][0] = true;
            }
        }

        for (int j = 1; j<=m;j++){
            if (B[j] == C[j]){
                DP[0][j] = true;
            }
        }

        //Recursion

        for (int i = 1; i<=n;i++){
            for (int j = 1; j<=m;j++){
                int k = i+j;

                if (A[i] == C[k] && B[j] != C[k]){
                    DP[i][j] = DP[i-1][j];
                } else if (A[i] != C[k] && B[j] == C[k]){
                    DP[i][j] = DP[i][j-1];
                } else if (A[i] == C[k] && B[j] == C[k]){
                    DP[i][j] = DP[i-1][j] || DP[i][j-1];
                }
            }
        }
        return DP[n][m];
    }

    public static void main(String[] args) {

        char[] A = {' ','P','A','P','L','E'};
        char[] B = {' ','I','N','E','P'};
        char[] C = {' ' ,'P','I','N','E','A','P','P','L','E'};

        int n = A.length - 1;
        int m = B.length - 1;

        boolean result = Shuffle(n, m, A, B, C);

        assert result == true: "The result is true, but it is" + result;
        System.out.println("The result is: " + result);

    }
}
