class Solution {
    private int[] parent;
    private int[] height;

    public int getParent(int a) {
        if (parent[a] != a) parent[a] = getParent(parent[a]);
        return parent[a];
    }

    public boolean union(int a, int b) {
        int parA = getParent(a), parB = getParent(b);
        if (parA == parB) return false;

        if (height[parA] > height[parB]) {
            int temp = parA; parA = parB; parB = temp;
        }

        parent[parA] = parB;
        height[parB] = Math.max(height[parA] + 1, height[parB]);

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        var n = edges.length;
        parent = new int[n + 1];
        Arrays.setAll(parent, i -> i);
        height = new int[n + 1];

        for(var e: edges) if (!union(e[0], e[1])) return e;

        return new int[0];
    }
}