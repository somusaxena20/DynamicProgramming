import java.util.*;

// import java.util.List;

public class SubsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.

        int dp[][] = new int[n][k + 1];
        for (int row[] : dp)
            java.util.Arrays.fill(row, -1);
        return tabulation(n, k, arr);
    }

    public static boolean recursive(int ind, int target, int[] a) {
        if (target == 0)
            return true;

        if (ind == 0)
            return (a[0] == target) ? true : false;

        boolean pick = false;
        if (a[ind] <= target)
            pick = recursive(ind - 1, target - a[ind], a);

        boolean not = recursive(ind - 1, target, a);
        return pick | not;
    }

    // MEMOIZATION

    public static boolean memoization(int ind, int target, int[] a, int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return (a[0] == target) ? true : false;

        if (dp[ind][target] != -1) {
            return (dp[ind][target] == 0) ? true : false;
        }
        boolean pick = false;
        if (a[ind] <= target)
            pick = memoization(ind - 1, target - a[ind], a, dp);

        boolean not = memoization(ind - 1, target, a, dp);

        dp[ind][target] = (pick | not) ? 0 : 1;

        return pick | not;
    }

    // TABULATION

    public static boolean tabulation(int n, int k, int[] a) {
        boolean dp[][] = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(a[0]<=k)
            dp[0][a[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (a[ind] <= target)
                    pick = dp[ind - 1][target - a[ind]];

                boolean not = dp[ind - 1][target];

                dp[ind][target] = pick || not;
            }
        }
        return dp[n-1][k];

    }

    public static boolean spaceOpti(int n, int k, int []a)
    {
        boolean []prev = new boolean[k+1];
        prev[0] = true;
        

        if(a[0]<=k)
            prev[a[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean []curr = new boolean[k+1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (a[ind] <= target)
                    pick = prev[target - a[ind]];

                boolean not = prev[target];

                curr[target] = pick || not;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static boolean spaceOpti2(int n, int k, int []a)
    {
        boolean []prev = new boolean[k+1];
        prev[0] = true;
        

        if(a[0]<=k)
            prev[a[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean []curr = new boolean[k+1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (a[ind] <= target)
                    pick = prev[target - a[ind]];

                boolean not = prev[target];

                curr[target] = pick || not;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String[] args) {
        int[] a = {1,3,2 };
        Date d = new Date();
        System.out.println(subsetSumToK(a.length, 4, a));
        Date d1 = new Date();
        System.out.println("   " + (d1.getTime() - d.getTime()) + "ms");
    }
}
