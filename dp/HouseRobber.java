import java.util.*;
public class HouseRobber {
    public static int rob(int[] nums) {
            int []dp = new int[nums.length];
            Arrays.fill(dp,-1);
            return solve4(nums,dp);
    }
    public static int solve( int i,int []a) {
        if(i == 0)return a[i];

        if(i < 0)return 0;

        int pick = a[i] + solve(i-2,a);
        int notPick = 0 + solve(i-1,a);

        return Math.max(pick,notPick);

    }
    public static int solve2( int i,int []a,int []dp) {
        if(i == 0)return a[i];

        if(i < 0)return 0;

        if(dp[i] != -1)return dp[i];
        int pick = a[i] + solve2(i-2,a,dp);
        int notPick = 0 + solve2(i-1,a,dp);

        return dp[i] = Math.max(pick,notPick);

    }
    public static int solve3(int []a,int []dp) {
        
        dp[0] = a[0];
        for(int i = 1; i<a.length; i++)
        { 
            int pick = a[i];
            if(i > 1)
            {
                pick+=dp[i-2];
            }
            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick,notPick);
        }
        return dp[a.length-1];
    }

    public static int solve4(int []a,int []dp) {
        
        int p = 0,q = a[0];
        for(int i = 1; i<a.length; i++)
        { 
            int pick = a[i];
            if(i > 1)
            {
                pick+=p;
            }
            int notPick = 0 + q;

            int cur = Math.max(pick,notPick);
            p = q;

            q = cur;
        }
        return q;
    }
    public static void main(String []args)
    {
        int []a = {1,2,3,1};
        System.out.println(rob(a));
    }
}
