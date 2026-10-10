class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
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