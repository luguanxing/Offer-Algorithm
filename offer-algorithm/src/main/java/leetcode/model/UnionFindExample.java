package leetcode.model;

import java.util.Arrays;

public class UnionFindExample {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(6);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(4, 5);
        System.out.println(unionFind.isConnected(1, 2));
        System.out.println(unionFind.isConnected(1, 3));
        System.out.println(unionFind.isConnected(1, 4));
        System.out.println(unionFind.isConnected(4, 5));
        System.out.println(Arrays.toString(unionFind.parent));
        System.out.println(Arrays.toString(unionFind.weight));
    }

    // 路径压缩并查集实现
    static class UnionFind {
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
            // 直接合并效率不高
            // for (int i = 0; i < parent.length; i++) {
            //     if (parent[i] == parent1) {
            //         parent[i] = parent2;
            //     }
            // }
            // 按重量合并
            if (weight[parent1] > weight[parent2]) {
                parent[parent2] = parent1;
                weight[parent1] += weight[parent2];
            } else {
                parent[parent1] = parent2;
                weight[parent2] += weight[parent1];
            }
        }
    }

}
