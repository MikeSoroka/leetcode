class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        Arrays.setAll(adj, _ -> new ArrayList<int[]>());
        for (var flight: flights) {
            int from = flight[0], to = flight[1], dist = flight[2];
            adj[from].add(new int[]{to, dist});
        }

        var dists = new int[k + 2][n];
        Arrays.stream(dists).forEach(row -> Arrays.fill(row, -1));
        var pq = new PriorityQueue<int[]>(Comparator.<int[]>comparingInt(arr -> arr[0]).thenComparingInt(arr -> arr[1]));
        pq.add(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            var cur = pq.poll();
            int dist = cur[0], curK = cur[1], node = cur[2];
            if (dists[curK][node] != -1) continue;
            dists[curK][node] = dist;
            if (curK == k+1) continue;

            for (var outcoming: adj[node]) {
                int neigh  = outcoming[0], outDist = outcoming[1];
                if (dists[curK + 1][neigh] == -1) pq.add(new int[] {dist + outDist, curK+1, neigh});
            }
        }

        return Arrays.stream(dists).filter(row -> row[dst] != -1).mapToInt(row -> row[dst]).min().orElse(-1);
    }
}