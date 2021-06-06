package howSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Time complexity : O(N*M)
 *  Space complexity : 0(M*M)
 */

public class HowSumMemoization {

    public static List<Integer> howSumMemoization(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int number: numbers) {
            int remainingSum = targetSum - number;
            List<Integer> list = howSumMemoization(remainingSum, numbers, memo);
            if(list != null) {
                list.add(number);
                memo.put(targetSum, list);
                return list;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSumMemoization(7, new int[]{2, 3}, new HashMap<>())); //[3, 2, 2]
        System.out.println(howSumMemoization(7, new int[]{5, 2, 4, 7}, new HashMap<>())); //[2, 5]
        System.out.println(howSumMemoization(7, new int[]{2, 4}, new HashMap<>())); //null
        System.out.println(howSumMemoization(8 , new int[]{2, 3, 5}, new HashMap<>())); //[2, 2, 2, 2]
        System.out.println(howSumMemoization(301, new int[]{7, 14}, new HashMap<>())); //[7, 7, 7, 7,..., 7]
        System.out.println(howSumMemoization(300, new int[]{7, 14}, new HashMap<>())); //null
    }
}
