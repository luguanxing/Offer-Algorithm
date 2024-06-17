package leetcode.problems;

public class Test0522_最长特殊序列II {

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[]{"aba", "cdc", "eae"}));
        System.out.println(new Solution().findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }

    static class Solution {
        public int findLUSlength(String[] strs) {
            int len = strs.length;
            int max = -1;
            for (int i = 0; i < len; i++) {
                String currentStr = strs[i];
                boolean isIndependent = true;
                for (int j = 0; j < len; j++) {
                    String otherStr = strs[j];
                    if (j == i || currentStr.length() > otherStr.length()) {
                        continue;
                    }
                    if (isSubSeq(currentStr, otherStr)) {
                        isIndependent = false;
                        break;
                    }
                }
                if (isIndependent) {
                    max = Math.max(max, currentStr.length());
                }
            }
            return max;
        }

        private boolean isSubSeq(String currentStr, String otherStr) {
            int subIndex = 0;
            int otherIndex = 0;
            while (otherIndex < otherStr.length() && subIndex < currentStr.length()) {
                if (currentStr.charAt(subIndex) == otherStr.charAt(otherIndex)) {
                    subIndex++;
                }
                otherIndex++;
            }
            return subIndex == currentStr.length();
        }
    }

    static class Solution_OLD {
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
