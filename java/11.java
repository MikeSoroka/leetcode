class Solution {
    public int maxArea(int[] height) {
        var q = new ArrayDeque<Integer>(); // push, remove, peek
        var res = 0;


        for(int i = 0; i < height.length; i++) {
            while (!q.isEmpty() && height[q.peek()] <= height[i]) {
                var index = q.remove();
                res = Math.max(res, (i - index) * height[index]);
            }
            q.push(i);
        }

        while (q.size() > 1) {
            var index = q.remove();

            System.out.println(index);
            System.out.println(q.peek());

            res = Math.max(res, (index - q.peek()) * height[index]);
        }
        return res;
    }
}