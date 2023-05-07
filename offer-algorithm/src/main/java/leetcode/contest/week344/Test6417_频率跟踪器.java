package leetcode.contest.week344;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test6417_频率跟踪器 {

    public static void main(String[] args) {
        FrequencyTracker ft1 = new FrequencyTracker();
        ft1.add(3); // 数据结构现在包含 [3]
        ft1.add(3); // 数据结构现在包含 [3, 3]
        System.out.println(ft1.hasFrequency(2)); // 返回 true ，因为 3 出现 2 次

        FrequencyTracker ft2 = new FrequencyTracker();
        ft2.add(1); // 数据结构现在包含 [1]
        ft2.deleteOne(1); // 数据结构现在为空 []
        System.out.println(ft2.hasFrequency(1)); // 返回 false ，因为数据结构为空

        FrequencyTracker ft3 = new FrequencyTracker();
        ft3.hasFrequency(2); // 返回 false ，因为数据结构为空
        ft3.add(3); // 数据结构现在包含 [3]
        System.out.println(ft3.hasFrequency(1)); // 返回 true ，因为 3 出现 1 次
    }

    static class FrequencyTracker {
        Map<Integer, Integer> numCntMap = new HashMap<>();
        Map<Integer, Set<Integer>> cntSetMap = new HashMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            int oldCnt = numCntMap.getOrDefault(number, 0);
            int newCnt = oldCnt + 1;
            numCntMap.put(number, newCnt);
            cntSetMap.getOrDefault(oldCnt, new HashSet<>()).remove(number);
            Set<Integer> set = cntSetMap.getOrDefault(newCnt, new HashSet<>());
            set.add(number);
            cntSetMap.put(newCnt, set);
        }

        public void deleteOne(int number) {
            if (!numCntMap.containsKey(number)) {
                return;
            }
            int oldCnt = numCntMap.get(number);
            int newCnt = oldCnt - 1;
            if (newCnt == 0) {
                numCntMap.remove(number);
                cntSetMap.get(oldCnt).remove(number);
            } else {
                numCntMap.put(number, newCnt);
                cntSetMap.getOrDefault(oldCnt, new HashSet<>()).remove(number);
                Set<Integer> set = cntSetMap.getOrDefault(newCnt, new HashSet<>());
                set.add(number);
                cntSetMap.put(newCnt, set);
            }
        }

        public boolean hasFrequency(int frequency) {
            return !cntSetMap.getOrDefault(frequency, new HashSet<>()).isEmpty();
        }
    }

}
