package DynamicProgramming.Striver.DP_On_SubSequences;
import java.util.*;

public class SubsetSumEqualsK {

    // Memoization
    private boolean isSubSetPossible(int idx, int[] arr, int target, HashMap<String, Boolean> map) {

        if(target == 0) return true;

        if(idx == arr.length || target < 0) return false;

        String key = idx + ", " + target;
        if(map.containsKey(key)) return map.get(key);

        boolean pick = isSubSetPossible(idx + 1, arr, target - arr[idx], map);
        boolean skip = isSubSetPossible(idx + 1, arr, target, map);

        boolean result = (pick || skip);

        map.put(key, result);

        return result;
    }
    public boolean isSubsetSum(int[] arr, int target) {

        return isSubSetPossible(0, arr, target, new HashMap<>());
    }

    // Tabulation
    public boolean isSubsetSumPossible(int[] arr, int target) {

        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int k = 0; k <= target; k++) {

                boolean notTaken = dp[i- 1][k];
                boolean taken = (k >= arr[i]) && dp[i - 1][k - arr[i]];

                dp[i][k] = (taken || notTaken);
            }
        }

        return dp[n - 1][target];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 7};
        int target = 6;

        System.out.println(new SubsetSumEqualsK().isSubsetSumPossible(arr, target));
    }
}
