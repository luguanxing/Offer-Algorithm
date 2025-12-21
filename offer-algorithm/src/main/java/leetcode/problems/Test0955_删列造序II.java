package leetcode.problems;

public class Test0955_删列造序II {

    public static void main(String[] args) {
        // strs = ["ca","bb","ac"]
        System.out.println(new Solution().minDeletionSize(new String[]{"ca", "bb", "ac"}));
        // strs = ["xc","yb","za"]
        System.out.println(new Solution().minDeletionSize(new String[]{"xc", "yb", "za"}));
        // strs = ["zyx","wvu","tsr"]
        System.out.println(new Solution().minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }

    static class Solution {
        public int minDeletionSize(String[] strs) {
            int height = strs.length;
            int width = strs[0].length();
            StringBuilder[] sbArr = new StringBuilder[height];
            for (int i = 0; i < height; i++) {
                sbArr[i] = new StringBuilder();
            }
            // 贪心删除列
            int cnt = 0;
            for (int col = 0; col < width; col++) {
                boolean canKeep = true;
                for (int row = 1; row < height; row++) {
                    String prev = sbArr[row - 1].toString();
                    String curr = sbArr[row].toString();
                    char prevChar = strs[row - 1].charAt(col);
                    char currChar = strs[row].charAt(col);
                    if (prev.compareTo(curr) > 0 || (prev.compareTo(curr) == 0 && prevChar > currChar)) {
                        canKeep = false;
                        break;
                    }
                }
                if (canKeep) {
                    for (int row = 0; row < height; row++) {
                        sbArr[row].append(strs[row].charAt(col));
                    }
                } else {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
