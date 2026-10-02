class Solution {
    public void backtrack(int depth, int balance, int n, ArrayList<String> path, ArrayList<String> result) {
        if (depth < n) {
            path.add("(");
            backtrack(depth + 1, balance + 1, n, path, result);
            path.removeLast();
        }
        if (balance > 0) {
            path.add(")");
            backtrack(depth, balance - 1, n, path, result);
            path.removeLast();
        }
        if (balance == 0 && depth == n) {
            result.add(String.join("", path));
        }
    }


    public List<String> generateParenthesis(int n) {
        var path = new ArrayList<String>();
        var result = new ArrayList<String>();

        backtrack(0, 0, n, path, result);

        return result;
    }
}