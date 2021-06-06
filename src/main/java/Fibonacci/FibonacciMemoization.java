package Fibonacci;

public class FibonacciMemoization {
    /**
     *  This is Memoization approach also known as top-down approach
     *  Time Complexity : 0(N) Space Complexity: 0(N)
     */

    public static long FibonacciMemoization(int n, long[] memo) {
        if (n <=2 ){
            return 1;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        memo[n] = FibonacciMemoization(n-1, memo) + FibonacciMemoization(n-2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(FibonacciMemoization.FibonacciMemoization(6, new long[7]));
        System.out.println(FibonacciMemoization.FibonacciMemoization(7, new long[8]));
        System.out.println(FibonacciMemoization.FibonacciMemoization(50, new long[51]));
    }
}
