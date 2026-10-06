class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n];
        Arrays.setAll(adj, x -> new ArrayList<>());

        for (var pair: times) adj[pair[0] - 1].add(new int[]{pair[1] - 1, pair[2]});

        var res = new int[n];
        Arrays.fill(res, -1);
        res[k - 1] = -1;

        var pq = new PriorityQueue<int[]>((arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        pq.add(new int[]{0, k - 1});

        while (!pq.isEmpty()) {
            var pair = pq.remove();
            int dist = pair[0], node = pair[1];
            if (res[node] != -1) continue;
            res[node] = dist;
            for (var neig: adj[node]) {
                if (res[neig[0]] != -1) continue;
                pq.add(new int[]{dist + neig[1], neig[0]});
            }
        }

        return Arrays.stream(res).anyMatch(val -> val == -1) ? -1 : Arrays.stream(res).reduce(Integer::max).getAsInt();
    }
}