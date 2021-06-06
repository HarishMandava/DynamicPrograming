package bestSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Time complexity: O(N*M*M)
 *  Space Complexity: O(M*M)
 */
public class BestSumMemoization {

    public static List<Integer> bestSumMemoization(int targetSum, int[] numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        List<Integer> shortestList = null;
        for (int number: numbers) {
            int remainingSum = targetSum - number;
            List<Integer> remainderList = bestSumMemoization(remainingSum, numbers, memo);
            if (remainderList != null) {
                List<Integer> list = new ArrayList<>(remainderList);
                list.add(number);
                if (shortestList == null || list.size() < shortestList.size()) {
                    shortestList = list;
                }
            }
        }
        memo.put(targetSum, shortestList);
        return shortestList;
    }

    public static void main(String[] args) {
        System.out.println(bestSumMemoization(7, new int[]{5, 3, 4, 7}, new HashMap<>())); //[7]
        System.out.println(bestSumMemoization(8, new int[]{2, 3, 5}, new HashMap<>())); //[3, 5]
        System.out.println(bestSumMemoization(8, new int[]{1, 4, 5}, new HashMap<>())); // [4, 4]
        System.out.println(bestSumMemoization(100 , new int[]{1, 2, 5, 25}, new HashMap<>())); //[25, 25, 25, 25]
        System.out.println(bestSumMemoization(301, new int[]{7, 14}, new HashMap<>())); //[14, 14, 14, 14,..., 7]
        System.out.println(bestSumMemoization(300, new int[]{7, 14}, new HashMap<>())); //null
    }
}
