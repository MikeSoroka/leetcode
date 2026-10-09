class Solution {
    private static char[] s;
    private static int[][][][] memo;

    public int go(int pos, int mask, int tight, int started) {
        if (pos == s.length) return started == 1 ? 1 : 0;
        if (memo[pos][mask][tight][started] != -1) return memo[pos][mask][tight][started];

        var lim = tight == 1 ? s[pos] - '0' : 9;

        var res = 0;
        for(var i = 0; i <= lim; i++) {
            if (((mask >>> i) & 1) == 0) {
                int nextMask = mask;
                if (i != 0 || started == 1) nextMask += (1 << i);
                res += go(pos + 1, nextMask, (tight == 1) && (i == lim) ? 1 : 0, (started == 1) || (i != 0) ? 1 : 0);
            }
        }

        memo[pos][mask][tight][started] = res;
        return res;
     }


    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        memo = new int[s.length][1024][2][2];
        for(var a: memo) for(var b: a) for(var c: b) Arrays.fill(c, -1);

        return go(0, 0, 1, 0);
    }
}