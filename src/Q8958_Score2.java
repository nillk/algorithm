import java.util.Scanner;

public class Q8958_Score2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            String str = scan.next();
            String[] split = str.split("X");
            short score = 0;
            for (String s : split) {
                int n = s.length();
                score += (n * (n + 1)) / 2;
            }

            System.out.println(score);
        }

        scan.close();
    }
}
