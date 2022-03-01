class Solution {
    HashMap<String, Integer> memo = new HashMap<String, Integer>();
    public int uniquePaths(int m, int n) {
        String s = String.valueOf(m) + ","  + String.valueOf(n);
        String s2 = String.valueOf(n) + ","  + String.valueOf(m);
        if(memo.containsKey(s) || memo.containsKey(s2)) {
            if(memo.containsKey(s)) {
                return memo.get(s);
            } else {
                return memo.get(s2);
            }
        }
        if(m == 0 || n == 0) {
            return 0;
        }
        if(m == 1 && n == 1) {
            return 1;
        }
        memo.put(s, uniquePaths(m - 1, n) + uniquePaths(m, n - 1));
        return memo.get(s);
    }
}