class Solution {
    public boolean checkValidString(String s) {
        int maxBalance = 0, minBalance = 0;

        for (var i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(' -> {
                    maxBalance ++;
                    minBalance ++;
                }
                case ')' -> {
                    maxBalance --;
                    if (minBalance > 0) minBalance --;

                    if (maxBalance < 0) return false;
                }
                case '*' -> {
                    if (minBalance > 0) minBalance --;
                    maxBalance++;
                }
            }
        }

        return minBalance == 0;
    }
}