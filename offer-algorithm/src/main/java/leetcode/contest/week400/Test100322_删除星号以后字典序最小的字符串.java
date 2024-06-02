package leetcode.contest.week400;

import java.util.*;
import java.util.stream.Collectors;

public class Test100322_删除星号以后字典序最小的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().clearStars("aaba*"));
        System.out.println(new Solution().clearStars("abc"));
        System.out.println(new Solution().clearStars("d*yed"));
        System.out.println(new Solution().clearStars("d*ded*"));
        System.out.println(new Solution().clearStars("d*dad*"));
    }

    static class Solution {
        public String clearStars(String s) {
            // 统计字符频率和位置
            TreeMap<Character, Integer> charCntMap = new TreeMap<>();
            Map<Character, List<Integer>> charIndexMap = new HashMap<>();
            // 存储字符结果
            List<Character> resultList = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '*') {
                    charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
                    resultList.add(c);
                    charIndexMap.putIfAbsent(c, new LinkedList<>());
                    charIndexMap.get(c).add(resultList.size() - 1);
                } else {
                    if (!charCntMap.isEmpty()) {
                        char minChar = charCntMap.firstKey();
                        if (charCntMap.get(minChar) == 1) {
                            charCntMap.remove(minChar);
                        } else {
                            charCntMap.put(minChar, charCntMap.get(minChar) - 1);
                        }
                        List<Integer> positions = charIndexMap.get(minChar);
                        int pos = positions.remove(positions.size() - 1);
                        resultList.set(pos, null);
                    }
                }
            }
            // 拼接非null的答案并返回
            return resultList.stream().filter(Objects::nonNull) .map(String::valueOf).collect(Collectors.joining());
        }
    }
}
