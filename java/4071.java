class Solution {
    public int getNum(int i, String s) {
        return Character.getNumericValue(s.charAt(i));
    }

    public int dist(int a, int b, String s) {
        return Math.min(Math.abs(getNum(a, s) - getNum(b, s)), 10 - Math.abs(getNum(a, s) - getNum(b, s)));
    }

    public int minRotations(int n, String s) {
        var aug = "0" + s;
        n++;
        var res = 0;
        var economy = 0;

        for (int i = 1; i < n; i++) {
            res += dist(i - 1, i, aug);
            economy = Math.max(economy, dist(i - 1, i, aug) - dist(i -1, n - 1, aug));
        }

        return res - economy;
    }
}