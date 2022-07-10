package leetcode.contest.week301;

import java.util.TreeSet;

public class Test6113_无限集中的最小数字 {

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 2 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
        smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 4 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。
    }

    static class SmallestInfiniteSet {
        TreeSet<Integer> treeSet;

        public SmallestInfiniteSet() {
            treeSet = new TreeSet<>();
            for (int i = 1; i <= 1000; i++) {
                treeSet.add(i);
            }
        }

        public int popSmallest() {
            Integer smallest = treeSet.first();
            treeSet.remove(smallest);
            return smallest;
        }

        public void addBack(int num) {
            treeSet.add(num);
        }
    }


}
