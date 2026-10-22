class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        var start = 0;
        var isFound = true;
        for (int i = 0; i < n; i++) if (nums[i] == 0) start = i;
        for (int i = 1; i < n; i ++) {
            if (nums[(start + i) % n] != i) {
                isFound = false;
                break;
            }
        }

        if (isFound) return Math.min(start, n - start + 2);

        for (int i = 1; i < n; i ++) {
            if (nums[(n + start - i) % n] != i) {
                return -1;
            }
        }

        return Math.min(start + 2, n - start);
    }
}