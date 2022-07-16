public class CountSubsetEqualSum {
    public static int findWays(int num[], int tar) {

        int [][]dp = new int[num.length][tar+1];

        for(int []x : dp)
            java.util.Arrays.fill(x,-1);
        return memoization(num.length-1,1,num,dp
        );
    }

    // IN THIS THE CONSTRAINT IS B/W  (1 <= )

    // BUT WHAT IF IT IS COME FROM   (0 <= )
    
    // SO THERE WAS A PROBLEM Suppose we have {0,0,1} so the possible subset with sum 1 is 4 but 
    // it give us a count of 1
    //  because subtracting 0 with the element is as equal as not picking the element. 
    // so we have to modify the code on the base cases.

    // so base case will be for the constraint 0 

    // if(ind == 0)
    // {
        // if(sum == 0 && num[0] == 0)return 2; Because there is a 2 possible way we can subseqent it
        
        // if(sum == 0 || sum == num[0])return 1;

        // Otherwise
        // return 0;
    
    // }

    // RECURSIVE
    
    public static int recursive(int ind, int sum, int[] a) {
        if (sum == 0)
            return 1;
        if (ind == 0)
            return (a[ind] == sum) ? 1 : 0;
        int take = 0,not = 0;

        if(a[ind] <= sum)
            take = recursive(ind - 1, sum - a[ind],a);
        not = recursive(ind-1,sum,a);

        return take + not;
    }

    // MEMOIZATION

    public static int memoization(int ind, int sum, int[] a, int [][]dp) {
        if(ind == 0)
    {
        if(sum == 0 && a[0] == 0)return 2; //Because there is a 2 possible way we can subseqent it
        
        if(sum == 0 || sum == a[0])return 1;

        // Otherwise
        return 0;
    
    }

        if(dp[ind][sum] != -1)return dp[ind][sum]; 
        int take = 0,not = 0;

        if(a[ind] <= sum)
            take = memoization(ind - 1, sum - a[ind],a,dp);
        not = memoization(ind-1,sum,a,dp);

        return dp[ind][sum] = take + not;
    }

    static int tabulation(int []a, int n, int k)
    {
        int dp[][] = new int[n][k+1];
        
        for(int i = 0; i<n; i++)
            dp[i][0] = 1;
        
        if(a[0] <= k)
            dp[0][a[0]] = 1;
        
        for(int ind = 1; ind<n; ind++)
        {
            for(int s = 1; s<=k; s++)
            {
                int pick = 0,not = 0;
        
                if(a[ind] <= s)
                    pick = dp[ind - 1][s - a[ind]];
                not = dp[ind-1][s];

                dp[ind][s] = pick + not;
            }
        }
        return dp[n-1][k];
        
    }

    public static int spaceOpti(int []a, int n, int k)
    {
        int prev[] = new int[k+1];
        
        prev[0] = 1;
        
        if(a[0] <= k)
            prev[a[0]] = 1;
        
        for(int ind = 1; ind<n; ind++)
        {
            int []curr = new int[k+1];
            curr[0] = 1;
            for(int s = 1; s<=k; s++)
            {
                int pick = 0,not = 0;
        
                if(a[ind] <= s)
                    pick = prev[s - a[ind]];
                not = prev[s];

                curr[s] = pick + not;
            }
            prev = curr;
        }
        return prev[k];
    }

    

    public static void main(String[] args) {
        int[] a = {0,0,1 };
        System.out.println(findWays(a,1));
    }
}
