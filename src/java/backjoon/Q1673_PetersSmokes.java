package backjoon;

import java.util.Scanner;

public class Q1673_PetersSmokes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int chicken = n;
            int coupon = n;
            while (coupon / k > 0) {
                int more = coupon / k;
                chicken += more;
                coupon %= k;
                coupon += more;
            }

            System.out.println(chicken);
        }
    }
}
