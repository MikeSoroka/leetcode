class Solution {
    public boolean dfs(int start, List<List<Integer>> adj, int[] status, List<Integer> res) {
        if (status[start] == 1) return false;
        if (status[start] == 2) return true;

        status[start] = 1;

        for(var neig: adj.get(start)) {
            if (!dfs(neig, adj, status, res)) return false;
        }

        status[start] = 2;
        res.add(start);

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adj = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<Integer>());
        }

        var status = new int[numCourses];

        for (var pair: prerequisites) {
            adj.get(pair[0]).add(pair[1]);
        }

        var res = new ArrayList<Integer>(numCourses);

        for(int i = 0; i < numCourses; i++) {
            if (!dfs(i, adj, status, res)) return new int[0];
        }

        return res.stream().mapToInt(x -> x).toArray();
    }
}