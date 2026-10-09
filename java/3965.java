class Solution {
    public long finish(List<Integer>[] adj, int parent, int node, int[] baseTime, HashMap<Integer, Long> memo) {
        if (adj[node].size() == 1 && parent != -1) return baseTime[node];
        if (memo.containsKey(node)) return memo.get(node);
        long latest = 0, earliest = Long.MAX_VALUE;
        for (var neig: adj[node]) {
            if (neig != parent) {
                earliest = Math.min(earliest, finish(adj, node, neig, baseTime, memo));
                latest = Math.max(latest, finish(adj, node, neig, baseTime, memo));
            }
        }

        memo.put(node, latest + (latest - earliest) + baseTime[node]);
        return latest + (latest - earliest) + baseTime[node];
    }

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        if (n == 1) return (long) baseTime[0];
        List<Integer>[] adj = new ArrayList[n];
        Arrays.setAll(adj, row -> new ArrayList<Integer>());
        for(var e: edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        return finish(adj, -1, 0, baseTime, new HashMap<Integer, Long>());
    }
}