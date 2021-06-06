package howSum;

import java.util.ArrayList;
import java.util.List;

/**
 *  print any combination that sums up to form targetSum from a given list of numbers
 *
 *  Time complexity: O(N^M)
 *  Space Complexity: O(M)
 */
public class HowSumBruteForce {

    public static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
           return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int number: numbers) {
            int remainingSum = targetSum - number;
            List<Integer> list = howSum(remainingSum, numbers);
            if (list != null) {
                list.add(number);
                return list;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3})); //[3, 2, 2]
        System.out.println(howSum(7, new int[]{5, 2, 4, 7})); //[2, 5]
        System.out.println(howSum(7, new int[]{2, 4})); //null
        System.out.println(howSum(8 , new int[]{2, 3, 5})); //[2, 2, 2, 2]
        System.out.println(howSum(301, new int[]{7, 14})); //[7, 7, 7, 7,..., 7]
        System.out.println(howSum(300, new int[]{7, 14})); //null
    }
}
