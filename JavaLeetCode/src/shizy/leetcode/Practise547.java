package shizy.leetcode;

/*
 * There are N students in a class. Some of them are friends, while some are not. Their friendship
 * is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C,
 * then A is an indirect friend of C. And we defined a friend circle is a group of students who are
 * direct or indirect friends.
 * 
 * Example 1:
 * Input: 
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
 *              The 2nd student himself is in a friend circle. So return 2.
 * 
 * Example 2:
 * Input: 
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
 *              so the 0th and 2nd students are indirect friends. All of them are in the same friend
 *              circle, so return 1.
 */

public class Practise547 {
    public static void main(String[] args) {
        Practise547 p = new Practise547();

        int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(p.findCircleNum(M));
    }

    // DFS (simlar Practise200)
    /*
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];

        int groups = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                groups += 1;
            }
        }

        return groups;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < M.length; j++) {
            assert (M[i][j] == M[j][i]);
            if (!visited[j] && M[i][j] == 1)
                dfs(M, visited, j);
        }
    }
    */

    // https://blog.csdn.net/dm_vincent/article/details/7655764
    class UnionFind {
        private int count = 0;
        private int[] parent; // parent[i] = parent of i
        private int[] rank; // rank[i] = rank of subtree rooted at i

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];  // path compression by halving
                p = parent[p];
            }

            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            // balanced tree
            if (rank[rootP] < rank[rootQ])
                parent[rootP] = rootQ;
            else if (rank[rootP] > rank[rootQ])
                parent[rootQ] = rootP;
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }

            count--;
        }

        public int count() {
            return count;
        }
    }

    // Union Find
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (M[i][j] == 1)
                    uf.union(i, j);

        return uf.count();
    }
}