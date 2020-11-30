package leetcode.problems;

import java.util.*;

public class Test0767_重构字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aab"));
        System.out.println(new Solution().reorganizeString("aaab"));
    }

    static class Solution {
        public String reorganizeString(String S) {
            // 统计每个字符的频率
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : S.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // 每次取出最多的和剩下的
            List<Tuple> list = new ArrayList<>();
            for (Character c : map.keySet()) {
                list.add(new Tuple(c, map.get(c)));
            }
            Character lastChar = null;
            String res = "";
            while (!list.isEmpty()) {
                list.sort((o1, o2) -> o2.times - o1.times);
                if (lastChar == null) {
                    lastChar = list.get(0).c;
                    res += lastChar;
                    list.get(0).times--;
                    if (list.get(0).times == 0) {
                        list.remove(0);
                    }
                } else {
                    if (list.get(0).c == lastChar) {
                        if (list.size() < 2) {
                            return "";
                        } else {
                            lastChar = list.get(1).c;
                            res += lastChar;
                            list.get(1).times--;
                            if (list.get(1).times == 0) {
                                list.remove(1);
                            }
                        }
                    } else {
                        lastChar = list.get(0).c;
                        res += lastChar;
                        list.get(0).times--;
                        if (list.get(0).times == 0) {
                            list.remove(0);
                        }
                    }
                }
            }
            return res;
        }

        class Tuple {
            char c;
            int times;
            public Tuple(char c, int times) {
                this.c = c;
                this.times = times;
            }
        }
    }

}
