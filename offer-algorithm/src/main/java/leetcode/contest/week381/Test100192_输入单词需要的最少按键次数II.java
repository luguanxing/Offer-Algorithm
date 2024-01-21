package leetcode.contest.week381;

import java.util.*;

public class Test100192_输入单词需要的最少按键次数II {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPushes("abcde"));
        System.out.println(new Solution().minimumPushes("xyzxyzxyzxyz"));
        System.out.println(new Solution().minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    static class Solution {
        public int minimumPushes(String word) {
            // 统计每个字符的频率
            Map<Character, Integer> frequency = new HashMap<>();
            for (char c : word.toCharArray()) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }

            // 根据频率排序字符
            List<Character> chars = new ArrayList<>(frequency.keySet());
            chars.sort((a, b) -> frequency.get(b) - frequency.get(a));

            // 分配按键
            Map<Integer, List<Character>> map = new HashMap<>();
            int index = 2;
            for (char c : chars) {
                List<Character> list = map.getOrDefault(index, new ArrayList<>());
                list.add(c);
                map.put(index, list);
                index++;
                if (index == 10) {
                    index = 2;
                }
            }
            int res = 0;
            for (char c : frequency.keySet()) {
                int f = frequency.get(c);
                for (List<Character> list : map.values()) {
                    if (list.contains(c)) {
                        res += f * (list.indexOf(c) + 1);
                        break;
                    }
                }
            }
            return res;
        }
    }

}
