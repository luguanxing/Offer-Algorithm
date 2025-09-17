package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test2349_设计数字容器系统 {

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // 没有数字 10 ，所以返回 -1 。
        nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
        nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
        nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
        nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
        System.out.println(nc.find(10)); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
        nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
        System.out.println(nc.find(10)); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
    }

    static class NumberContainers {

        Map<Integer, TreeSet<Integer>> numberIndexes = new HashMap<>();
        Map<Integer, Integer> indexNumber = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            if (indexNumber.containsKey(index)) {
                int oldNumber = indexNumber.get(index);
                numberIndexes.get(oldNumber).remove(index);
            }
            indexNumber.put(index, number);
            TreeSet<Integer> set = numberIndexes.getOrDefault(number, new TreeSet<>());
            set.add(index);
            numberIndexes.put(number, set);
        }

        public int find(int number) {
            if (!numberIndexes.containsKey(number) || numberIndexes.get(number).isEmpty()) {
                return -1;
            }
            return numberIndexes.get(number).first();
        }

    }

}
