class Solution {

    public int scoreOfParentheses(String s) {
        var stack = new ArrayDeque<Integer>();
        var res = 0;

        for(var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(0);
            else {
                var last = stack.remove();
                var score = last == 0 ? 2 : last * 2;

                if (stack.isEmpty()) res += score / 2;
                else stack.push(stack.remove() + score);
            }
        }

        return res;
    }
}