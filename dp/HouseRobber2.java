import java.util.Arrays;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int []a = Arrays.copyOfRange(nums,0,nums.length-1);
        int []b = Arrays.copyOfRange(nums,1,nums.length);
        
        return Math.max(solve4(a) , solve4(b));
    }
    public static int solve4(int []a) {
        
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
