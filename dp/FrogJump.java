// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012

public class FrogJump
{
    public static int frogJump(int n, int a[]) {
		
        // RECURSIVE
        // return fun(n-1,a);

        // MEMOIZATION

        // int []dp = new int[n+1];

        // Arrays.fill(dp,-1);
        // return fun1(n-1,a,dp);

        // TABULATION

        // return fun2(n-1,a);

        // SPACE OPTIMIZED

        return fun3(n-1,a);
    }

    // RECURSIVE

	public static int fun(int n,int []a)
	{
		if(n == 0)return 0;

        int left = 0,right = Integer.MAX_VALUE;

        left = fun(n -1,a)+Math.abs(a[n] - a[n-1]);

        if(n > 1)
        {
            right = fun(n - 2, a)+Math.abs(a[n]-a[n-2]);
        }
        return Math.min(left,right);
	}

    // MEMOIZATION

    public static int fun1(int n,int []a, int []dp)
    {
        if(n == 0)return 0;

        int left = 0,right = Integer.MAX_VALUE;

        if(dp[n] != -1)return dp[n];
        left = fun1(n -1,a,dp)+Math.abs(a[n] - a[n-1]);

        if(n > 1)
        {
            right = fun1(n - 2, a,dp)+Math.abs(a[n]-a[n-2]);
        }
        dp[n] = Math.min(left,right);
        return dp[n];
    }

    // TABULATION

    public static int fun2(int n, int []a)
    {
        int []dp = new int[n+1];

        dp[0] = 0;
        int left = 0,right = Integer.MAX_VALUE;
        for(int i = 1; i<a.length; i++)
        {
            left = dp[i -1] + Math.abs(a[i] - a[i-1]);
            if(i > 1)
            {
                right = dp[i-2] + Math.abs(a[i] - a[i-2]);
            }
            dp[i] = Math.min(left,right);
        }
        return dp[n];
    }

    // SPACE OPTIMIZED

    public static int fun3(int n, int []a)
    {
        int a1 = 0;
        int a2 = 0;

        int left = 0,right = Integer.MAX_VALUE;
        for(int i = 1; i<a.length; i++)
        {
            left = a1 + Math.abs(a[i] - a[i-1]);
            if(i > 1)
            {
                right = a2 + Math.abs(a[i] - a[i-2]);
            }
            int c = Math.min(left,right);

            a2 = a1;
            a1 = c;

        }
        return a1;
    }
    public static void main(String []args)
    {
        int []a = {10,20,30,10};
        System.out.println(frogJump(a.length,a));
    }
}