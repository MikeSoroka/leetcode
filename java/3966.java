class Solution {
    private int diff;

    public long go(int pos, int last, int tight, int started, char[] s, long[][][][] memo) {
        if (pos == s.length) return (long) started;
        if (memo[pos][last][tight][started] != -1) return memo[pos][last][tight][started];

        var limLow = 0;
        var limHigh = tight == 1 ? s[pos] - '0' : 9;
        if (started == 1) {
            limLow = Math.max(limLow, last - diff);
            limHigh = Math.min(limHigh, last + diff);
        }

        long res = 0;
        for(var dig = limLow; dig <= limHigh; dig++) {
            var nt = ((tight == 1) && (dig == s[pos] - '0')) ? 1 : 0;
            var ns = ((started == 1) || dig != 0) ? 1 : 0;
            res += go(pos + 1, dig, nt, ns, s, memo);
        }

        memo[pos][last][tight][started] = res;
        return res;
    }

    public long goodIntegers(long l, long r, int k) {
        diff = k;
        var s = String.valueOf(r).toCharArray();
        var memo = new long[s.length][10][2][2];
        for (var a: memo) for (var b: a) for(var c: b) Arrays.fill(c, -1);
        var goR = go(0, 0, 1, 0, s, memo);

        s = String.valueOf(l - 1).toCharArray();
        memo = new long[s.length][10][2][2];
        for (var a: memo) for (var b: a) for(var c: b) Arrays.fill(c, -1);
        var goL = go(0, 0, 1, 0, s, memo);


        return goR - goL;
    }
}