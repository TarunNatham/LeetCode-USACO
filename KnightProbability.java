class Solution {
    HashMap <String, Double> memo = new HashMap<String, Double>();
    public double knightProbability(int n, int k, int row, int column) {
        if(n == 0) {
            return 0;
        }
        if(k == 0) {
            return 1;
        }
        return knightMoves(n, k, 0, row, column)/Math.pow(8, k);
    }
    public double knightMoves(int n, int k, int moves, int row, int column) {
        String s = String.valueOf(row) + "," + String.valueOf(column) + "," + String.valueOf(moves);
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if((row >= n || column >= n) || (row < 0 || column < 0)) {
            return 0;
        }
        if((row < n && column < n) && (row >= 0 && column >= 0) && moves == k) {
            return 1;
        }
        memo.put(s, knightMoves(n, k, moves + 1, row + 1, column + 2) + knightMoves(n, k, moves + 1, row + 2, column + 1) + knightMoves(n, k, moves + 1, row + 2, column - 1) + knightMoves(n, k, moves + 1, row + 1, column - 2) + knightMoves(n, k, moves + 1, row - 1, column - 2) + knightMoves(n, k, moves + 1, row - 2, column - 1) + knightMoves(n, k, moves + 1, row - 2, column + 1) + knightMoves(n, k, moves + 1, row - 1, column + 2));
        return memo.get(s);
    }
}