
public class ClimbingStairs {

    // NORMAL

    // public static int climbStairs(int n) {
        
    //     if(n == 0)return 1;
        
    //     if(n == 1)return 1;
        
    //     return climbStairs(n -1)+climbStairs(n -2);
    // }

    // MEMOIZATION

    // public static int climbStairs(int n) {
        
    //         int []a = new int[n+1];
    //         Arrays.fill(a,-1);

    //         return fun(n,a);
    //     }

    // private static int fun(int n, int[] a) {
    //     if(n == 0)return 1;
    //     if(n == 1)return 1;

    //     if(a[n] != -1)return a[n];

    //     a[n] = fun(n -1,a)+fun(n-2,a);
    //     return a[n];
    // }

    // TABULATION

    // public static int climbStairs(int n) {
        
    //     int []a = new int[n+1];
    //     Arrays.fill(a,-1);

    //     a[0] = 1;
    //     a[1] = 1;

    //     for(int i = 2; i<= n; i++)
    //     {
    //         a[i] = a[i-1]+a[i-2];
    //     }

    //     return a[n];
    // }

    // SPACE OPTIMAIZATION

    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;

        int c = 0;

        for(int i = 2; i<= n; i++)
        {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String []args)
    {
        System.out.println(climbStairs(44));
    }
}
