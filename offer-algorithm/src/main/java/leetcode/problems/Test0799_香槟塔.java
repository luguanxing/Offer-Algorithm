package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0799_香槟塔 {

    public static void main(String[] args) {
        System.out.println(new Solution().champagneTower(1, 1, 1));
        System.out.println(new Solution().champagneTower(2, 1, 1));
        System.out.println(new Solution().champagneTower(4, 2, 1));
        System.out.println(new Solution().champagneTower(4, 2, 2));
        System.out.println(new Solution().champagneTower(100000009, 33, 17));
    }

    static class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            List<Double> currentRow = new ArrayList<>();
            currentRow.add(poured * 1.0);
            for (int row = 1; row <= query_row; row++) {
                int lastSize = currentRow.size();
                List<Double> nextRow = new ArrayList<>();
                double leftestSpill = currentRow.get(0) - 1;
                nextRow.add(leftestSpill <= 0 ? 0 : leftestSpill * 0.5);
                for (int i = 1; i < lastSize; i++) {
                    double leftSpill = currentRow.get(i - 1) - 1;
                    double rightSpill = currentRow.get(i) - 1;
                    nextRow.add((leftSpill <= 0 ? 0 : leftSpill * 0.5) + (rightSpill <= 0 ? 0 : rightSpill * 0.5));
                }
                double rightestSpill = currentRow.get(lastSize - 1) - 1;
                nextRow.add(rightestSpill <= 0 ? 0 : rightestSpill * 0.5);
                currentRow = nextRow;
            }
            return currentRow.get(query_glass) >= 1 ? 1 : currentRow.get(query_glass);
        }
    }

}
