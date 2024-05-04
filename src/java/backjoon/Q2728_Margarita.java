package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2728_Margarita {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        int[] solution = new int[t];

        for (int i = 0; i < t; i++) {
            byte theNumberOfMargarita = scan.nextByte();
            int money = scan.nextInt();
            int[] margaritas = new int[theNumberOfMargarita];
            for (byte j = 0; j < theNumberOfMargarita; j++) {
                margaritas[j] = scan.nextInt();
            }

            Arrays.sort(margaritas);
            solution[i] = combinationOfMargarita(margaritas, money);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(solution[i]);
        }
    }

    private static int combinationOfMargarita(int[] margaritas, int money) {
        int[] combinationCount = new int[money + 1]; // money 크기 만큼의 배열 각각의 index 위치에 index만큼의 돈이 들어갈 수 있는 조합의 수를 저장

        int combination = 0;
        for (int i = 0; i < margaritas.length; i++) {
            clearCombinationCount(combinationCount);
            if (setInitializeValue(i, margaritas, money, combinationCount)) {
                setCombinationCount(margaritas, money, combinationCount, i);
                combination += calculateCombinationCount(margaritas, money, combinationCount, money - margaritas[i]);
            }
        }

        return combination;
    }

    private static void clearCombinationCount(int[] combinationCount) {
        for (int i = 0; i < combinationCount.length; i++) {
            combinationCount[i] = 0;
        }
    }

    private static boolean setInitializeValue(int sectionIndex, int[] margaritas, int money, int[] comb) {
        int sumOfPrice = 0;
        for (int i = 0; i < sectionIndex; i++) {
            sumOfPrice += margaritas[i];
        }

        if (sumOfPrice <= money) {
            comb[sumOfPrice] = 1;
            return true;
        }

        return false;
    }

    private static void setCombinationCount(int[] margaritas, int money, int[] combinationCount, int i) {
        for (int j = i + 1; j < margaritas.length; j++) {
            int targetPrice = margaritas[j];
            for (int moneyIndex = money; moneyIndex - targetPrice >= 0; moneyIndex--) {
                combinationCount[moneyIndex] += combinationCount[moneyIndex - targetPrice];
            }
        }
    }

    private static int calculateCombinationCount(int[] margaritas, int money, int[] combinationCount, int minPrice) {
        int combination = 0;
        for (int k = money; k > minPrice && k > 0; k--) {
            combination += combinationCount[k];
        }
        return combination;
    }
}