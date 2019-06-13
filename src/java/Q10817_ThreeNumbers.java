import java.util.Arrays;
import java.util.Scanner;

public class Q10817_ThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte[] numbers = new byte[3];
        numbers[0] = scan.nextByte();
        numbers[1] = scan.nextByte();
        numbers[2] = scan.nextByte();

        Arrays.sort(numbers);

        System.out.println(numbers[1]);

        scan.close();
    }
}