import java.util.Arrays;

public class Fibbonachi
{

public static int fib(int n, int []a)
    {
        if(n <= 1)
            return n;
        
        if(a[n] != -1)
            return a[n];

        a[n] = fib(n-1,a) + fib(n-2,a);
        return a[n];
    }

    public static void main(String []args)
    {
        int n = 5;
        int []a = new int[n+1];
        Arrays.fill(a,-1);
        System.out.println(fib(n,a));
    }
}