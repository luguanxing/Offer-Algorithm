package offer;

public class P1551_亲戚 {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        System.out.println(uf.isConnected(1, 2));
        System.out.println(uf.isConnected(1, 3));
        System.out.println(uf.isConnected(1, 4));
        System.out.println(uf.isConnected(4, 5));
        System.out.println(uf.isConnected(5, 6));
    }

    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (size[pRoot] >= size[qRoot]) {
                // pRoot更重，把qRoot挂到pRoot
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                // qRoot更重，把pRoot挂到qRoot
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
        }

        public boolean isConnected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]; // 将子节点向上移动
                x = parent[x];
            }
            return x;
        }
    }

    static class UnionFind_简单版 {
        int[] parent;

        public UnionFind_简单版(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            parent[pRoot] = qRoot;
        }

        public boolean isConnected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        private int findRoot(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
    }

}
