package Arrays;

public class Q9_Sort012 {
    public static void sort012(int[] arr) {
        int numberOfZeros = 0;
        int numberOfOnes = 0;
        int numberOfTwos = 0;

        for(int num : arr) {
            if(num == 0) {
                numberOfZeros++;
            } else if(num == 1) {
                numberOfOnes++;
            } else {
                numberOfTwos++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(numberOfZeros != 0) {
                arr[i] = 0;
                numberOfZeros--;
            } else if(numberOfOnes != 0) {
                arr[i] = 1;
                numberOfOnes--;
            } else {
                arr[i] = 2;
            }
        }
    }

    // Dutch National Flag Approach:
    public static void secondApproachForSort012(int[] nums) {
        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = nums.length - 1;

        while(onePointer <= twoPointer) {
            if(nums[onePointer] == 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[onePointer];
                nums[onePointer] = temp;

                zeroPointer++;
                onePointer++;
            }
            else if(nums[onePointer] == 1) {
                onePointer++;
            }
            else {
                int temp = nums[twoPointer];
                nums[twoPointer] = nums[onePointer];
                nums[onePointer] = temp;

                twoPointer--;
            }

            System.out.println(zeroPointer + ", " + onePointer + ", " + twoPointer);
            for(int a : nums) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
}
