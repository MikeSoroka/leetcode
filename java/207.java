class Solution {
    public boolean dfs(int current, Map<Integer, List<Integer>> adj, int[]status) {
        if (status[current] > 0) return true;
        if (!adj.containsKey(current)) return true;
        status[current] = 1;

        for (var neighbor: adj.get(current)) {
            if (status[neighbor] == 0) {
                if (!dfs(neighbor, adj, status)) return false;
            }
            else if (status[neighbor] == 1) {
                return false;
            }
        }

        status[current] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var status = new int[numCourses];
        var adj = new HashMap<Integer, List<Integer>>();
        for(var pair : prerequisites) {
            var from = pair[0];
            var to = pair[1];

            if(!adj.containsKey(from)) {
                adj.put(from, new ArrayList<Integer>());
            }

            if(!adj.containsKey(to)) {
                adj.put(to, new ArrayList<Integer>());
            }

            adj.get(from).add(to);
        }

        for (int i = 0; i < numCourses; i++) {
            if(status[i] == 0 && !dfs(i, adj, status)) {
                return false;
            }
        }

        return true;
    }
}