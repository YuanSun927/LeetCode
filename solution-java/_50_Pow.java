/*
Implement pow(x, n).
*/
public class _50_Pow {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
    }
}