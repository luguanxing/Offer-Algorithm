package leetcode.problems;

public class Test2844_生成特殊数字的最少操作 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("2245047"));
        System.out.println(new Solution().minimumOperations("2908305"));
        System.out.println(new Solution().minimumOperations("10"));
        System.out.println(new Solution().minimumOperations("5"));
        System.out.println(new Solution().minimumOperations("133523593574688976"));
        System.out.println(new Solution().minimumOperations("100"));
    }

    static class Solution {
        public int minimumOperations(String num) {
            // 从右到左删除，能被25整除的是00 25 50 75
            int cnt0 = 0;
            int cnt5 = 0;
            int delCnt = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                if (c == '0') {
                    if (cnt0 >= 1) {
                        // 删除多于的其它数和5
                        return delCnt + cnt5 + (cnt0 - 1);
                    } else {
                        cnt0++;
                    }
                } else if (c == '5') {
                    if (cnt0 >= 1) {
                        // 删除多于的其它数和5
                        return delCnt + cnt5 + (cnt0 - 1);
                    } else {
                        cnt5++;
                    }
                } else if (c == '7') {
                    if (cnt5 >= 1) {
                        // 删除多于的其它数和0
                        return delCnt + cnt0 + (cnt5 - 1);
                    } else {
                        delCnt++;
                    }
                } else if (c == '2') {
                    if (cnt5 >= 1) {
                        // 删除多于的其它数和0
                        return delCnt + cnt0 + (cnt5 - 1);
                    } else {
                        delCnt++;
                    }
                } else {
                    delCnt++;
                }
            }
            // 剩余看是否有0
            if (cnt0 == 1) {
                return num.length() - 1;
            }
            return num.length();
        }
    }

}
