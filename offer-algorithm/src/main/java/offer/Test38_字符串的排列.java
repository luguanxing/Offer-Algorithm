package offer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test38_字符串的排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().Permutation(""));
        System.out.println(new Solution().Permutation("abc"));
        System.out.println(new Solution().Permutation("aa"));
        System.out.println(new Solution_全排列().Permutation(""));
        System.out.println(new Solution_全排列().Permutation("abc"));
        System.out.println(new Solution_全排列().Permutation("aa"));
    }

    static class Solution {
        private ArrayList<String> allResult = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            if (str == null || str.isEmpty()) {
                return allResult;
            }
            // 排列
            allResult.clear();
            permutation("", str);
            // 去重
            LinkedHashSet<String> set = new LinkedHashSet<>(allResult);
            return new ArrayList(set);
        }

        private void permutation(String currentStr, String leftStr) {
            if (leftStr == null) {
                return;
            }
            if (leftStr.length() == 0) {
                allResult.add(currentStr);
                return;
            }
            // 递归枚举每个字符和剩下所有字符
            for (int i = 0; i < leftStr.length(); i++) {
                String nextLeftStr = leftStr.substring(0, i) + leftStr.substring(i + 1, leftStr.length());
                permutation(currentStr + leftStr.charAt(i), nextLeftStr);
            }
        }
    }

    static class Solution_全排列 {
        private ArrayList<String> allResult = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            if (str == null || str.isEmpty()) {
                return allResult;
            }
            // 排列
            allResult.clear();
            permutation("", str);
            // 去重
            Set<String> set = new LinkedHashSet<>(allResult);
            return new ArrayList(set);
        }

        private void permutation(String currentStr, String leftStr) {
            if (leftStr == null) {
                return;
            }
            allResult.add(currentStr);
            if (leftStr.length() == 0) {
                return;
            }
            // 递归枚举每个字符和剩下所有字符
            for (int i = 0; i < leftStr.length(); i++) {
                String nextLeftStr = leftStr.substring(0, i) + leftStr.substring(i + 1, leftStr.length());
                permutation(currentStr + leftStr.charAt(i), nextLeftStr);
            }
        }
    }

}
