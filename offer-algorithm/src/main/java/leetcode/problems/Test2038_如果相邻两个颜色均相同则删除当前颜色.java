package leetcode.problems;

public class Test2038_如果相邻两个颜色均相同则删除当前颜色 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean winnerOfGame(String colors) {
            int countA = 0;
            int countB = 0;
            for (int i = 0; i <= colors.length() - 3; i++) {
                String subStr = colors.substring(i, i + 3);
                if ("AAA".equals(subStr)) {
                    countA++;
                } else if ("BBB".equals(subStr)) {
                    countB++;
                }
            }
            return countA > countB;
        }
    }

}
