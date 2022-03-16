package leetcode.problems;

import java.util.*;

public class Test0432_全O1的数据结构 {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "leet"
    }

    static class AllOne {
        Map<String, Integer> cntMap;
        TreeMap<Integer, Set<String>> cntSetMap;

        public AllOne() {
            // 使用hashmap和treemap分别记住频率和频率排序对应的单词集合
            cntMap = new HashMap<>();
            cntSetMap = new TreeMap<>();
        }

        public void inc(String key) {
            // 更新频次
            int cnt = cntMap.getOrDefault(key, 0);
            cntMap.put(key, cnt + 1);
            // 更新频次对应set
            Set<String> oldCntSet = cntSetMap.getOrDefault(cnt, new HashSet<>());
            oldCntSet.remove(key);
            if (oldCntSet.isEmpty()) {
                cntSetMap.remove(cnt);
            }
            Set<String> newCntSet = cntSetMap.getOrDefault(cnt + 1, new HashSet<>());
            newCntSet.add(key);
            cntSetMap.put(cnt + 1, newCntSet);
        }

        public void dec(String key) {
            // 更新频次
            int cnt = cntMap.getOrDefault(key, 0);
            cntMap.put(key, cnt - 1);
            if (cntMap.get(key) <= 0) {
                cntMap.remove(key);
            }
            // 更新频次对应set
            Set<String> oldCntSet = cntSetMap.getOrDefault(cnt, new HashSet<>());
            oldCntSet.remove(key);
            if (oldCntSet.isEmpty()) {
                cntSetMap.remove(cnt);
            } else {
                cntSetMap.put(cnt, oldCntSet);
            }
            if (!cntMap.containsKey(key)) {
                return;
            }
            Set<String> newCntSet = cntSetMap.getOrDefault(cnt - 1, new HashSet<>());
            newCntSet.add(key);
            cntSetMap.put(cnt - 1, newCntSet);
        }

        public String getMaxKey() {
            if (cntMap.isEmpty()) {
                return "";
            }
            for (String word : cntSetMap.lastEntry().getValue()) {
                return word;
            }
            return "";
        }

        public String getMinKey() {
            if (cntMap.isEmpty()) {
                return "";
            }
            for (String word : cntSetMap.firstEntry().getValue()) {
                return word;
            }
            return "";
        }
    }


}
