package leetcode.problems;

public class Test0522_最长特殊序列II {

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[]{"aba","cdc","eae"}));
        System.out.println(new Solution().findLUSlength(new String[]{"aaa","aaa","aa"}));
    }

    static class Solution {
        public int findLUSlength(String[] strs) {
            int len = strs.length;
            int max = -1;

            for (int i = 0; i < len; i++) {
                String currentStr = strs[i];
                boolean isOk = true;
                for (int j = 0; j < len; j++) {
                    if (j == i) {
                        continue;
                    }
                    String otherStr = strs[j];
                    if (isSubSeq(currentStr, otherStr)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    max = Math.max(max, currentStr.length());
                }
            }

            return max;
        }

        private boolean isSubSeq(String subStr, String parentStr) {
            int subIndex = 0;
            int parentIndex = 0;
            while (parentIndex < parentStr.length() && subIndex < subStr.length()) {
                if (parentStr.charAt(parentIndex) == subStr.charAt(subIndex)) {
                    subIndex++;
                }
                parentIndex++;
            }
            return subIndex == subStr.length();
        }
    }

}
