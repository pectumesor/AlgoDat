package GeneralAlgorithms;

class MultipleOfThree {
    public static int getNumberMoves(int n, int k, int[] A, int[] P) {
        // TODO: implement

        int res = 0;
        int cutoff = n;

        for (int i = k; i<n; i=P[i]){
            if (A[i] % 3 == 0){
                return res;
            }else if (cutoff == 0){
                return -1;
            } else {
                res++;
                cutoff--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 0;
        int[] A = {1,3,1,2,2};
        int[] P = {2,0,3,1,1};
        System.out.println(getNumberMoves(n, k, A, P));
    }
}