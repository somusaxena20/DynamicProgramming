public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
        
        int sum = 0;
        
        for(int x : arr)
            sum+=x;
        if(sum % 2 == 1)return false;
        
        return spaceOpti(n,sum/2,arr);
	}
    public static boolean spaceOpti(int n, int k, int []a)
    {
        boolean []prev = new boolean[k+1];
        prev[0] = true;
        

        if(a[0]<=k)
            prev[a[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean []curr = new boolean[k+1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (a[ind] <= target)
                    pick = prev[target - a[ind]];

                boolean not = prev[target];

                curr[target] = pick || not;
            }
            prev = curr;
        }
        return prev[k];
    }
}
