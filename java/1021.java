class Solution {
    public String removeOuterParentheses(String s) {
        var balance = 0;
        var sb = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> {
                    if (balance++ > 0) sb.append('(');
                }
                case ')' -> {
                    if (balance-- > 1) sb.append(')');
                }
            }
        }

        return sb.toString();
    }
}