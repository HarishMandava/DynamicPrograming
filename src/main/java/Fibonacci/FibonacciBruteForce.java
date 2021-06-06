package Fibonacci;

public class FibonacciBruteForce {

    public static long fibonacci(int n) {
        if(n <= 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(FibonacciBruteForce.fibonacci(6));
        System.out.println(FibonacciBruteForce.fibonacci(7));
        System.out.println(FibonacciBruteForce.fibonacci(50));
    }

    // Time Complexity : O(2 ^ N)  Space Complexity : O(N)
}
