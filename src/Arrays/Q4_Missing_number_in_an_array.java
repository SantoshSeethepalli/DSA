package Arrays;//{ Driver Code Starts

class Q4_Missing_number_in_an_array {

    // Approach - 1
    private long findSumOfFirstKDigits(final int k) {
        return (long) k * (k + 1) / 2;
    }

    public int missingNum(int arr[]) {

        int noOfElements = arr.length + 1;

        long expectedSum = findSumOfFirstKDigits(noOfElements);

        long actualSum = 0;

        for(int num : arr) {
            actualSum += (long) num;
        }

        return (int) (expectedSum - actualSum);
    }

    // Approach - 2
    public int SpaceOptimalMissingNum(int arr[]) {
        int xorExpectedSum = 0;

        for(int i = 0; i < arr.length + 1; i++) {
            xorExpectedSum ^= (i + 1);
        }

        int xorActualSum = 0;

        for (int num : arr) {
            xorActualSum ^= num;
        }

        return xorExpectedSum ^ xorActualSum;
    }
}