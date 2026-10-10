class Solution {
    public int minimumXORSum(int n, int[] graph) {
        List<int[]>[] adj = new List[n];
        Arrays.setAll(adj, row -> new ArrayList<int[]>(n));

        for (var edge: graph) {
            adj[e[0]].add(new int[] {edge[1], edge[2]})
        }


        var INF = Integer.MAX_VALUE / 2;
        int numCombs = 1 << nums2.length, n = nums1.length;
        int[] dp = new int[numCombs];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(var i = 0; i < numCombs; i++) {
            for(var j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) dp[i] = Math.min(dp[i], dp[i & ~(1 << j)] + (nums1[Integer.bitCount(i) - 1] ^ nums2[j]));
            }
        }

        return dp[numCombs - 1];
    }
}