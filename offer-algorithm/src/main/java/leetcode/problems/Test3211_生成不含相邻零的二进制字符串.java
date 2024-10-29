package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test3211_生成不含相邻零的二进制字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().validStrings(3));
        System.out.println(new Solution().validStrings(1));
    }

    static class Solution {
        private List<String> res = new ArrayList<>();

        public List<String> validStrings(int n) {
            generateStrings("0", n - 1);
            generateStrings("1", n - 1);
            return res;
        }

        private void generateStrings(String currentStr, int left) {
            if (left == 0) {
                res.add(currentStr);
                return;
            }
            if (currentStr.charAt(currentStr.length() - 1) == '0') {
                generateStrings(currentStr + "1", left - 1);
            } else {
                generateStrings(currentStr + "0", left - 1);
                generateStrings(currentStr + "1", left - 1);
            }
        }
    }

}
