package canSum;

/**
 *  given an array of positive integers and a target sum. determine
 *  if any combination of elements in the array can sum to target sum.
 *
 *  Time complexity: O(N^M)
 *  Space complexity: O(M)
 */
public class CanSumBruteForce {

    public static boolean canSum(int targetSum, int[] numbers) {
        if(targetSum == 0) {
            return true;
        }
        if(targetSum < 0) {
            return false;
        }
        for(int number: numbers) {
            int remainingSum = targetSum - number;
            if(canSum(remainingSum, numbers)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3})); //true
        System.out.println(canSum(7, new int[]{5, 2, 4, 7})); //true
        System.out.println(canSum(7, new int[]{2, 4})); //false
        System.out.println(canSum(8 , new int[]{2, 3, 5})); //true
        System.out.println(canSum(301, new int[]{7, 14})); //true
        System.out.println(canSum(300, new int[]{7, 14})); //false
    }
}
