package Dynamic_Programming;

public class AlgoTurm {
    //n bezeichnet die Anzahl der ALGO Steine.
    //l[i] enthält die Länge des i-ten ALGO Steins, für i=1,...,n
    //b[i] enthält die Breite des i-ten ALGO Steins, für i=1,...,n
    //h[i] enthält die Höhe des i-ten ALGO Steins, für i=1,...,n
    static int solve(int n, int[] l, int[] b, int[] h)
    {
        //TODO: Geben Sie die Höhe des höchsten ALGO Turms, der aus den vorhandenen Steinen
        //gebaut werden kann, zurück.

        int res = 0;

        for (int i = n; i > 0; i--) {
            int maxH = 0;
            for (int j = i + 1; j <= n; j++)
                if ((l[i] >= l[j] && b[i] >= b[j]) || (l[i] >= b[j] && b[i] >= l[j]))
                    maxH = h[j] > maxH ? h[j] : maxH;
            h[i] += maxH;
            if (h[i] > res) res = h[i];
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 6;

        int[] l = {0,5,3,6,3,4,1};
        int[] b = {0,4,5,2,3,1,1};
        int[] h = {0,2,1,3,2,1,2};

        int result = solve(n, l, b, h);

        assert result == 7 : "The result should be 7, but it is " + result;

        System.out.println("Result: " + result);
    }
}
