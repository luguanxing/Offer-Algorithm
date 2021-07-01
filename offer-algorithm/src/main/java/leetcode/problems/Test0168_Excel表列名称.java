package leetcode.problems;

public class Test0168_Excel表列名称 {

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(1));
        System.out.println(new Solution().convertToTitle(28));
        System.out.println(new Solution().convertToTitle(701));
        System.out.println(new Solution().convertToTitle(2147483647));
        System.out.println(new Solution().convertToTitle(52));
        System.out.println(new Solution().convertToTitle(676));
    }

    static class Solution {
        public String convertToTitle(int columnNumber) {
            String res = "";
            while (columnNumber >= 26) {
                int last = columnNumber % 26;
                if (last == 0) {
                    res = 'Z' + res;
                    columnNumber--;
                } else {
                    res = (char) (last - 1 + 'A') + res;
                }
                columnNumber = (columnNumber - last) / 26;
            }
            if (columnNumber > 0) {
                res = (char) (columnNumber % 26 - 1 + 'A') + res;
            }
            return res;
        }
    }

}
