package backjoon;

import java.util.Scanner;

public class Q5032_SodaSurpler {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bottles = scan.nextShort() + scan.nextShort();
        short minimum = scan.nextShort();

        int count = 0;
        while (bottles >= minimum) {
            int more = bottles / minimum;
            bottles = (bottles % minimum) + more;
            count += more;
        }

        System.out.println(count);
        scan.close();
    }
}
