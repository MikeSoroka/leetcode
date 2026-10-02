class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        var set = new HashSet<Integer>();
        for (var num: nums) {
            set.add(num);
        }
        int res = 1, counter = 1;
        for (var num: set) {
            if (set.contains(num - 1)) continue;
            counter = 0;
            while (set.contains(num + counter)) {
                counter ++;
            }

            res = Math.max(res, counter);
        }


        return res;
    }
}