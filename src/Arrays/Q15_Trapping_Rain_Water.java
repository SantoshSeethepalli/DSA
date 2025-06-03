package Arrays;

public class Q15_Trapping_Rain_Water {
    private static int findNextStreamableBuildingIndex(int[] arr, int currentBuildingIndex) {
        int max = 0;
        int maxIndex = -1;

        for (int i = currentBuildingIndex + 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }

            if (arr[i] >= arr[currentBuildingIndex]) {
                return i;
            }
        }

        return maxIndex;
    }

    private static int findCapacityBetweenBuildings(int[] arr, int currentBuildingIndex, int nextBuildingIndex) {
        if(nextBuildingIndex == -1) {
            return 0;
        }
        int currentBuildingHeight = arr[currentBuildingIndex];
        int nextBuildingHeight = arr[nextBuildingIndex];

        int maxStoringCapacity = Math.min(currentBuildingHeight, nextBuildingHeight) * (nextBuildingIndex - currentBuildingIndex - 1);

        for(int i = currentBuildingIndex + 1; i < nextBuildingIndex; i++) {
            maxStoringCapacity -= arr[i];
        }

        return maxStoringCapacity;
    }

    public static int maxWater(int[] arr) {
        int res = 0;

        int currentBuildingIndex = 0;
        int nextBuildingIndex = findNextStreamableBuildingIndex(arr, currentBuildingIndex);

        if(nextBuildingIndex == -1) {
            return 0;
        }

        while(nextBuildingIndex != -1) {
            res += findCapacityBetweenBuildings(arr, currentBuildingIndex, nextBuildingIndex);

            currentBuildingIndex = nextBuildingIndex;
            if(currentBuildingIndex >= arr.length - 2) {
                return res;
            }
            nextBuildingIndex = findNextStreamableBuildingIndex(arr, currentBuildingIndex);
        }

        return res;
    }

    public static int maxWaterDynamicProgramming(int[] arr) {
        int res = 0;

        int n = arr.length;

        // initialise dp arrays
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // fill dp arrays
        for(int i = 0; i < n; i++) {
            leftMax[i] = arr[i];
            rightMax[i] = arr[i];
        }

        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], leftMax[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], rightMax[i]);
        }

        for(int i = 1; i < n - 1; i++) {
            int maxStore = Math.min(leftMax[i], rightMax[i]);
            int currentBuildingHeight = arr[i];

            res += (maxStore - currentBuildingHeight);
        }

        return res;
    }
}
