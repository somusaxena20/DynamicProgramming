public class BestTimeToBuy {
    public static int maxProfit(int[] a) {
        int min = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<a.length; i++)
        {
            if(a[i] < min)
                min = a[i];
            
            if(min - a[i] > max)
            {
                max = a[i] - min;
            }
        }
        return max;
       
    }
    public static void main(String []args)
    {
        int []a = {};
        System.out.println(maxProfit(a));
    }
}
