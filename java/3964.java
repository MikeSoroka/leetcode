class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        var unlightedL = new HashSet<Integer>();

        var latest = -1;
        for(var i = 0; i < n; i++) {
            if(lights[i] != 0) latest = Math.max(latest, lights[i] + i);
            if (i > latest) unlightedL.add(i);
        }

        var unlightedE = new HashSet<Integer>();

        var earliest = n;
        for(var i = n - 1; i >= 0; i--) {
            if(lights[i] != 0) earliest = Math.min(earliest, i - lights[i]);
            if (i < earliest) unlightedE.add(i);
        }

        var unlightedGrouped = new ArrayList<int[]>();

        for(var i = 0; i < n; i++) {
            if (unlightedE.contains(i) && unlightedL.contains(i)) {
                if (!unlightedGrouped.isEmpty() && unlightedGrouped.getLast()[1] + 2 >= i) {
                    unlightedGrouped.set(unlightedGrouped.size() - 1, new int[]{unlightedGrouped.getLast()[0], i});
                }
                else {
                    unlightedGrouped.add(new int[]{i, i});
                }
            }
        }

        return unlightedGrouped.stream().mapToInt(pair -> 1 + (pair[1] - pair[0]) / 3).sum();
    }
}