package Arrays;

import java.util.Arrays;

public class Q12_Minimum_Platforms {
//    static class TrainTimings {
//        int arrival;
//        int departure;
//        TrainTimings(int arrival, int departure) {
//            this.arrival = arrival;
//            this.departure = departure;
//        }
//    }
//    static void sortArrivalAndDepartureBasedOnSort(int[] arr, int[] dep) {
//        int n = arr.length;
//
//        Q12.TrainTimings[] trainTimings = new Q12.TrainTimings[n];
//
//        for(int i = 0; i < n; i++) {
//            trainTimings[i] = new TrainTimings(arr[i], dep[i]);
//        }
//
//        Arrays.sort(trainTimings, Comparator.comparing(t -> t.arrival));;
//
//        for(int i = 0; i < n; i++) {
//            arr[i] = trainTimings[i].arrival;
//            dep[i] = trainTimings[i].departure;
//        }
//    }
//    static void addNumberToSortedStack(Stack<Integer> stack, int num) {
//        if(stack.isEmpty() || num <= stack.peek()) {
//            stack.add(num);
//            return;
//        }
//        int tempStore = stack.pop();
//        addNumberToSortedStack(stack, num);
//        stack.add(tempStore);
//    }
//    static int findPlatform(int arr[], int dep[]) {
//        if(arr.length != dep.length) {
//            return -1;
//        }
//        sortArrivalAndDepartureBasedOnSort(arr, dep);
//
//        Stack<Integer> departureTimeLog = new Stack<>();
//        int maximumPlatformsRequired = Integer.MIN_VALUE;
//
//        for(int i = 0; i < arr.length; i++) {
//            if(departureTimeLog.isEmpty()) {
//                departureTimeLog.add(dep[i]);
//            }
//            else {
//                while(!departureTimeLog.isEmpty() && departureTimeLog.peek() < arr[i]) {
//                    departureTimeLog.pop();
//                }
//                addNumberToSortedStack(departureTimeLog, dep[i]);
//            }
//            maximumPlatformsRequired = Math.max(maximumPlatformsRequired, departureTimeLog.size());
//        }
//
//        return maximumPlatformsRequired;
//    }


    static int findPlatform(int[] arr, int[] dep) {

        if(arr.length != dep.length) return -1;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;

        int maxPlatformsRequired = Integer.MIN_VALUE;
        int currentPlatforms = 0;

        int departurePointer = 0;

        for(int arrivalPointer = 0; arrivalPointer < n; arrivalPointer++) {

            // when a new train comes after the departure of old train then reduce the platform, keep on doing this
            while(departurePointer < n && arr[arrivalPointer] > dep[departurePointer]) {
                currentPlatforms--;
                departurePointer++;
            }

            // Invite all trains to the station until the first train leaves and increase the platforms
            if(arr[arrivalPointer] <= dep[departurePointer]) {
                currentPlatforms++;
                maxPlatformsRequired = Math.max(maxPlatformsRequired, currentPlatforms);
            }
        }

        return maxPlatformsRequired;
    }
}
