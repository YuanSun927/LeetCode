/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class _70_ClimbingStairs {

	public int climbStairs(int n) {
        if (n < 1)
        	return 0;
        if (n <= 2)
        	return n;
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
        	a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}