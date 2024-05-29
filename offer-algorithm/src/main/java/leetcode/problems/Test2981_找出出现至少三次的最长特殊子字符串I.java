package leetcode.problems;

import java.util.*;

public class Test2981_找出出现至少三次的最长特殊子字符串I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
        System.out.println(new Solution().maximumLength("abcdef"));
        System.out.println(new Solution().maximumLength("abcaba"));
        System.out.println(new Solution().maximumLength("abcccccdddd"));
        System.out.println(new Solution().maximumLength("acc"));
        System.out.println(new Solution().maximumLength("aaa"));
        System.out.println(new Solution().maximumLength("eccdnmcnkl"));
        System.out.println(new Solution().maximumLength("lkwwdddddnnnnnynnnnl"));
        System.out.println(new Solution().maximumLength("ceeeeeeeeeeeebmmmfffeeeeeeeeeeeewww"));
        System.out.println(new Solution().maximumLength("cddedeedccedcedecdedcdeededdddcdddddcdeecdcddeecdc"));
        System.out.println(new Solution().maximumLength("jinhhhtttttttefffffjjjjjjjjjfffffjjjjjjjjjqvvvvvvg"));
    }

    static class Solution {
        public int maximumLength(String s) {
            // 统计字符连续次数
            Map<Character, List<Integer>> map = new HashMap<>();
            char lastChar = s.charAt(0);
            int cnt = 1;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == lastChar) {
                    cnt++;
                    continue;
                }
                List<Integer> list = map.getOrDefault(lastChar, new ArrayList<>());
                list.add(cnt);
                map.put(lastChar, list);
                lastChar = c;
                cnt = 1;
            }
            List<Integer> list = map.getOrDefault(lastChar, new ArrayList<>());
            list.add(cnt);
            map.put(lastChar, list);
            // 找大于3的值或者长度为3以上的最小值
            int max = -1;
            for (List<Integer> cnts : map.values()) {
                Collections.sort(cnts);
                if (cnts.get(cnts.size() - 1) >= 3) {
                    max = Math.max(max, cnts.get(cnts.size() - 1) - 2);
                    if (cnts.size() >= 2 && cnts.get(cnts.size() - 1) != (int)cnts.get(cnts.size() - 2)) {
                        max = Math.max(max, cnts.get(cnts.size() - 2));
                    }
                    if (cnts.size() >= 2 && cnts.get(cnts.size() - 1) == (int)cnts.get(cnts.size() - 2)) {
                        max = Math.max(max, cnts.get(cnts.size() - 1) - 1);
                    }
                }
                if (cnts.size() >= 3) {
                    max = Math.max(max, cnts.get(cnts.size() - 3));
                }
                if (cnts.size() == 2 && cnts.get(0) + cnts.get(1) >= 3) {
                    if (cnts.get(0) != cnts.get(1)) {
                        max = Math.max(max, cnts.get(0));
                    } else {
                        max = Math.max(max, cnts.get(0) - 1);
                    }
                }
            }
            System.out.println(map);
            return max;
        }
    }

    static class Solution_穷举 {
        public int maximumLength(String s) {
            int max = -1;
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.indexOf(c) == -1) {
                    continue;
                }
                for (int len = 1; len <= s.length(); len++) {
                    String str = "";
                    for (int i = 0; i < len; i++) {
                        str += c;
                    }
                    int index1 = s.indexOf(str);
                    int index2 = s.indexOf(str, index1 + 1);
                    int index3 = s.indexOf(str, index2 + 1);
                    if (index1 != -1 && index2 != -1 && index3 != -1) {
                        max = Math.max(max, len);
                    }
                }
            }
            return max;
        }
    }

}
