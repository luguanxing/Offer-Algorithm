package leetcode.problems;

import java.util.*;

public class Test2092_找出知晓秘密的所有专家 {

    public static void main(String[] args) {
        // n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
        System.out.println(
                new Solution().findAllPeople(6,
                        new int[][]{
                                {1, 2, 5},
                                {2, 3, 8},
                                {1, 5, 10}
                        }, 1)
        );
        // n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
        System.out.println(
                new Solution().findAllPeople(4,
                        new int[][]{
                                {3, 1, 3},
                                {1, 2, 2},
                                {0, 3, 3}
                        }, 3)
        );
        // n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
        System.out.println(
                new Solution().findAllPeople(5,
                        new int[][]{
                                {3, 4, 2},
                                {1, 2, 1},
                                {2, 3, 1}
                        }, 1)
        );
        // n = 5, meetings = [[1,4,3],[0,4,3]], firstPerson = 3
        System.out.println(
                new Solution().findAllPeople(5,
                        new int[][]{
                                {1, 4, 3},
                                {0, 4, 3}
                        }, 3)
        );
    }

    static class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            // 先按照会议开始时间对会议进行分组
            TreeMap<Integer, List<int[]>> timeMeetingsMap = new TreeMap<>();
            for (int[] meeting : meetings) {
                int time = meeting[2];
                timeMeetingsMap.putIfAbsent(time, new ArrayList<>());
                timeMeetingsMap.get(time).add(new int[]{meeting[0], meeting[1]});
            }
            // 扩充并查集
            UnionFind uf = new UnionFind(n);
            uf.union(firstPerson, 0);
            uf.weight[0] = Integer.MAX_VALUE / 2;
            for (List<int[]> tMeetings : timeMeetingsMap.values()) {
                // 联通当前时间段的所有人
                List<Integer> tPeople = new ArrayList<>();
                for (int[] meeting : tMeetings) {
                    uf.union(meeting[0], meeting[1]);
                    tPeople.add(meeting[0]);
                    tPeople.add(meeting[1]);
                }
                // 如果某人没有和0连通，则说明他没学到秘密，需要重制以保证持久性
                for (int person : tPeople) {
                    if (!uf.isConnected(0, person)) {
                        uf.reset(person);
                    }
                }
            }
            // 找出所有和0连通的节点
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (uf.isConnected(0, i)) {
                    list.add(i);
                }
            }
            return list;
        }

        class UnionFind {
            int[] parent;
            int[] weight;

            public UnionFind(int size) {
                parent = new int[size];
                weight = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    weight[i] = 1;
                }
            }

            public int find(int element) {
                while (element != parent[element]) {
                    parent[element] = parent[parent[element]];
                    element = parent[element];
                }
                return element;
            }

            public boolean isConnected(int element1, int element2) {
                int parent1 = find(element1);
                int parent2 = find(element2);
                return parent1 == parent2;
            }

            public void union(int element1, int element2) {
                int parent1 = find(element1);
                int parent2 = find(element2);
                // 按重量合并
                if (weight[parent1] > weight[parent2]) {
                    parent[parent2] = parent1;
                    weight[parent1] += weight[parent2];
                } else {
                    parent[parent1] = parent2;
                    weight[parent2] += weight[parent1];
                }
            }

            // 新增：重置功能
            // 当某人没有学到秘密时，将他恢复成初始状态（自己是自己的父节点）
            public void reset(int element) {
                parent[element] = element;
                weight[element] = 0;
            }
        }
    }

}
