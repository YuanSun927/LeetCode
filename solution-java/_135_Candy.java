/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class _135_Candy {

    public int candy(int[] ratings) {
        int sum = 1;
        int lastPeak = 0;
        int lastPeakCandy = 1;
        int last = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sum += ++last;
                lastPeak = i;
                lastPeakCandy = last;
            } else if (ratings[i] < ratings[i - 1]) {
                sum += (i - lastPeak) < lastPeakCandy ? i - lastPeak : i - lastPeak + 1;
                last = 1;
            } else {
                lastPeak = i - 1;
                lastPeakCandy = Integer.MAX_VALUE;
                sum++;
                last = 1;
            }
        }
        return sum;
    }
}