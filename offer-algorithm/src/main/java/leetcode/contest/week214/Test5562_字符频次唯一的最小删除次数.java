package leetcode.contest.week214;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5562_字符频次唯一的最小删除次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDeletions("aab"));
        System.out.println(new Solution().minDeletions("aaabbbcc"));
        System.out.println(new Solution().minDeletions("ceabaacb"));
        System.out.println(new Solution().minDeletions("bbcebab"));
    }

    static class Solution {
        public int minDeletions(String s) {
            // 统计每个字符频次
            Map<Character, Integer> cntMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
            }
            // 判断词频重复的删除并计数
            List<Integer> values = new ArrayList<>(cntMap.values());
            int res = 0;
            for (int i = 0; i < values.size(); i++) {
                while (true) {
                    boolean isOnlyOnce = true;
                    for (int j = 0; j < values.size(); j++) {
                        if (i == j) {
                            continue;
                        }
                        if (values.get(i) == 0) {
                            continue;
                        }
                        if (values.get(i).intValue() == values.get(j)) {
                            isOnlyOnce = false;
                            break;
                        }
                    }
                    if (isOnlyOnce) {
                        break;
                    } else {
                        res++;
                        values.set(i, values.get(i) - 1);
                    }
                }
            }
            return res;
        }
    }

}
