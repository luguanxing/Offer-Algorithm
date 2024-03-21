package leetcode.problems;

import java.util.*;

public class Test2671_频率跟踪器 {

    public static void main(String[] args) {
        // ["FrequencyTracker","hasFrequency","add","hasFrequency","hasFrequency","add","add","add","deleteOne","deleteOne","hasFrequency","add","hasFrequency","hasFrequency"]
        // [[],[1],[3],[1],[1],[6],[2],[6],[6], [6],[2],[2],[2],[1]]
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(1));
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.add(6);
        frequencyTracker.add(2);
        frequencyTracker.add(6);
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(6);
        System.out.println(frequencyTracker.hasFrequency(2));
        frequencyTracker.add(2);
        System.out.println(frequencyTracker.hasFrequency(2));
        System.out.println(frequencyTracker.hasFrequency(1));
    }

    static class FrequencyTracker {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        Map<Integer, Integer> freqCntMap = new HashMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            // 先改freqCntMap，再改numFreqMap
            int freq = numFreqMap.getOrDefault(number, 0);
            freqCntMap.put(freq, freqCntMap.getOrDefault(freq, 0) - 1);
            if (freqCntMap.get(freq) <= 0) {
                freqCntMap.remove(freq);
            }
            freqCntMap.put(freq + 1, freqCntMap.getOrDefault(freq + 1, 0) + 1);
            numFreqMap.put(number, numFreqMap.getOrDefault(number, 0) + 1);
        }

        public void deleteOne(int number) {
            if (!numFreqMap.containsKey(number)) {
                return;
            }
            // 先改freqCntMap，再改numFreqMap
            int freq = numFreqMap.get(number);
            freqCntMap.put(freq, freqCntMap.get(freq) - 1);
            if (freqCntMap.get(freq) <= 0) {
                freqCntMap.remove(freq);
            }
            if (freq - 1 > 0) {
                freqCntMap.put(freq - 1, freqCntMap.getOrDefault(freq - 1, 0) + 1);
            }
            numFreqMap.put(number, numFreqMap.get(number) - 1);
            if (numFreqMap.get(number) <= 0) {
                numFreqMap.remove(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return freqCntMap.containsKey(frequency);
        }
    }


}
