package leetcode.problems;

import java.util.*;

public class Test1146_快照数组 {

    public static void main(String[] args) {
        SnapshotArray snapshotArr1 = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
        snapshotArr1.set(0, 5);  // 令 array[0] = 5
        System.out.println(snapshotArr1.snap());  // 获取快照，返回 snap_id = 0
        snapshotArr1.set(0, 6);
        System.out.println(snapshotArr1.get(0, 0));  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
        System.out.println(snapshotArr1.get(0, 1));  // 获取 snap_id = 1 的快照中 array[0] 的值，返回 6
        System.out.println();

        // ["SnapshotArray","set","set","set","snap","get","snap"]
        //[[1],[0,4],[0,16],[0,13],[],[0,0],[]]
        SnapshotArray snapshotArr2 = new SnapshotArray(1);
        snapshotArr2.set(0, 4);
        snapshotArr2.set(0, 16);
        snapshotArr2.set(0, 13);
        System.out.println(snapshotArr2.snap());
        System.out.println(snapshotArr2.get(0, 0));
        System.out.println(snapshotArr2.snap());
        System.out.println();

        // ["SnapshotArray","set","snap","snap","snap","get","snap","snap","get"]
        //[[1],[0,15],[],[],[],[0,2],[],[],[0,0]]
        SnapshotArray snapshotArr3 = new SnapshotArray(1);
        snapshotArr3.set(0, 15);
        System.out.println(snapshotArr3.snap());
        System.out.println(snapshotArr3.snap());
        System.out.println(snapshotArr3.snap());
        System.out.println(snapshotArr3.get(0, 2));
        System.out.println(snapshotArr3.snap());
        System.out.println(snapshotArr3.snap());
        System.out.println(snapshotArr3.get(0, 0));
        System.out.println();

        // ["SnapshotArray","snap","get","get","set","get","set","get","set"]
        //[[2],[],[1,0],[0,0],[1,8],[1,0],[0,20],[0,0],[0,7]]
        SnapshotArray snapshotArr4 = new SnapshotArray(2);
        System.out.println(snapshotArr4.snap());
        System.out.println(snapshotArr4.get(1, 0));
        System.out.println(snapshotArr4.get(0, 0));
        snapshotArr4.set(1, 8);
        System.out.println(snapshotArr4.get(1, 0));
        snapshotArr4.set(0, 20);
        System.out.println(snapshotArr4.get(0, 0));
        snapshotArr4.set(0, 7);
        System.out.println();

        // ["SnapshotArray","set","set","snap","get","set","snap","set","set","get","get"]
        // [[3],[1,18],[1,4],[],[0,0],[0,20],[],[0,2],[1,1],[1,1],[1,0]]
        SnapshotArray snapshotArr5 = new SnapshotArray(3);
        snapshotArr5.set(1, 18);
        snapshotArr5.set(1, 4);
        System.out.println(snapshotArr5.snap());
        System.out.println(snapshotArr5.get(0, 0));
        snapshotArr5.set(0, 20);
        System.out.println(snapshotArr5.snap());
        snapshotArr5.set(0, 2);
        snapshotArr5.set(1, 1);
        System.out.println(snapshotArr5.get(1, 1));
        System.out.println(snapshotArr5.get(1, 0));
    }

    static class SnapshotArray {
        // key为index，value为该index变动的情况map（key为snap_id，value为值）
        Map<Integer, TreeMap<Integer, Integer>> indexMap = new HashMap<>();
        int sid;

        public SnapshotArray(int length) {
            sid = 0;
            for (int i = 0; i < length; i++) {
                indexMap.put(i, new TreeMap<>());
            }
        }

        public void set(int index, int val) {
            TreeMap<Integer, Integer> sidMap = indexMap.get(index);
            sidMap.put(sid, val);
        }

        public int snap() {
            return sid++;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> sidMap = indexMap.get(index);
            if (sidMap.isEmpty()) {
                return 0;
            }
            Integer key = sidMap.floorKey(snap_id);
            return key == null ? 0 : sidMap.get(key);
        }
    }

    static class SnapshotArray_TLE {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int sid;

        public SnapshotArray_TLE(int length) {
            sid = 0;
            for (int i = 0; i < length; i++) {
                map.put(i, new ArrayList<>());
            }
        }

        public void set(int index, int val) {
            List<int[]> list = map.get(index);
            boolean isExist = false;
            for (int[] sidVal : list) {
                if (sidVal[0] == sid) {
                    sidVal[1] = val;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                list.add(new int[]{sid, val});
            }
            map.put(index, list);
        }

        public int snap() {
            return sid++;
        }

        public int get(int index, int snap_id) {
            List<int[]> list = map.get(index);
            if (list.isEmpty()) {
                return 0;
            }
            int lastSid = 0;
            int lastVal = 0;
            for (int[] sidVal : list) {
                if (sidVal[0] > snap_id) {
                    break;
                }
                lastSid = sidVal[0];
                lastVal = sidVal[1];
                if (sidVal[0] == snap_id) {
                    return sidVal[1];
                }
            }
            return lastSid <= snap_id ? lastVal : 0;
        }
    }

}
