class Solution {
    public long maxEarnings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));
        long res = 0;

        var dp = new TreeMap<Integer, Long>();
        for(var meeting: meetings) {
            var s = meeting[0];
            var e = meeting[1];
            var c = meeting[2];
            if (dp.isEmpty()) {
                dp.put(e, (long)c);
                res = Math.max(res, (long) c);
                continue;
            }

            var bestStartKey = dp.floorKey(s);
            var bestEndKey = dp.floorKey(e);

            dp.merge(e, Math.max(
                    bestEndKey == null ? 0 : (long) dp.get(bestEndKey) + (e - bestEndKey),
                    bestStartKey == null ? c : (long) dp.get(bestStartKey) + (s - bestStartKey) + c
                ), Long::max);

            res = Math.max(res, bestStartKey == null ? (long)c : (long) dp.get(bestStartKey) + (s - bestStartKey) + c);
        }

        return res;
    }
}