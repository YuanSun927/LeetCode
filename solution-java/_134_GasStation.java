/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/
public class _134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stationNum = gas.length;
        int nextStart = 0;
        int start = 0;
        while (start < stationNum) {
            int pos = 0;
            int currentGas = 0;
            int j = 0;
            for (; j < stationNum; j++) {
                pos = start + j < stationNum ? start + j : start + j - stationNum;
                if (cost[pos] > gas[pos]) {
                    nextStart = (start + j + 1 < stationNum) ? pos + 1 : stationNum;
                }
                currentGas += (gas[pos] - cost[pos]);
                if (currentGas < 0) {
                    start = nextStart;
                    break;
                }
            }
            if (j == stationNum)
                return start;
        }
        return -1;
    }
}