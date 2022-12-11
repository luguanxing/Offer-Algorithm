package leetcode.contest.week323;

import java.util.Arrays;

public class Test6259_设计内存分配器 {

    public static void main(String[] args) {
        Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
        System.out.println(loc.allocate(1, 2)); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        System.out.println(loc.allocate(1, 3)); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        System.out.println(loc.free(2)); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        System.out.println(loc.allocate(3, 4)); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        System.out.println(loc.allocate(1, 1)); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        System.out.println(loc.free(1)); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        System.out.println(loc.allocate(10, 2)); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        System.out.println(loc.free(7)); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。z
    }

    static class Allocator {
        int totalSize;
        int[] map;

        public Allocator(int n) {
            totalSize = n;
            map = new int[n];
        }

        public int allocate(int size, int mID) {
            int used = 0;
            for (int i = 0; i < totalSize; i++) {
                if (map[i] == 0) {
                    used++;
                } else {
                    used = 0;
                }
                if (used == size) {
                    // 分配从map[i+1-size, i]
                    Arrays.fill(map, i + 1 - size, i + 1, mID);
                    return i + 1 - size;
                }
            }
            return -1;
        }

        public int free(int mID) {
            int removed = 0;
            for (int i = 0; i < totalSize; i++) {
                if (map[i] == mID) {
                    removed++;
                    map[i] = 0;
                }
            }
            return removed;
        }
    }

}
