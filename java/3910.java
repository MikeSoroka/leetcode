class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        var res = 0;
        var n = nums.length;
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, row -> new ArrayList<Integer>());

        for (var e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        var maxMask = 1 << n;
        for(var mask = 1; mask < maxMask; mask++) {
            var score = 0;
            for (int i = 0; i < n; i++) score += ((mask >> i) & 1) * nums[i];

            if (score % 2 == 1) continue;

            var q = new ArrayDeque<Integer>();
            var visited = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) continue;
                q.add(i);
                break;
            }

            while (!q.isEmpty()) {
                var last = q.poll();
                if (visited.contains(last)) continue;
                visited.add(last);

                for(var neig: adj[last]) {
                    if (((mask >> neig) & 1) == 0) continue;
                    q.add(neig);
                }
            }

            if (visited.size() == Integer.bitCount(mask)) res ++;
        }

        return res;
    }
}