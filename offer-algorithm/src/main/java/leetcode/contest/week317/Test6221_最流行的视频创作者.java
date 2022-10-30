package leetcode.contest.week317;

import java.util.*;

public class Test6221_最流行的视频创作者 {

    public static void main(String[] args) {
        System.out.println(new Solution().mostPopularCreator(
                new String[]{"alice", "bob", "alice", "chris"},
                new String[]{"one", "two", "three", "four"},
                new int[]{5, 10, 5, 4}
        ));
        System.out.println(new Solution().mostPopularCreator(
                new String[]{"alice", "alice", "alice"},
                new String[]{"a", "b", "c"},
                new int[]{1, 2, 2}
        ));
    }

    static class Solution {
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
            int len = creators.length;
            Map<String, Integer> scoreMap = new HashMap<>();
            Map<String, String> idMap = new HashMap<>();
            Map<String, Integer> viewMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                String creator = creators[i];
                int view = views[i];
                String id = ids[i];
                // 更新总分
                int viewSum = scoreMap.getOrDefault(creator, 0);
                scoreMap.put(creator, viewSum + view);
                // 更新最小的id
                if (!idMap.containsKey(creator)) {
                    idMap.put(creator, id);
                    viewMap.put(creator, view);
                } else {
                    int lastView = viewMap.get(creator);
                    if (view > lastView) {
                        idMap.put(creator, id);
                        viewMap.put(creator, view);
                    } else if (view == lastView) {
                        String lastId = idMap.get(creator);
                        if (id.compareTo(lastId) < 0) {
                            idMap.put(creator, id);
                        }
                    }
                }
            }
            int maxScore = scoreMap.values().stream().max(Integer::compareTo).get();
            List<List<String>> result = new ArrayList<>();
            for (String creator : scoreMap.keySet()) {
                if (maxScore == scoreMap.get(creator)) {
                    List<String> nameAndId = new ArrayList<>();
                    nameAndId.add(creator);
                    nameAndId.add(idMap.get(creator));
                    result.add(nameAndId);
                }
            }
            return result;
        }
    }

}
