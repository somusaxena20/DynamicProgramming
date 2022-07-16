public class PartitionWithGivenDiff {
    static int mod = (int)Math.pow(10,9)+7;
    public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
        int total = 0;

        for(int x : arr)
            total += x;

        if(total - d < 0 || (total-d)%2 == 1)return 0;

        int s2 = (total - d)/2;

        int [][]dp = new int [n][s2+1];

        for(int x[] : dp)
            java.util.Arrays.fill(x,-1);

        return spaceOpti(s2,arr);
	}

    public static int recursive(int ind, int sum, int []a)
    {
        if(ind == 0)
        {
            if(sum == 0 && a[0] == 0)return 2;

            if(sum == 0 || a[0] == sum)return 1;

            return 0;
        }

        int pick = 0, not = 0;
        
        if(a[ind] <= sum)
            pick = recursive(ind - 1, sum - a[ind], a);
        not = recursive(ind - 1, sum, a);

        return pick + not;
    }
    public static int memoization(int ind, int sum, int []a, int [][]dp)
    {
        if(ind == 0)
        {
            if(sum == 0 && a[0] == 0)return 2;

            if(sum == 0 || a[0] == sum)return 1;

            return 0;
        }

        if(dp[ind][sum] != -1)return dp[ind][sum];

        int pick = 0, not = 0;
        
        if(a[ind] <= sum)
            pick = memoization(ind - 1, sum - a[ind], a,dp);
        not = memoization(ind - 1, sum, a,dp);

        return dp[ind][sum] = pick + not;
    }

    public static int tabulation(int tar, int []num)
    {
        int n = num.length;

        int dp[][] = new int[n][tar+1];
        
        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick
        
        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick
        
        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){
                
                int notTaken = dp[ind-1][target];
        
                int taken = 0;
                    if(num[ind]<=target)
                        taken = dp[ind-1][target-num[ind]];
            
                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }

    public static int spaceOpti(int tar, int []a)
    {
        int n = a.length;

        int []prev = new int[tar+1];

        if(a[0] == 0)prev[0] = 2;
        else
            prev[0] = 1;
        
        if(a[0] != 0 && a[0] <= tar)prev[a[0]] = 1;

        for(int ind = 1; ind<n; ind++)
        {
            int []curr = new int[tar+1];
            for(int target = 1; target<= tar; target++)
            {
                int pick = 0,not = 0;
                if(a[ind] <= target)
                    pick = prev[target - a[ind]];
                not = prev[target];
                curr[target] = (pick + not)%((int)Math.pow(10,9)+7);
            }
            prev = curr;
        }
        return prev[tar];
    }
    public static void main(String []args)
    {
        int []a = {5, 2, 6, 4};
        System.out.println(countPartitions(a.length,3,a));
    }
}
