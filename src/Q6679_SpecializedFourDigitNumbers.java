public class Q6679_SpecializedFourDigitNumbers {

    public static void main(String[] args) {
        System.out.println(2992);

        for (int num = 2993; num < 10000; num++) {
            if (isSpecializedFourDigitNumber(num)) {
                System.out.println(num);
            }
        }
    }

    private static boolean isSpecializedFourDigitNumber(int num) {
        int duodecimalSum = digitSum(num, 12);
        if (digitSum(num, 10) == duodecimalSum && duodecimalSum == digitSum(num, 16)) {
            return true;
        }
        return false;
    }

    private static int digitSum(int num, int base) {
        int sum = 0;
        while (num > base) {
            sum += num % base;
            num /= base;
        }
        sum += num;

        return sum;
    }
}
