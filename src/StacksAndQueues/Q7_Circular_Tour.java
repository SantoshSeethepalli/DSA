package StacksAndQueues;

public class Q7_Circular_Tour {

    // O(n^2)
    public int myStartStation(int[] gas, int[] cost) {

        int n = gas.length;

        for(int currentIndex = 0; currentIndex < n; currentIndex++) {
            if(gas[currentIndex] >= cost[currentIndex]) {

                int possibleCircuitIndex = canMakeCircuit(gas, cost, currentIndex, n);

                if(possibleCircuitIndex != -1) return possibleCircuitIndex;
            }
        }

        return -1;
    }

    public int canMakeCircuit(int[] gas, int[] cost, int index, int n) {

        int gasRemaining = gas[index] - cost[index];

        int circularIndex = (index + 1) % n;

        while(circularIndex != index) {
            gasRemaining += gas[circularIndex] - cost[circularIndex];

            if(gasRemaining < 0) {
                return -1;
            }

            circularIndex = (circularIndex + 1) % n;
        }

        return index;
    }


    public int startStation(int[] fuel, int[] cost) {

        int n = fuel.length;
        int totalFuelUsed = 0;
        int currentFuelAvailable = 0;
        int circuitStartIndex = 0;

        for(int i = 0; i < n; i++) {
            int currentGain = fuel[i] - cost[i];

            totalFuelUsed += currentGain;
            currentFuelAvailable += currentGain;

            if(currentFuelAvailable < 0) {
                circuitStartIndex = i + 1;
                currentFuelAvailable = 0;
            }
        }

        if(totalFuelUsed < 0) return -1;

        return circuitStartIndex;
    }
}
