package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test3403_从盒子中找出字典序最大的字符串I {

    public static void main(String[] args) {
        // word = "dbca", numFriends = 2
        System.out.println(new Solution().answerString("dbca", 2));
        // word = "gggg", numFriends = 4
        System.out.println(new Solution().answerString("gggg", 4));
        System.out.println(new Solution().answerString("gh", 1));
        System.out.println(new Solution().answerString("nbjnc", 2));
        System.out.println(new Solution().answerString("aann", 2));
    }

    static class Solution {
        public String answerString(String word, int numFriends) {
            int len = word.length();
            if (numFriends == 1) {
                return word;
            }
            // 记录最大char的下标和位置
            char maxChar = 'a';
            List<Integer> maxCharIndexes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (c > maxChar) {
                    maxChar = c;
                    maxCharIndexes.clear();
                    maxCharIndexes.add(i);
                } else if (c == maxChar) {
                    maxCharIndexes.add(i);
                }
            }
            // 用记录的最大下标位置找字典序最大的字符串
            TreeSet<String> set = new TreeSet<>();
            int maxLen = len - numFriends + 1;
            for (int maxCharIndex : maxCharIndexes) {
                String subStr = word.substring(maxCharIndex, Math.min(maxCharIndex + maxLen, len));
                set.add(subStr);
            }
            return set.last();
        }
    }

    static class Solution_暴力 {
        public String answerString(String word, int numFriends) {
            int len = word.length();
            if (numFriends == 1) {
                return word;
            }
            int maxLen = len - numFriends + 1;
            String maxStr = null;
            // 找长度为maxLen字典序最大的字符串（字典序前部分大，整个maxLen也大），注意尾巴要单独处理
            for (int i = maxLen; i <= len + maxLen; i++) {
                String currentStr = word.substring(i-maxLen, Math.min(i, len));
                if (maxStr == null || currentStr.compareTo(maxStr) > 0) {
                    maxStr = currentStr;
                }
            }
            return maxStr;
        }
    }

    static class Solution_双重循环 {
        public String answerString(String word, int numFriends) {
            int len = word.length();
            if (numFriends == 1) {
                return word;
            }
            // 记录最大char的下标
            char maxChar = 'a';
            List<Integer> maxCharIndexes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (c > maxChar) {
                    maxChar = c;
                    maxCharIndexes.clear();
                    maxCharIndexes.add(i);
                } else if (c == maxChar) {
                    maxCharIndexes.add(i);
                }
            }
            // 找位置
            int maxLen = len - numFriends + 1;
            String res = "";
            for (int maxCharIndex : maxCharIndexes) {
                for (int j = 0; j <= maxLen && maxCharIndex + j <= len; j++) {
                    String subStr = word.substring(maxCharIndex, maxCharIndex + j);
                    if (subStr.compareTo(res) > 0) {
                        res = subStr;
                    }
                }
            }
            return res;
        }
    }

}
