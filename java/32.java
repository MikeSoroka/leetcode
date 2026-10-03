class Solution {
    public int longestValidParentheses(String s) {
        var stack = new ArrayDeque<Integer>();
        var start = 0;
        var res = 0;

        for(int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (stack.isEmpty()) start = i + 1;
            else {
                stack.remove();
                res = Math.max(res, stack.isEmpty() ? i - start + 1 : i - stack.peek());
            }
        }

        return res;
    }
}