package gridTraveller;

import java.util.HashMap;

public class GridTravellerMemoization {

    /**
     * Time complexity - O(M*N) space complexity - 0 (M+N)
     * @param row no of rows in grid
     * @param col no of rows in col
     * @param map map to memoize
     * @return no of ways to travel the grid
     */
    public static long gridTravellerMemoization(int row, int col, HashMap<String, Long> map) {
        if(map.containsKey(row + "-" + col)) {
            return map.get(row + "-" + col);
        }
        if(map.containsKey(col + "-" + row)) {
            return map.get(col + "-" + row);
        }
        if (row == 0 || col == 0) {
            return 0;
        }
        if (row == 1 && col == 1) {
            return 1;
        }
        long val = gridTravellerMemoization(row-1, col, map) + gridTravellerMemoization(row, col-1, map);
        map.put(row + "-" + col, val);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(gridTravellerMemoization(1, 1, new HashMap<>())); //1
        System.out.println(gridTravellerMemoization(3, 2, new HashMap<>())); //3
        System.out.println(gridTravellerMemoization(2, 3, new HashMap<>())); //3
        System.out.println(gridTravellerMemoization(3, 3, new HashMap<>())); //6
        System.out.println(gridTravellerMemoization(18, 18, new HashMap<>())); //2333606220
    }
}
