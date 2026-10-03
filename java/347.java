class Solution {
    public List<Integer> topK(List<Integer> nums, List<Integer> res, int k, Random r) {
        int pivot = nums.get(r.nextInt(nums.size()));
        var less = new ArrayList<Integer>();
        var eq = new ArrayList<Integer>();
        var more = new ArrayList<Integer>();

        for (var num: nums) {
            if (num < pivot) less.add(num);
            else if (num == pivot) eq.add(num);
            else more.add(num);
        }

        if (more.size() >= k) {
            return topK(more, res, k, r);
        }
        else if (more.size() + eq.size() >= k) {
            for (var m: more) {
                res.add(m);
            }
            for(int i = k - more.size(); i > 0; i--) {
                res.add(pivot);
            }

            return res;
        }
        else {
            for (var m: more) {
                res.add(m);
            }
            for(int i = eq.size(); i > 0; i--) {
                res.add(pivot);
            }

            return topK(less, res, k - eq.size() - more.size(), r);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        var counter = new HashMap<Integer, Integer>();
        var r = new Random();
        for(var num: nums) {
            counter.merge(num, 1, Integer::sum);
        }

        int lower = topK(new ArrayList<Integer>(counter.values()), new ArrayList<Integer>(), k, r).stream().reduce(Integer::min).get();

        var index = 0;
        var res = new int[k];
        for(var key: counter.keySet()) {
            if (index == k) break;
            if (counter.get(key) >= lower) res[index++] = key;
        }

        return res;
    }
}