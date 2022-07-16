public class PartitionSubsetMinimumDiff {
    public static int minSubsetSumDifference(int[] a, int n) {
		int totalSum = 0;

        for(int x : a)
        {
            totalSum += x;
        }

        int k = totalSum;


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
        int mini = Integer.MAX_VALUE;
        for(int s1 = 0; s1<=totalSum/2; s1++)
        {
            if(prev[s1] == true)
            {
                mini = Math.min(mini,(totalSum - s1)-s1);
            }
        }
        return mini;
	}

    public static void main(String []args)
    {
        int []a = {1, 2, 3, 4};
        System.out.println(minSubsetSumDifference(a,a.length));
    }
}
