package Fibonacci;

public class FibonacciMemoization {
    /**
     *  This is Memoization approach also known as top-down approach
     *  Time Complexity : O(N) Space Complexity: O(N)
     */

    public static long fibonacciMemoization(int n, long[] memo) {
        if (n <=2 ){
            return 1;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(FibonacciMemoization.fibonacciMemoization(6, new long[7]));
        System.out.println(FibonacciMemoization.fibonacciMemoization(7, new long[8]));
        System.out.println(FibonacciMemoization.fibonacciMemoization(50, new long[51]));
    }
}
