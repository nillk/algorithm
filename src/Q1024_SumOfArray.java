import java.util.Scanner;

public class Q1024_SumOfArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        byte l = scan.nextByte();

        boolean isFind = false;
        for (int length = l; length <= 100; length++) {
            int additional = (length * (length - 1)) / 2;
            int x = n - additional;
            if (x < 0) break;
            if (x == 0 || x % length == 0) {
                int start = x / length;
                for (int i = 0; i < length; i++) {
                    System.out.print(start + i + " ");
                }
                isFind = true;
                break;
            }
        }

        if (!isFind) {
            System.out.println(-1);
        }

        scan.close();
    }
}
