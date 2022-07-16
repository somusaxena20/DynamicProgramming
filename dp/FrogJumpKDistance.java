public class FrogJumpKDistance {

    public static int jumpKDistance(int[] a) {
        int []dp = new int[a.length];
        java.util.Arrays.fill(dp,-1);
        return fun(a, a.length-1, 2,dp);
    }

    // RECURSIVE + MEMOIZATION

    public static int fun(int[] a, int ind, int k,int []dp) {
        if (ind == 0)
            return 0;
        if(dp[ind] != -1)return dp[ind];
        int minStep = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = fun(a, ind - j, k,dp) + Math.abs(a[ind] - a[ind - j]);
                minStep = Math.min(minStep, jump);
            }
        }
        return dp[ind] = minStep;
    }

    // TABULATION

    // public static int fun1(int []a,)

    public static void main(String[] args) {
        int []a = {30,10,60 , 10 , 60 , 50};
        System.out.println(jumpKDistance(a));

    }
}
