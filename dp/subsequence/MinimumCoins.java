public class MinimumCoins {
    public static int coinChange(int[] a, int t) {
        // return f(a.length -1 , t,a);
        
        int [][]dp = new int[a.length][t+1];

        for(int []x : dp)
        {
            java.util.Arrays.fill(x,-1);
        }

        int ans = memoization(a.length-1, t, a, dp);

        if(ans >= Math.pow(10,9))
        {
            return -1;
        }
        return ans;
    }

    public static int f(int ind, int t, int []a)
    {
        if(ind == 0)
        {
            if(t % a[0] == 0)
            {
                return t / a[0];
            }
            else
            {
                return (int)Math.pow(10,9);
            }
        }


        int notTake = 0 + f(ind - 1, t, a);

        int take = (int)Math.pow(10,9);

        if(a[ind] <= t)
        {
            take = 1 + f(ind, t-a[ind], a);
        }

        return Math.min(take, notTake);
    }

    public static int memoization(int ind, int t, int []a, int [][]dp)
    {
        if(ind == 0)
        {
            if(t % a[ind] == 0)
            {
                return t / a[ind];
            }
            else
            {
                return (int)Math.pow(10,9);
            }
        }

        if(dp[ind][t] != -1)
            return dp[ind][t];

        int notTake = 0 + memoization(ind - 1, t, a,dp);

        int take = (int)Math.pow(10,9);

        if(a[ind] <= t)
        {
            take = 1 + memoization(ind, t-a[ind], a,dp);
        }

        return dp[ind][t] = Math.min(take, notTake);
    }
    public static void main(String []args)
    {
        int a[] = {0};
        int target = 1;
        System.out.println(coinChange(a,target));
    }
}
