package leetcode.contest.week251;

public class Test5824_子字符串突变后可能得到的最大整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumNumber(
                "132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}
        ));
        System.out.println(new Solution().maximumNumber(
                "021", new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6}
        ));
        System.out.println(new Solution().maximumNumber(
                "5", new int[]{1, 4, 7, 5, 3, 2, 5, 6, 9, 4}
        ));
        System.out.println(new Solution().maximumNumber(
                "330", new int[]{9, 3, 6, 3, 7, 3, 1, 4, 5, 8}
        ));
        System.out.println(new Solution().maximumNumber(
                "334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}
        ));
        System.out.println(new Solution().maximumNumber(
                "214010", new int[]{6, 7, 9, 7, 4, 0, 3, 4, 4, 7}
        ));
        System.out.println(new Solution().maximumNumber(
                "334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}
        ));
    }

    static class Solution {
        public String maximumNumber(String num, int[] change) {
            StringBuilder res = new StringBuilder();
            Integer index = null;
            for (int i = 0; i < num.length(); i++) {
                int oldNum = num.charAt(i) - '0';
                int newNum = change[oldNum];
                if ((newNum > oldNum || (newNum >= oldNum && index != null)) && (index == null || i == index)) {
                    res.append(newNum);
                    if (index == null) {
                        index = i;
                    }
                    index++;
                } else {
                    res.append(oldNum);
                }
            }
            return res.toString();
        }
    }

}
