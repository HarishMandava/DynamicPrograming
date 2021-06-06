package canSum;

import java.util.HashMap;

/**
 * Time complexity: O(M*N)
 * Space complexity: O(M)
 */
public class CanSumMemoization {

    public static boolean canSumMemoization(int targetSum, int[] numbers, HashMap<Integer, Boolean> map) {
        if (map.containsKey(targetSum)) {
            return map.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int number: numbers) {
            int remainderSum = targetSum - number;
            if (canSumMemoization(remainderSum, numbers, map)) {
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSumMemoization(7, new int[]{2, 3}, new HashMap<>())); //false
        System.out.println(canSumMemoization(7, new int[]{5, 2, 4, 7}, new HashMap<>())); //true
        System.out.println(canSumMemoization(7, new int[]{2, 4}, new HashMap<>())); //false
        System.out.println(canSumMemoization(8 , new int[]{2, 3, 5}, new HashMap<>())); //true
        System.out.println(canSumMemoization(301, new int[]{7, 14}, new HashMap<>())); //true
        System.out.println(canSumMemoization(300, new int[]{7, 14}, new HashMap<>())); //false
    }
}
