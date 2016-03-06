/*
Follow up for H-Index: What if the citations array is sorted in ascending order?
Could you optimize your algorithm?

Hint:
Expected runtime complexity is in O(log n) and the input is sorted.
*/
public class _275_HIndexII {

    // O(n)
    public int hIndex1(int[] citations) {
        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] < i)
                return i - 1;
        }
        return citations.length;
    }

    // O(logn)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int low = 0, high = citations.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int h = citations.length - mid;
            if (citations[mid] >= h && (mid == 0 || citations[mid - 1] < h + 1))
                return h;
            if (citations[mid] >= h)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
}