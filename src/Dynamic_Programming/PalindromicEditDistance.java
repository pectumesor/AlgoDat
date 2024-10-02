package Dynamic_Programming;

public class PalindromicEditDistance {


    public static int Palindromic_Edit_Distance(char []A, int n)
    {
        //  A:      The input sequence
        //  n:      The length of A;

        int [][]DP=new int[n][n];

        for (int i = 0; i<n-1;i++){
            if (A[i] == A[i+1]){
                DP[i][i+1] = 0;
            } else {
                DP[i][i+1] = 1;
            }
        }

        for (int j = 2; j<n;j++){
            for (int i = 0; i<n-j;i++){

                int k = i+j;

                if (A[i] == A[k]){
                    DP[i][k] = Math.min(Math.min(DP[i+1][k] + 1 ,DP[i][k-1] + 1),DP[i+1][k-1]);
                } else {
                    DP[i][k] = Math.min(Math.min(DP[i+1][k] + 1,DP[i][k-1] + 1 ),DP[i+1][k-1] + 1);
                }

            }
        }

        return DP[0][n-1];
    }

    public static void main(String[] args) {

        char[] A = {'E','T','H','Z','E','T','H','Z'};
        System.out.println(Palindromic_Edit_Distance(A,A.length));
    }
}
