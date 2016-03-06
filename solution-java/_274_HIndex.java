/*
Given an array of citations (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5],
which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each,
his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:
An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/
public class _274_HIndex {

    // Sort
    // Time  O(nlogn) 
    // Space O(1)
    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] < i)
                return i - 1;
        }
        return citations.length;
    }

    // Sort & Binary Search
    // Time  O(nlogn) 
    // Space O(1)
    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
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

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        return 0;
    }
}