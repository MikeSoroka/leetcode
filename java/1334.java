class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj = new ArrayList[n];
        Arrays.setAll(adj, _ -> new ArrayList<int[]>());


        for (var e: edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        var result = -1;
        var resultReachable = Integer.MAX_VALUE;

        for (var start = 0; start < n; start++) {
            var dists = new int[n];
            Arrays.fill(dists, -1);
            var pq = new PriorityQueue<int[]>(Comparator.comparingInt(arr -> arr[0]));
            pq.add(new int[] {0, start});

            outer:
            while (!pq.isEmpty()) {
                var cur = pq.poll();
                int dist = cur[0], node = cur[1];
                if (dists[node] != -1) continue;
                dists[node] = dist;

                for(var pair: adj[node]) {
                    int neig = pair[0], toNeig = pair[1];
                    if (dists[neig] == -1 && dists[node] + toNeig <= distanceThreshold) pq.add(new int[] {dists[node] + toNeig, neig});
                }
            }

            var reachable = (int) Arrays.stream(dists).filter(dist -> dist != -1).count() - 1;
            if (reachable <= resultReachable) {
                resultReachable = reachable;
                result = start;
            }
        }

        return result;
    }
}