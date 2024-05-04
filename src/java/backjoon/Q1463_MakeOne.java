package backjoon;

import java.util.Scanner;

public class Q1463_MakeOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X = scan.nextInt();
        int[] cache = new int[X + 1];
        cache[0] = 0;
        cache[1] = 0;

        for (int i = 2; i <= X; i++) {
            cache[i] = cache[i - 1] + 1;
            if (i % 3 == 0 && cache[i] > cache[i / 3] + 1)
                cache[i] = cache[i / 3] + 1;
            if (i % 2 == 0 && cache[i] > cache[i / 2] + 1)
                cache[i] = cache[i / 2] + 1;
        }

        System.out.println(cache[X]);
        scan.close();
    }
}
