/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class _69_Sqrt {
    
    public int mySqrt(int x) {
        if (x <= 0)
            return 0;
        return sqrt(x, 1, x);
    }

    public int sqrt(int x, int low, int high) {
        if (high - low <= 1)
            return low;
        int mid = low + ((high - low) >> 1);
        if (x / mid == mid)
            return mid;
        else if (x / mid > mid)
            return sqrt(x, mid, high);
        else
            return sqrt(x, low, mid);
    } 
}