package GeneralAlgorithms;

public class MaxHeap {

        //
        // We assume that the heap will not exceed MAX_HEAPSIZE length
        //
        final static int MAX_HEAPSIZE = 100000;
        //
        // This field describes the number of elements that the heap holds
        //
        private int N = 0;
        //
        // The values of the heap are stored in this array
        //
        private int values[] = new int [MAX_HEAPSIZE];
        //
        // Default empty constructor
        //
        public MaxHeap () {
            // do nothing ...
        }
        //
        // Helper function that provides comparison.
        //
        private boolean cmp(int a, int b) {
            return a < b;
        }
        //
        // Helper function that swaps the i-th & the j-th element of the heap
        //
        private void swap (int i, int j) {
            int tmp = values[i];
            values[i] = values[j];
            values[j] = tmp;
        }


        // ====================================================================================================================
        // Complete the methods below. Feel free to add additional methods / fields if needed.
        // ====================================================================================================================

        //
        // We assume that values are already stored in the values[] array, but they
        // do not hold the heap condition and have arbitrary order. We need to
        // restore the heap condition using the method below.
        //
        public void buildHeap () {
            //
            // Your code goes here ...
            //

            int start = (N/2) - 1 ;

            for (int i = start; i>=0; i--){
                heapify(i);
            }

        }

        public void heapify(int i){

            int largest = i;
            int l = 2*i+1;
            int r = 2*i+2;

            if (l<N && values[l] > values[largest]){
                largest = l;
            }

            if (r<N && values[r] > values[largest]){
                largest = r;
            }

            if (largest != i){
                swap(i,largest);
                heapify(largest);
            }


        }

        //
        // Inserts a value in the heap, and places it on the right positions such
        // that the heap condition holds.
        //
        public void insert(int value) {
            //
            // Your code goes here ...
            //
            values[N] = value;
            int curr = N;
            while (values[curr] > values[(curr-1)/2 ]){
                swap(curr,(curr-1)/2);
                curr = (curr-1)/2;
            }
            N++;
        }

        //
        // Pops the first value from the heap, restoring the heap condition
        //
        public void deleteMax () {
            //
            // Your code goes here ...
            //
            swap(0,N-1);
            N--;
            heapify(0);

        }

        // ====================================================================================================================
        // End of implementation
        // ====================================================================================================================
    }
