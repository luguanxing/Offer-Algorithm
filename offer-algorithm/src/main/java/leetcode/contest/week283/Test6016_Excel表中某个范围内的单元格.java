package leetcode.contest.week283;

import java.util.ArrayList;
import java.util.List;

public class Test6016_Excel表中某个范围内的单元格 {

    public static void main(String[] args) {
        System.out.println(new Solution().cellsInRange("K1:L2"));
        System.out.println(new Solution().cellsInRange("A1:F1"));
    }

    static class Solution {
        public List<String> cellsInRange(String s) {
            char startY = s.split(":")[0].charAt(0);
            char startX = s.split(":")[0].charAt(1);
            char endY = s.split(":")[1].charAt(0);
            char endX = s.split(":")[1].charAt(1);
            List<String> res = new ArrayList<>();
            for (char c = startY; c <= endY; c++) {
                for (char n = startX; n <= endX; n++) {
                    res.add(c + "" + n);
                }
            }
            return res;
        }
    }

}
