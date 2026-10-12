class Solution {
    public boolean validDigit(int n, int x) {
        var arr = String.valueOf(n).toCharArray();
        var c = (char) (x + '0');

        if (arr[0] == c) return false;
        for (var ch: arr) if (ch == c) return true;

        return false;
    }
}