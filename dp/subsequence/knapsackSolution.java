public class knapsackSolution {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];

        for (int[] x : dp) {
            java.util.Arrays.fill(x, -1);
        }
        return spaceOpti( weight,value,n,maxWeight);
    }

    static int recursive(int ind, int[] w, int[] v, int m) {
        if (ind == 0) {
            if (w[0] <= m)
                return v[0];
            else
                return 0;
        }

        int pick = Integer.MIN_VALUE;

        if (w[ind] <= m)
            pick = v[ind] + recursive(ind - 1, w, v, m - w[ind]);
        int not = 0 + recursive(ind - 1, w, v, m);

        return Math.max(pick, not);
    }

    static int memoization(int ind, int[] w, int[] v, int m, int[][] dp) {
        if (ind == 0) {
            if (w[0] <= m)
                return v[0];
            else
                return 0;
        }
        if (dp[ind][m] != -1)
            return dp[ind][m];
        int pick = Integer.MIN_VALUE;

        if (w[ind] <= m)
            pick = v[ind] + memoization(ind - 1, w, v, m - w[ind], dp);
        int not = 0 + memoization(ind - 1, w, v, m, dp);

        return dp[ind][m] = Math.max(pick, not);
    }

    public static int tabulation(int[] w, int[] v, int n, int m) {
        int[][] dp = new int[n][m + 1];

        // for (int[] x : dp) {
        //     java.util.Arrays.fill(x, 0);
        // }

        for (int i = w[0]; i <= m; i++) {
            dp[0][i] = v[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= m; target++) {
                int pick = Integer.MIN_VALUE;

                if (w[ind] <= target)
                    pick = v[ind] + dp[ind - 1][target - w[ind]];
                int not = 0 + dp[ind - 1][target];

                dp[ind][target] = Math.max(pick, not);
            }
        }
        return dp[n-1][m];
    }

    public static int spaceOpti(int[] w, int[] v, int n, int m) {
        int []prev = new int[m+1];

        for (int i = w[0]; i <= m; i++) {
            prev[i] = v[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int []curr = new int[m+1];
            for (int target = 0; target <= m; target++) {
                int pick = Integer.MIN_VALUE;

                if (w[ind] <= target)
                    pick = v[ind] + prev[target - w[ind]];
                int not = 0 + prev[target];

                curr[target] = Math.max(pick, not);
            }
            prev = curr;
        }
        return prev[m];
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5 };
        int[] b = { 5, 4, 8, 6 };
        System.out.println(knapsack(a, b, a.length, 5));
    }
}
