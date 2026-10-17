class Solution {
    HashMap<Integer, Integer> digsum;

    public Integer myComp(Integer num1, Integer num2) {
        Integer count1 = digsum.get(num1), count2 = digsum.get(num2);

        if (Integer.compare(count1, count2) == 0) return Integer.compare(num1, num2);

        return Integer.compare(count1, count2);
    }

    public int minSwaps(int[] nums) {
        digsum = new HashMap<Integer, Integer>();
        var heap = new PriorityQueue<Integer>((a, b) -> myComp(a, b));
        var positions = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], cursum = 0;
            for (var d: String.valueOf(num).toCharArray()) cursum += (d - '0');
            digsum.put(num, cursum);
            positions.put(nums[i], i);
            heap.add(num);
        }

        var res = 0;

        for(int i = 0; i < nums.length; i++) {
            var minVal = heap.poll();
            if (positions.get(minVal) == i) continue;

            var num = nums[i];
            nums[positions.get(minVal)] = num;
            positions.put(num, positions.get(minVal));
            positions.put(minVal, i);

            res += 1;
        }

        return res;
    }
}