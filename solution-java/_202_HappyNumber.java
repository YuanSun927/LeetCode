public class _202_HappyNumber {

    public boolean isHappyNumber(int n) {
        while (n != 1 && n != 4) {
            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = temp;
        }
        return n == 1;
    }
}
