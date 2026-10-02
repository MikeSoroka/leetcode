class Solution {
    public int countSpecialIntegers(int[] nums) {
        var map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.computeIfAbsent(num, x -> new ArrayList<Integer>()).add(i);
        }

        var res = 0;
        for (var list: map.values()) {
            var flag = false;
            if(list.size() < 3) continue;

            var dist = list.get(1) - list.get(0);
            for(int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) != dist) {
                    flag = true;
                    break;
                }
            }

            if (!flag) res += 1;
        }

        return res;
    }
}