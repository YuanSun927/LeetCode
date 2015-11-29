/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
*/
public class _264_UglyNumberII {

	// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
    // Time Limit Exceeded
    public int nthUglyNumber1(int n) {
        if (n < 1)
            return 0;
        if (n > 0 && n < 6)
            return n;
        Set<Integer> dp = new HashSet<>();
        dp.add(1);
        dp.add(2);
        dp.add(3);
        dp.add(4);
        dp.add(5);
        int nth = 5;
        int i = 6;
        int nthNum = 0;
        while (nth < n) {
            if (i % 2 == 0) {
                if (dp.contains(i / 2)) {
                    nth++;
                    dp.add(i);
                    nthNum = i;
                }
            } else if (i % 3 == 0) {
                if (dp.contains(i / 3)) {
                    nth++;
                    dp.add(i);
                    nthNum = i;
                }
            } else if (i % 5 == 0) {
                if (dp.contains(i / 5)) {
                    nth++;
                    dp.add(i);
                    nthNum = i;
                }
            }
            i++;
        }
        return nthNum;
    }
    
    public int nthUglyNumber(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int index = 1;
        int nthNum = 0;
        int lastVal = 0;
        while (index < n) {
            int val2 = list.get(idx2) * 2;
            int val3 = list.get(idx3) * 3;
            int val5 = list.get(idx5) * 5;
            if (val2 <= val3 && val2 <= val5) {
                nthNum = val2;
                idx2++;
            } else if (val3 <= val2 && val3 <= val5) {
                nthNum = val3;
                idx3++;
            } else {
                nthNum = val5;
                idx5++;
            }
            if (nthNum != lastVal) {
                list.add(nthNum);
                index++;
            }
            lastVal = nthNum;
        }
        return nthNum;
    }
}