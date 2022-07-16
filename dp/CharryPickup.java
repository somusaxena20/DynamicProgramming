import java.io.*;
import java.util.*;

public class CharryPickup {

    public static int maximumChocolates(int r, int c, int[][] grid) {
        int [][][]dp = new int[r][c][c];

        for(int [][] x : dp)
        {
            for(int []y : x)
            {
                Arrays.fill(y,-1);
            }
        }
        return fun2(r,c,grid,dp);
    }

    public static int fun(int i, int j1, int j2, int r, int c, int[][] a, int [][][]dp) {
        if(j1 < 0 || j1 >= c || j2<0 || j2 >= c)
            return -(int)Math.pow(10,9);
        
        if(i == r-1)
        {
            if(j1 == j2)
            {
                return a[i][j1];
            }
            else
            {
                return a[i][j1] + a[i][j2];
            }
        }

        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;

        for(int dj1 = -1; dj1<= 1; dj1++)
        {
            for(int dj2 = -1; dj2 <= 1; dj2++)
            {
                int value = 0;

                if(j1 == j2)
                    value += a[i][j1];
                else
                    value += a[i][j1] + a[i][j2];
                
                value += fun(i + 1, j1+dj1, j2+dj2, r, c, a,dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    // TABULATION

    public static int fun2(int r, int c, int[][] a, int [][][]dp) {
        

        for(int i = 0; i<c; i++)
        {
            for(int j = 0; j<c; j++)
            {
                if(i == j)
                    dp[r-1][i][j] = a[r-1][i];
                else
                    dp[r-1][i][j] = a[r-1][i] + a[r-1][j];
            }
        }

        for(int i = r-2; i>=0; i--)
        {
            for(int j1 = 0; j1<c; j1++)
            {
                for(int j2 = 0; j2<c; j2++)
                {
                    int maxi = Integer.MIN_VALUE;

                    for(int di = -1; di<= 1; di++)
                    {
                        for(int dj = -1; dj <= 1; dj++)
                        {
                            int value = 0;

                            if(j1 == j2)
                                value += a[i][j1];
                            else
                                value += a[i][j1] + a[i][j2];
                            
                                if ((j1 + di < 0 || j1 + di >= c) ||
                                (j2 + dj < 0 || j2 + dj >= c))
                
                                value += (int) Math.pow(-10, 9);
                              else
                                value += dp[i + 1][j1 + di][j2 + dj];
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c-1];
    }

    public static void main(String[] args) throws IOException {
        int[][] a = { { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } };

        System.out.println(maximumChocolates(3,4,a));
    }
}
