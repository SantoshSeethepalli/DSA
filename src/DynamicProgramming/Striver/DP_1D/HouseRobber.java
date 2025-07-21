package DynamicProgramming.Striver.DP_1D;

public class HouseRobber {

    // version - 1: Not a circular array
    // Version - 2: Circular array

    public int houseRobber_v1(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n + 2];

        for(int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

    public int houseRobber_v2(int[] money) {

        /*
        Observation is that first and last elements
        can't co-exit in one answer
        so find individual subarray answers
        and return maximum of both as result.
        */

        int n = money.length;
        int[] dp = new int[n + 2];

        // find the maxOfNonAdjacent elements except last element
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(money[i] + dp[i + 2], dp[i + 1]);
        }
        int res = dp[0];

        // find the maxOfNonAdjacent elements except first element
        for(int i = n - 1; i>= 1; i--) {
            dp[i] = Math.max(money[i] + dp[i + 2], dp[i + 1]);
        }
        res = Math.max(res, dp[1]);

        return res;
    }
}
