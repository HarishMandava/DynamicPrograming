package bestSum;

import java.util.ArrayList;
import java.util.List;

public class BestSumBruteForce {

    public static List<Integer> bestSum(int totalSum, int[] numbers) {
        if (totalSum == 0) {
            return new ArrayList<>();
        }
        if (totalSum < 0) {
            return null;
        }
        List<Integer> shortestList = null;
        for(int number: numbers) {
            int remainderSum = totalSum - number;
            List<Integer> list = bestSum(remainderSum, numbers);
            if(list != null) {
                list.add(number);
                if (shortestList == null || list.size() < shortestList.size()) {
                    shortestList = list;
                }
            }
        }
        return shortestList;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7})); //[7]
        System.out.println(bestSum(8, new int[]{2, 3, 5})); //[3, 5]
        System.out.println(bestSum(8, new int[]{1, 4, 5})); // [4, 4]
//        System.out.println(bestSum(100 , new int[]{1, 2, 5, 25})); //[25, 25, 25, 25]
        System.out.println(bestSum(301, new int[]{7, 14})); //[14, 14, 14, 14,..., 7]
        System.out.println(bestSum(300, new int[]{7, 14})); //null
    }
}
