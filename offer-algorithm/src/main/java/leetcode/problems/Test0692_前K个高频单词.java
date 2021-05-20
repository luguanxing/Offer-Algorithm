package leetcode.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test0692_前K个高频单词 {

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(
                new String[]{"i", "love", "leetcode", "i", "love", "coding"},
                2
        ));
        System.out.println(new Solution().topKFrequent(
                new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                4
        ));
    }

    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            return Arrays.stream(words)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((o1, o2) -> {
                        if (o1.getValue().equals(o2.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        } else {
                            return o2.getValue().compareTo(o1.getValue());
                        }
                    })
                    .map(Map.Entry::getKey)
                    .limit(k)
                    .collect(Collectors.toList());
        }
    }

    static class Solution_手动 {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String s : words) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            List<Pair> list = new ArrayList<>();
            for (String word : map.keySet()) {
                int count = map.get(word);
                list.add(new Pair(word, count));
            }
            Collections.sort(list, (o1, o2) -> {
                if (o1.count.equals(o2.count)) {
                    return o2.word.compareTo(o1.word);
                } else {
                    return Integer.compare(o1.count, o2.count);
                }
            });
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                res.add(list.get(list.size() - i).word);
            }
            return res;
        }

        static class Pair {
            String word;
            Integer count;

            public Pair(String word, Integer count) {
                this.word = word;
                this.count = count;
            }
        }
    }

}
