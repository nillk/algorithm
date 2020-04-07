import java.util.Scanner;

public class Q8958_Score {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            String str = scan.next();
            int length = str.length();
            short total = 0;
            byte score = 0;
            for (byte i = 0; i < length; i++) {
                if (str.charAt(i) == 'O') {
                    total += ++score;
                } else {
                    score = 0;
                }
            }

            System.out.println(total);
        }
    }
}
