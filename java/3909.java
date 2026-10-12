class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        long sum1 = nums[0], sum2 = 0;

        if (nums[0] > nums[1]) return 1;
        for(int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) sum1 += (long) nums[i];
            else sum2 += (long) nums[i - 1];
        }

        sum2 += (long) nums[n - 1];

        return sum1 < sum2 ? 1 : (sum1 > sum2 ? 0 : -1);
    }
}