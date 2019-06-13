import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2853_Brodovi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextInt();

        Set<Integer> ships = new HashSet<Integer>();
        for (int i = 1; i < n; i++) {
            int day = scan.nextInt() - 1;

            boolean isSameShip = false;
            for (Integer term : ships) {
                if (day % term == 0) {
                    isSameShip = true;
                    break;
                }
            }

            if (!isSameShip) {
                ships.add(day);
            }
        }

        System.out.println(ships.size());
        scan.close();
    }
}
