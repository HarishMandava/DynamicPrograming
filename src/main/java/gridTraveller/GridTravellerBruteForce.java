package gridTraveller;

public class GridTravellerBruteForce {
    /**
     * Time complexity - O(2 ^ N+M) Space Complexity - O(N+M)
     *
     * @param row  no of rows of the grid
     * @param col  no of columns of the grid
     * @return number of ways to travel the grid
     */

    public static long gridTraveller(int row, int col) {
        if (row < 1 || col < 1) {
            return 0;
        }
        if(row == 1 && col ==1) {
            return 1;
        }
        return gridTraveller(row-1, col) + gridTraveller(row, col-1);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(1, 1)); //1
        System.out.println(gridTraveller(3, 2)); //3
        System.out.println(gridTraveller(2, 3)); //3
        System.out.println(gridTraveller(3, 3)); //6
        System.out.println(gridTraveller(18, 18)); //2333606220
    }
}
