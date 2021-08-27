package leetcode.problems;

import java.util.*;

public class Test0295_数据流的中位数 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {
        PriorityQueue<Integer> maxQueue;
        PriorityQueue<Integer> minQueue;

        public MedianFinder() {
            // 最大堆 5,4,3,2,1
            maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            // 最小堆 6,7,8,9,10
            minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        }

        public void addNum(int num) {
            // 较大的数放到小堆中，较小的数放到大堆中
            if (minQueue.isEmpty() || minQueue.peek() <= num) {
                minQueue.add(num);
                if (minQueue.size() > maxQueue.size() + 1) {
                    maxQueue.add(minQueue.poll());
                }
            } else {
                maxQueue.add(num);
                if (maxQueue.size() > minQueue.size() + 1) {
                    minQueue.add(maxQueue.poll());
                }
            }
        }

        public double findMedian() {
            if ((minQueue.size() + maxQueue.size()) % 2 == 0) {
                return (minQueue.peek() + maxQueue.peek()) * 0.5;
            } else {
                if (minQueue.size() > maxQueue.size()) {
                    return minQueue.peek();
                } else {
                    return maxQueue.peek();
                }
            }
        }
    }

}
