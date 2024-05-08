package leetcode.contest.week396;

import java.util.*;

public class Test100283_同位字符串连接的最小长度 {

    public static void main(String[] args) {
//        System.out.println(new Solution().minAnagramLength("abba"));
//        System.out.println(new Solution().minAnagramLength("cdef"));
//        // 自定义用例
//        System.out.println(new Solution().minAnagramLength("abbaba"));
//        System.out.println(new Solution().minAnagramLength("abbabaab"));
//        System.out.println(new Solution().minAnagramLength("aabb"));
//        System.out.println(new Solution().minAnagramLength("aabbab"));
//        System.out.println(new Solution().minAnagramLength("abbac"));
//        System.out.println(new Solution().minAnagramLength("ababaa"));
//        System.out.println(new Solution().minAnagramLength("ababa"));
//        System.out.println(new Solution().minAnagramLength("c"));
//        System.out.println(new Solution().minAnagramLength("cc"));
//        System.out.println(new Solution().minAnagramLength("ccc"));
//        System.out.println(new Solution().minAnagramLength("cxxcxc"));
//        System.out.println(new Solution().minAnagramLength("cxxxcc"));
//        System.out.println(new Solution().minAnagramLength("oionssonoi"));
//        System.out.println(new Solution().minAnagramLength("cxxxxc"));
//        System.out.println(new Solution().minAnagramLength("cxxxcx"));
//        System.out.println(new Solution().minAnagramLength("cxxxxc"));
//        System.out.println(new Solution().minAnagramLength("xxxxxx"));
//        System.out.println(new Solution().minAnagramLength("xxxxx"));
//        System.out.println(new Solution().minAnagramLength("aabb"));
//        System.out.println(new Solution().minAnagramLength("abaababaab"));
//        System.out.println(new Solution().minAnagramLength("xxe"));
//        System.out.println(new Solution().minAnagramLength("cccccccc"));
        System.out.println(new Solution().minAnagramLength("lbuorourlb"));
    }

    static class Solution {
        public int minAnagramLength(String s) {
            Map<Integer, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c - 'a', map.getOrDefault(c - 'a', 0) + 1);
            }
            if (map.size() == 1) {
                return 1;
            }
            // 遍历所有因子
            for (int minLoopCnt = s.length() - 1; minLoopCnt >= 1; minLoopCnt--) {
                if (s.length() % minLoopCnt != 0) {
                    continue;
                }
                // 还要判断是否能拼接而成
                boolean isAnagram = true;
                String pattern = null;
                int patternLen = s.length() / minLoopCnt;
                for (int i = 0; i < minLoopCnt; i++) {
                    char[] chars = s.substring(i * patternLen, (i + 1) * patternLen).toCharArray();
                    Arrays.sort(chars);
                    if (pattern == null) {
                        pattern = new String(chars);
                    } else {
                        if (!pattern.equals(new String(chars))) {
                            isAnagram = false;
                            break;
                        }
                    }
                }
                if (isAnagram) {
                    return patternLen;
                }
            }
            return s.length();
        }
    }

}
